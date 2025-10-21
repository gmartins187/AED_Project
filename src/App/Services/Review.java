package App.Services;

public interface Review {

    /**
     * @return the numeric rating stored in the review
     */
    int getNumRate();

    /**
     * @return the tag of the review
     */
    String getTag();
}
