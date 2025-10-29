package App.Services;

import App.Students.Student;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.ListInArray;

public abstract class ServiceAbstractClass implements Service {

    private static int orderOfInsertion;
    private int myOrder;

    private final long latitude;
    private final long longitude;
    private final String type;


    private final int price;
    private final String name;


    private final int INITIAL_CAPACITY = 100;
    private List<Review> reviews;
    private int reviewCounter;

    private long averageRating;

    /**
     * Constructor for ServiceAbstractClass.
     * @param latitude the latitude of the service
     * @param longitude the longitude of the service
     * @param price the price of the service
     * @param name the name of the service
     */
    public ServiceAbstractClass(long latitude, long longitude, int price, String name, String type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.name = name;
        this.type = type;

        this.orderOfInsertion = 0;

        reviews = new DoublyLinkedList<>();

        reviewCounter = 1;
        averageRating = 4;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public long getLatitude(){
        return this.latitude;
    }

    @Override
    public long getLongitude(){
        return this.longitude;
    }

    @Override
    public int getPrice(){
        return this.price;
    }

    @Override
    public void addReview(Review review){
        reviews.addLast(review);
        reviewCounter++;
        calculateAverage(review);
    }

    @Override
    public int getOrder(){
        return this.myOrder;
    }

    @Override
    public long getAverageRating(){
        return this.averageRating;
    }

    /**
     * Adds a new review and recalculates the average rating.
     * Updates the insertion order only if the average changes by a significant amount.
     */
    public void calculateAverage(Review review) {
        // Define how much the average must change to be considered "new"
        // (This avoids tiny changes like 4.33333... vs 4.33334...)
        final double CHANGE_THRESHOLD = 0.01;

        // --- Standard Average Calculation ---
        long currentTotalSum = this.averageRating * this.reviewCounter;
        long newRating = review.getNumRate();
        this.reviewCounter++;
        long newAverage = (currentTotalSum + newRating) / this.reviewCounter;

        // --- Using Math.abs() to Check the Difference ---
        // This is the correct and logical use case.
        // We check if the *absolute difference* is greater than our threshold.
        if (Math.abs(newAverage - this.averageRating) > CHANGE_THRESHOLD) {
            // The average changed significantly, so update order
            orderOfInsertion = orderOfInsertion + 1;
            this.myOrder = orderOfInsertion;
        }

        // Always update the average, regardless of the 'if' check
        this.averageRating = newAverage;
    }

    @Override
    public boolean isTagged(String tag){
        Iterator<Review> it = reviews.iterator();
        while(it.hasNext())
            if(it.next().getTag().trim().equalsIgnoreCase(tag.trim())) return true;

        return false;
    }

    @Override
    public long getDistance(Student student){
        return Math.abs(this.latitude - student.getLocation().getLatitude())
                + Math.abs(this.longitude - student.getLocation().getLongitude());
    }
}
