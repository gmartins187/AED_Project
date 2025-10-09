package Regions;

import java.io.File;

public interface Region {

    /**
     * Saves the region to a file named the name of the region
     * @param file the file to save to
     */
    void save(File file);

    /**
     * @return 's the name of the file
     */
    String getName();
}
