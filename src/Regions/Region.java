package Regions;

import Ethnicities.Ethnicity;
import Services.LodgingClass;
import Services.Service;
import Students.OutgoingClass;
import Students.Student;

import java.io.Serializable;

public interface Region {


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
     * @param studentName the name of the student
     * @return the student
     */
    Student getStudent(String studentName);

    /**
     * adds a student to the region
     *
     * @param student the student to add to the region
     */
    void addStudent(Student student);

    /**
     * @return the ethnicity object
     */
    Ethnicity getEthnicity(String country);

    /**
     * @param name the name of the service
     * @return if a service is full
     */
    boolean isServiceFull(String name);
}
