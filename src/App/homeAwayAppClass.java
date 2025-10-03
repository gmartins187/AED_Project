package App;

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
    public void newEatingService(int latitude, int longitude, int price, int value, String name) {

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
}
