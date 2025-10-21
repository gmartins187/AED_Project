package App.Services.Reviews;

public class ReviewClass implements Review{

    int numericRating;
    String textReview;


    /**
     * Constructor for ReviewClass.
     * @param numericRating the numeric rating of the review
     * @param textReview the tag of the review
     */
    public ReviewClass(int numericRating, String textReview) {
        this.numericRating = numericRating;
        this.textReview = textReview;
    }

    @Override
    public int getNumRate() {
        return numericRating;
    }
}
