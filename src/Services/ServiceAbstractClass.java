package Services;

import Reviews.Review;
import dataStructures.List;
import dataStructures.ListInArray;

public abstract class ServiceAbstractClass implements Service {

    private final int latitude;
    private final int longitude;


    private final int price;
    private final int value;
    private final String name;


    private List<Review> reviews;
    private int numberOfRatings;
    private int averageRating;

    /**
     * Constructor for ServiceAbstractClass.
     * @param latitude the latitude of the service
     * @param longitude the longitude of the service
     * @param price the price of the service
     * @param value the value of the service
     * @param name the name of the service
     */
    public ServiceAbstractClass(int latitude, int longitude, int price, int value, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.value = value;
        this.name = name;

        this.numberOfRatings = 0;

        reviews = new ListInArray<>(numberOfRatings);
    }
}
