package App.Services;

import App.Students.Student;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;

public abstract class ServiceAbstractClass implements Service {

    public static int orderOfInsertion;
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
    private long totalRatingSum;

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

        this.myOrder = orderOfInsertion++;

        reviews = new DoublyLinkedList<>();

        reviewCounter = 1;
        averageRating = 4;
        totalRatingSum = 4;
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
        //orderOfInsertion++;
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

        this.totalRatingSum += review.getNumRate();
        this.reviewCounter++;

        double trueAverage = (double) this.totalRatingSum / this.reviewCounter;

        if(Math.round(trueAverage) != this.averageRating){
            this.myOrder = orderOfInsertion++;
            this.averageRating = Math.round(trueAverage);
        }

    }

    @Override
    public boolean isTagged(String tag){
        Iterator<Review> it = reviews.iterator();
        while(it.hasNext()) {

            String reviewText = it.next().getTag();

            if (myContainsIgnoreCase(reviewText, tag)) {
                return true;
            }
        }
        return false;
    }

    private boolean myContainsIgnoreCase(String reviewText, String tag){
        String[] words = reviewText.split(" +");

        for (String word : words) {
            if (word.equalsIgnoreCase(tag)) {
                return true;
            }
        }

        return false;
    }


    @Override
    public long getDistance(Student student){
        return Math.abs(this.latitude - student.getLocation().getLatitude())
                + Math.abs(this.longitude - student.getLocation().getLongitude());
    }
}
