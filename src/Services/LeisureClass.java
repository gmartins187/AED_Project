package Services;

public class LeisureClass extends ServiceAbstractClass implements Leisure{
    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param name      the name of the service
     * @param type      the type of the service
     */
    public LeisureClass(long latitude, long longitude, int price, int value, String name, String type) {
        super(latitude, longitude, price, name, type);
    }

    @Override
    public void addStudent() {
    }

    @Override
    public void removeStudent() {
    }
}
