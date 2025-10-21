package App.Students;

import App.Services.*;

public abstract class StudentAbstractClass implements Student{

    private Lodging home;
    private Service Location;

    private String type;
    private String name;
    private String ethnicity;


    /**
     * Constructor for StudentAbstractClass.
     * @param name the name of the student
     * @param ethnicity the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public StudentAbstractClass(String name, String ethnicity, Service currentService, String type){
        this.name = name;
        this.home = (Lodging) currentService;
        this.Location = currentService;
        this.ethnicity = ethnicity;
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
        this.Location.removeStudent(this);
        this.Location = newLocation;
        this.Location.addStudent(this);
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
        this.home.removeStudent(this);
        this.home = home;
        this.home.addStudent(this);
    }


    @Override
    public String getEthnicity(){
        return ethnicity;
    }
}
