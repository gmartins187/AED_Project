package Regions;

import Ethnicities.*;
import Services.Service;
import Students.Student;
import dataStructures.DoublyLinkedList;
import dataStructures.List;
import dataStructures.ListInArray;

import java.io.File;

public class RegionClass implements Region {

    private int topBound;
    private int lowBound;
    private int leftBound;
    private int rightBound;

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
    public RegionClass(int topBound, int lowBound, int leftBound, int rightBound, String regionName) {
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
    public void save(File file) {
        //TODO
    }

    @Override
    public String getName() {
        return this.regionName;
    }
}
