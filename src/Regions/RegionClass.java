package Regions;

import Ethnicities.*;
import Services.Lodging;
import Services.Service;
import Students.Student;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.ListInArray;

import java.io.File;

public class RegionClass implements Region {

    private final String THRIFTY = "thrifty";
    private final String BOOKISH = "bookish";
    private final String OUTGOING = "outgoing";



    private final long topBound;
    private final long lowBound;
    private final long leftBound;
    private final long rightBound;

    private final String regionName;


    private DoublyLinkedList<Student> students;
    private DoublyLinkedList<Service> services;

    private int numOfEthnicities;
    private List<Ethnicity> ethnicityList;

    private int numOfStudents;
    private int numOfServices;


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

        this.numOfStudents = 0;
        this.numOfServices = 0;

        this.students = new DoublyLinkedList<Student>();
        this.services = new DoublyLinkedList<Service>();
    }

    @Override
    public String getName() {
        return this.regionName;
    }

    @Override
    public void save(String name) {
        //TODO
    }

    @Override
    public void loadRegion() {
        //TODO
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
        numOfServices++;
    }

    @Override
    public boolean hasServices() {
        return numOfServices == 0;
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
    public Student getStudent(String studentName) {
        //TODO;
        return null;
    }

    @Override
    public void addStudent(Student student) {
        //TODO
    }

    @Override
    public Ethnicity getEthnicity(String country) {
        Iterator<Ethnicity> ethnicityIterator = ethnicityList.iterator();
        while (ethnicityIterator.hasNext()) {
            Ethnicity next = ethnicityIterator.next();
            if (next.getName().equals(country)) return next;
        }
        ethnicityList.addFirst(new EthnicityClass(country));
        return getEthnicity(country);
    }

    @Override
    public boolean isServiceFull(String name) {
        Lodging lodgingService = (Lodging) getService(name);
        return lodgingService.isFull();
    }
}
