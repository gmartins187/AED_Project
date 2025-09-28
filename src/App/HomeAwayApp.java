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
}
