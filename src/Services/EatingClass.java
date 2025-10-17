package Services;

public class EatingClass extends ServiceAbstractClass implements Eating{

    private int numOfPeople;
    private final int capacity;
    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param capacity     the capacity of the service
     * @param name      the name of the service
     * @param type      the type of the service
     */
    public EatingClass(long latitude, long longitude, int price, int capacity, String name, String type) {
        super(latitude, longitude, price, name, type);
        this.numOfPeople = 0;
        this.capacity = capacity;
    }

    @Override
    public boolean isFull() {
        return this.numOfPeople == capacity;
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
