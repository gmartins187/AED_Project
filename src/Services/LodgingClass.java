package Services;

public class LodgingClass extends ServiceAbstractClass implements Service {
    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param value     the value of the service
     * @param name      the name of the service
     */
    public LodgingClass(int latitude, int longitude, int price, int value, String name) {
        super(latitude, longitude, price, value, name);
    }
}
