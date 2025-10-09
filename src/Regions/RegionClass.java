package Regions;

import Ethnicities.*;
import Services.Service;
import Students.Student;
import dataStructures.DoublyLinkedList;
import dataStructures.List;
import dataStructures.ListInArray;

import java.io.File;

public class RegionClass implements Region {

    private long topBound;
    private long lowBound;
    private long leftBound;
    private long rightBound;

    private String regionName;


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
        this.topBound = 2;
    }
}
