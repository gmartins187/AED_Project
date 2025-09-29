package App;
import Exceptions.*;


public interface HomeAwayApp {


    /**
     * Introduces a new region to the app
     * @param top the top boundary
     * @param left the left boundary
     * @param bottom the bottom boundary
     * @param right the right boundary
     * @throws InvalidArea if the area is invalid
     * @throws AlreadyExists if the area already exists
     */
    void newArea(int top, int left, int bottom, int right);

    /**
     * Saves the current region to a text file
     * @throws NoCurrentArea if there is no current area defined
     */
    void saveArea();


    /**
     * Loads the region from a text file
     * @param areaName the name of the area to load
     * @throws InvalidArea if the area does not exist
     */
    void loadArea(String areaName);


    /**
     * Creates and adds a new service in the app
     * @param latitude the latitude of the service
     * @param longitude the longitude of the service
     * @param price the price of the service
     * @param value the discount of the service
     * @param name the name of the service
     * @throws InvalidType if there is no type that matches
     * @throws InvalidLocation if the location is invalid
     * @throws InvalidPrice if the price is less or equal to 0
     * @throws InvalidValue if the discount on the menu is less than 0 or greater than 100
     * @throws AlreadyExists if the service already exists
     */
    void newEatingService(int latitude, int longitude, int price, int value, String name);
}
