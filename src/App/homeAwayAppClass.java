package App;

import Exceptions.*;
import Regions.*;

import java.io.*;

public class homeAwayAppClass implements HomeAwayApp{

    private static Region currentRegion;

    /**
     * Constructor for homeAwayAppClass (App)
     */
    public homeAwayAppClass() {
        currentRegion = null;
    }


    @Override
    public void newArea(long top, long left, long bottom, long right, String name)
            throws InvalidArea, AlreadyExists{
        if(fileExists(name)){
            throw new AlreadyExists("");
        }else if(validArea(top,left,bottom,right)){
            throw new InvalidArea("");
        }else {
            currentRegion = new RegionClass(top, bottom, left, right, name);
        }
    }

    @Override
    public String saveArea() throws NoCurrentArea {
        if(currentRegion == null)
            throw new NoCurrentArea("");
        else {
            String areaName = currentRegion.getName();
            try {
                File dataFolder = new File("data");

                if (!dataFolder.exists()) dataFolder.mkdir();

                File file = new File(dataFolder, currentRegion.getName().replace(" ",""));

                FileOutputStream output = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(output);

                out.writeObject(currentRegion);

                out.close();
                output.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            currentRegion = null;
            return areaName;
        }
    }

    @Override
    public void loadArea(String regionName) throws NoCurrentArea{
        File file = new File("data", regionName.replace(" ", ""));

        if (!file.exists()) throw new NoCurrentArea("");

        try (FileInputStream input = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(input)) {

            // Lê o objeto
            currentRegion = (Region) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    @Override
    public String getAreaName() {
        return currentRegion.getName();
    }


    /**
     * Função privada que verifica se o ficheiro existe na pasta "data"
     * @param fileName nome do ficheiro
     * @return true se existir, false caso contrário
     */
    private static boolean fileExists(String fileName) {
        File file = new File("data", fileName);
        return file.exists();
    }

    /**
     * @param top the top bound
     * @param left the left bound
     * @param bottom the bottom bound
     * @param right the right bound
     * @return if the area is valid
     */
    private boolean validArea(long top, long left, long bottom, long right) {
        return top <= bottom && left <= right;
    }
}
