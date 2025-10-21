package App.Services;

import App.Services.Reviews.Review;
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

        this.reviewCounter = 0;
        reviews = new ListInArray<>(INITIAL_CAPACITY);
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
        reviews.add(reviewCounter++, review);
        calculateAverage(review);
    }

    /**
     * calculates and updates the average review
     */
    private void calculateAverage(Review review) {
        long newAverage = (averageRating+ (reviewCounter - 1) + review.getNumRate()) / reviewCounter;
        if(Math.round(newAverage) != Math.round(averageRating)){
            averageRating = newAverage;
            this.myOrder = orderOfInsertion;
        }
    }
}
