package App;

import Exceptions.*;
import Regions.*;

public class homeAwayAppClass implements HomeAwayApp{

    private static Region currentRegion;

    /**
     * Constructor for homeAwayAppClass (App)
     */
    public homeAwayAppClass() {
        currentRegion = null;
    }


    @Override
    public void newArea(int top, int left, int bottom, int right, String name) {

    }

    @Override
    public void saveArea() {

    }

    @Override
    public void loadArea(String areaName) {

    }

    @Override
    public void listAllServices() {

    }

    @Override
    public void newStudent(String type, String name, String country, String lodgingName) {

    }

    @Override
    public void removeStudent(String name) {

    }

    @Override
    public void changeStudentLocation(String name, String locationName) {

    }

    @Override
    public void listStudents(String from) {

    }

    @Override
    public void changeStudentHome(String name, String lodgingName) {
    }

    @Override
    public void newService(int latitude, int longitude, int value1, int value2, String name) {

    }

    @Override
    public void listUsersInService(String order, String serviceName) {

    }

    @Override
    public void locateStudent(String name) {

    }

    @Override
    public void listVisitedLocations(String name) {

    }

    @Override
    public void rateService(String name, int numericRate, String tag) {

    }

    @Override
    public void listServicesByRating() {

    }

    @Override
    public void listServicesByTypeAndRating(int numericRate, String type, String studentName) throws InvalidValue, DoesNotExist, InvalidType, Untouched, ServiceFull {

    }

    @Override
    public void allServicesWithTag(String tag) throws Untouched {

    }

    @Override
    public void mostRelevantService(String studentName, String type) throws InvalidType, DoesNotExist, Untouched {

    }
}
