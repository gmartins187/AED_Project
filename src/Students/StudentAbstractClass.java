package Students;

import Ethnicities.Ethnicity;
import Services.*;
import dataStructures.*;

public abstract class StudentAbstractClass implements Student{

    private Lodging home;
    private Service Location;

    private String type;
    private String name;
    private Ethnicity ethnicity;

    private int numberOfServicesVisited;
    private List<Service> visitedServices;


    /**
     * Constructor for StudentAbstractClass.
     * @param name the name of the student
     * @param ethnicity the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public StudentAbstractClass(String name, Ethnicity ethnicity, Service currentService, String type){
        this.name = name;
        this.home = (Lodging) currentService;
        this.Location = currentService;
        this.numberOfServicesVisited = 0;
        this.ethnicity = ethnicity;
        visitedServices = new ListInArray<>(numberOfServicesVisited);
        this.type = type;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public Service getLodging() {
        return home;
    }

    @Override
    public void setLocation(Service newLocation){
        this.Location.removeStudent();
        this.Location = newLocation;
        this.Location.addStudent();
    }

    @Override
    public Lodging getHome(){
        return this.home;
    }

    @Override
    public Service getLocation(){
        return this.Location;
    }

    @Override
    public void setHome(Lodging home){
        this.home.removeStudent();
        this.home = home;
        this.home.addStudent();
    }
}
