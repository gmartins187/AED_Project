package Places;

public abstract class ServicesAbstractClass implements Services{

    private final int latitude;
    private final int longitude;
    private final int price;
    private final int value;
    private final String name;


    public ServicesAbstractClass(int latitude, int longitude, int price, int value, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.value = value;
        this.name = name;
    }
}
