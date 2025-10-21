package App.Services;

import dataStructures.Comparator;

public class ServicesComparator implements Comparator<Service>{

    /**
     * Compares two services by rate and order in which got the rating average
     * @param x
     * @param y
     * @return
     */
    @Override
    public int compare(Service x, Service y) {
        int ratingCompare = Double.compare(y.getAverageRating(), x.getAverageRating());
        if (ratingCompare != 0) {
            return ratingCompare;
        }
        return Integer.compare(x.getOrder(), y.getOrder());
    }
}
