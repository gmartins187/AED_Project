package Services;

public class EatingClass extends ServiceAbstractClass implements Eating{
    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param value     the value of the service
     * @param name      the name of the service
     * @param type      the type of the service
     */
    public EatingClass(long latitude, long longitude, int price, int value, String name, String type) {
        super(latitude, longitude, price, value, name, type);
    }
}
