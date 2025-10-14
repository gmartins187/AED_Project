package Services;

public interface Service {

    /**
     * @return the name of the service
     */
    String getName();

    /**
     * @return the type of the service
     */
    String getType();

    /**
     * @return the latitude of the service
     */
    long getLatitude();

    /**
     * @return the longitude of the service
     */
    long getLongitude();
}
