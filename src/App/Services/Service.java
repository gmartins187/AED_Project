package App.Services;

import App.Services.Reviews.Review;
import App.Students.Student;

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

    /**
     * @return the price of the service
     */
    int getPrice();

    /**
     * @return if the service is full
     */
    boolean isFull();

    /**
     * @param student the student to add
     * adds a student to the counter
     */
    void addStudent(Student student);

    /**
     * @param student the student to remove
     * removes a student to the counter
     */
    void removeStudent(Student student);

    /**
     * adds a review to the service
     * @param review the review which is composed by a numeric and text review
     */
    void addReview(Review review);
}
