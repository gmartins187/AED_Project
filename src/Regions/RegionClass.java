package Regions;

import Ethnicities.*;
import Services.Service;
import Students.Student;
import dataStructures.DoublyLinkedList;
import dataStructures.List;
import dataStructures.ListInArray;

public class RegionClass implements Region {

    int topBound;
    int lowBound;
    int leftBound;
    int rightBound;

    String regionName;


    DoublyLinkedList<Student> students;
    DoublyLinkedList<Service> services;

    private int numOfEthnicities;
    private List<Ethnicity> ethnicityList;

    int numOfStudents;
    int numOfServices;


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

        this.students = new DoublyLinkedList<Student>();
        this.services = new DoublyLinkedList<Service>();

        this.numOfEthnicities = 0;
        this.ethnicityList = new ListInArray<>(numOfEthnicities);

        this.numOfStudents = 0;
        this.numOfServices = 0;
    }
}
