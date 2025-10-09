package App;

import Exceptions.*;
import Regions.*;

import java.io.File;
import java.io.FileOutputStream;

public class homeAwayAppClass implements HomeAwayApp{

    private static Region currentRegion;

    /**
     * Constructor for homeAwayAppClass (App)
     */
    public homeAwayAppClass() {
        currentRegion = null;
    }


    @Override
    public void newArea(int top, int left, int bottom, int right, String name) throws InvalidArea, AlreadyExists{
        if(getFile(name).exists()){
            throw new AlreadyExists("");
        }else if(validArea(top,left,bottom,right)){
            throw new InvalidArea("");
        }else {
            currentRegion = new RegionClass(top, bottom, left, right, name);
        }
    }


    @Override
    public void saveArea() {
        if(currentRegion == null)
            throw new NoCurrentArea("");
        else {
            currentRegion.save(getFile(currentRegion.getName()));
            currentRegion = null;
        }
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


    /**
     * @param name the name of the possible new region
     * @return the
     */
    private File getFile(String name) {
        String fileName = name.replace(" ", "");
        return new File ("data" + File.separator + fileName + ".ser");
    }

    /**
     * @param top the top bound
     * @param left the left bound
     * @param bottom the bottom bound
     * @param right the right bound
     * @return if the area is valid
     */
    private boolean validArea(int top, int left, int bottom, int right) {
        return top <= bottom && left <= right;
    }
}
