package Regions;

import java.io.File;

public interface Region {


    /**
     * @return 's the name of the file
     */
    String getName();

    /**
     * Saves the current region to a file in data/ path directory
     * @param name the name of the region
     */
    void save(String name);

    /**
     * Loads a region to the memory
     */
    void loadRegion();
}
