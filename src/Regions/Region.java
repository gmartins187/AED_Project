package Regions;

import Services.Service;
import Students.Student;

import java.io.Serializable;

public interface Region extends Serializable {


    /**
     * @return the name of the region
     */
    String getName();

    /**
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @return if a service is in the region
     */
    boolean isValid(long latitude, long longitude);

    /**
     * @param name the name of the region
     * @return if the service exists in the region
     */
    Service getService(String name);

    /**
     * adds a service to the region
     *
     * @param service the service to add to the region
     */
    void addService(Service service);

    /**
     * @return if there is any service
     */
    boolean hasServices();

    /**
     * Iterates all the services in the current region loaded
     */
    void listAllServices();

    /**
     * adds a student to the region
     *
     * @param student the student to add to the region
     */
    void addStudent(Student student);

    /**
     * @return the ethnicity object
     */

    boolean hasEthnicity(String country);

    /**
     * @param name the name of the service
     * @return if a service is full
     */
    boolean isServiceFull(String name);

    /**
     * @return the student ub the region by name
     */
    Student getStudent(String name);

    /**
     * removes student from the current region
     * @param name the name of the student to remove
     */
    void removeStudent(String name);

    /**
     * @param lodgingName the name of the lodge
     * @return true if it exists
     */
    boolean hasLodging(String lodgingName);

    /**
     * @return true if it has students
     */
    boolean hasStudents();

    /**
     * @param country the 'ethnicity' to add
     */
    void addEthnicity(String country);

    /**
     * list all the students from the region
     * @param from the ethnicity of the students to iterate
     */
    void listStudents(String from);

    /**
     * lists all the users in a service by a specific order
     * @param service the users must be in this service
     * @param order the specific order to iterate(from oldest to newest or reverse)
     */
    void listUsersIn(Service service, String order);

    /**
     * prints to the console where is the student
     * @param student the student to search for
     */
    void whereStudent(Student student);
}
