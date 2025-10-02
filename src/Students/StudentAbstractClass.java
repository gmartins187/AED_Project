package Students;

import Ethnicities.Ethnicity;
import Services.*;
import dataStructures.*;

public abstract class StudentAbstractClass implements Student{

    private Service home;
    private Service Location;

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
    public StudentAbstractClass(String name, Ethnicity ethnicity, Service currentService){
        this.name = name;
        this.home = currentService;
        this.Location = currentService;
        this.numberOfServicesVisited = 0;
        this.ethnicity = ethnicity;
        visitedServices = new ListInArray<>(numberOfServicesVisited);
    }
}
