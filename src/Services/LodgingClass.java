package Services;

public class LodgingClass extends ServiceAbstractClass implements Lodging {

    private int numOfPeople;
    private final int capacity;

    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param name      the name of the service
     * @param type      the type of the service
     */
    public LodgingClass(long latitude, long longitude, int price, int capacity, String name, String type) {
        super(latitude, longitude, price, name, type);
        this.capacity = capacity;
        this.numOfPeople = 0;
    }


    @Override
    public boolean isFull() {
        return numOfPeople == capacity;
    }

    @Override
    public void addStudent() {
        this.numOfPeople++;
    }

    @Override
    public void removeStudent() {
        this.numOfPeople--;
    }
}
