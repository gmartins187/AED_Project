package App;

import Ethnicities.Ethnicity;
import Ethnicities.EthnicityClass;
import Exceptions.*;
import Regions.*;
import Services.EatingClass;
import Services.LeisureClass;
import Services.LodgingClass;
import Services.Service;
import Students.BookishClass;
import Students.OutgoingClass;
import Students.ThriftyClass;

import java.io.*;

public class homeAwayAppClass implements HomeAwayApp{

    private Region currentRegion;

    private final String EATING = "eating";
    private final String LODGING = "lodging";
    private final String LEISURE = "leisure";

    private final String THRIFTY = "thrifty";
    private final String BOOKISH = "bookish";
    private final String OUTGOING = "outgoing";


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
    public void newService(String type, long latitude, long longitude, int price, int value2, String name) {
        if(!isSerTypeValid(type))
            throw new InvalidService("");
        else if(!this.currentRegion.isValid(latitude,longitude))
            throw new InvalidLocation("");
        else if(price == 0)
            throw new InvalidPrice("");
        else if(type.equals(LEISURE))
            if(!(0 <= value2 && value2 <= 100)) throw new InvalidValue("");
        else if(value2 == 0)
            throw new InvalidValue("");
        if(this.currentRegion.getService(name) == null)
            throw new AlreadyExists("");
        else {
            switch (type) {
                case LEISURE -> this.currentRegion.addService(new LeisureClass(latitude, longitude, price, value2, name, type));
                case EATING -> this.currentRegion.addService(new EatingClass(latitude,longitude,price,value2,name, type));
                case LODGING -> this.currentRegion.addService(new LodgingClass(latitude,longitude,price,value2,name, type));
            }
        }
    }

    /**
     * @param type the type to check
     * @return if the type of service is valid
     */
    private boolean isSerTypeValid(String type) {
        return type.equals(EATING) || type.equals(LODGING) || type.equals(LEISURE);
    }


    @Override
    public void listAllServices() {
        if(!this.currentRegion.hasServices())
            throw new DoesNotExist("");
        else
            this.currentRegion.listAllServices();
    }

    @Override
    public void newStudent(String type, String name, String country, String lodgingName) {
        if(!isStuTypeValid(type))
            throw new InvalidType("");
        //else if(TODO filter iterator)
        //    throw new InvalidLocation("");
        else if(this.currentRegion.isServiceFull(lodgingName))
            throw new ServiceFull("");
        else if(this.currentRegion.getStudent(name) == null)
            throw new AlreadyExists("");
        else {
            Service lodgingService = this.currentRegion.getService(lodgingName);
            Ethnicity ethnicity = this.currentRegion.getEthnicity(country);
            switch (type){
                case OUTGOING -> this.currentRegion.addStudent(new OutgoingClass(name, ethnicity, lodgingService));
            }
        }
    }

    /**
     * @param type the type to check
     * @return if this student type is valid
     */
    private boolean isStuTypeValid(String type) {
        return type.equals(BOOKISH) || type.equals(OUTGOING) || type.equals(THRIFTY);
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
