package Regions;

import Ethnicities.*;
import Services.Lodging;
import Services.Service;
import Students.Student;
import dataStructures.*;

public class RegionClass implements Region {

    //private final String THRIFTY = "thrifty";
    //private final String BOOKISH = "bookish";
    //private final String OUTGOING = "outgoing";

    private final String LODGING = "lodging";

    private final long topBound;
    private final long lowBound;
    private final long leftBound;
    private final long rightBound;

    private final String regionName;

    private final DoublyLinkedList<Student> students;
    private final DoublyLinkedList<Service> services;

    private int numOfEthnicities;
    private List<Ethnicity> ethnicityList;



    /**
     * Constructor for RegionClass
     * @param topBound the top boundary of the region
     * @param lowBound the low boundary of the region
     * @param leftBound the left boundary of the region
     * @param rightBound the right boundary of the region
     * @param regionName the name of the region
     */
    public RegionClass(long topBound, long lowBound, long leftBound, long rightBound, String regionName) {
        this.topBound = topBound;
        this.lowBound = lowBound;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.regionName = regionName;

        this.numOfEthnicities = 0;
        this.ethnicityList = new ListInArray<>(numOfEthnicities);

        this.students = new DoublyLinkedList<Student>();
        this.services = new DoublyLinkedList<Service>();
    }



    @Override
    public String getName() {
        return this.regionName;
    }

    @Override
    public boolean isValid(long latitude, long longitude) {
        return this.topBound > latitude
                && latitude > this.lowBound
                && this.leftBound < longitude
                && longitude < this.rightBound;
    }

    @Override
    public Service getService(String name) {
        Iterator<Service> iterator = services.iterator();
        while(iterator.hasNext()) {
            Service next = iterator.next();
            if (next.getName().equals(name)) return next;
        }

        return null;
    }

    @Override
    public void addService(Service service) {
        services.addFirst(service);
    }

    @Override
    public boolean hasServices() {
        return services.isEmpty();
    }

    @Override
    public void listAllServices() {
        Iterator<Service> iterator = services.iterator();
        while(iterator.hasNext()) {
            Service next = iterator.next();
            System.out.println(next.getName() + ": " + next.getType() + " " + next.getLatitude() + " -" + next.getLongitude() + ".");
        }
    }

    @Override
    public void addStudent(Student student) {
        students.addFirst(student);
    }

    @Override
    public Ethnicity getEthnicity(String country) {
        Iterator<Ethnicity> ethnicityIterator = ethnicityList.iterator();

        while (ethnicityIterator.hasNext()) {
            Ethnicity next = ethnicityIterator.next();
            if (next.getName().equals(country)) return next;
        }

        return null;
    }

    @Override
    public boolean isServiceFull(String name) {
        Lodging lodgingService = (Lodging) getService(name);
        return lodgingService.isFull();
    }

    @Override
    public Student getStudent(String name) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (next.getName().equals(name)) return next;
        }

        return null;
    }

    @Override
    public void removeStudent(String name) {
        students.remove(students.indexOf(getStudent(name)));
    }

    @Override
    public boolean hasLodging(String lodgingName) {
        Iterator<Service> iterator = services.iterator();
        while(iterator.hasNext()) {
            Service next = iterator.next();
            if (next.getType().equals(LODGING) && next.getName().equals(lodgingName))
                return true;
        }
        return false;
    }

    @Override
    public boolean hasStudents() {
        return students.isEmpty();
    }

    @Override
    public void addEthnicity(String country) {
        ethnicityList.addFirst(getEthnicity(country));
    }

    @Override
    public void listStudents(String from) {
        //TODO
        Iterator<Student> iterator = new FilterIterator<>(((Iterator) students.iterator()), new IsFrom(from));
        while (iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next.getName() + ": " + next.getType() + " at " + next.getLodging().getName());
        }
    }
}
