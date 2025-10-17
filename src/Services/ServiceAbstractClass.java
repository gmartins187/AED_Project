package Services;

import Reviews.Review;
import dataStructures.List;
import dataStructures.ListInArray;

public abstract class ServiceAbstractClass implements Service {

    private final long latitude;
    private final long longitude;
    private final String type;


    private final int price;
    private final String name;


    private List<Review> reviews;
    private int numberOfRatings;
    private int averageRating;

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

        this.numberOfRatings = 0;

        reviews = new ListInArray<>(numberOfRatings);
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
}
