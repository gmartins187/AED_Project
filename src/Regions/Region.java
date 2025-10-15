package Regions;

import java.io.File;
import java.io.Serializable;

public interface Region extends Serializable {


    /**
     * @return 's the name of the file
     */
    String getName();

    /**
     * Saves the current region to a file in data/ path directory
     */
    void save();

    /**
     * Loads a region to the memory
     */
    void loadRegion();
}
