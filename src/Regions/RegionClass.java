package Regions;

import Filters.*;
import Filters.InService;
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
    private List<String> ethnicityList;



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
    public boolean hasEthnicity(String country) {
        Iterator<String> it = ethnicityList.iterator();
        while(it.hasNext())
            if(it.next().equals(country)) return true;

        return false;
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
        ethnicityList.addLast(country);
    }

    @Override
    public void listStudents(String from) {
        Iterator<Student> iterator = new FilterIterator<>(((Iterator) students.iterator()), new IsFrom(from));
        while (iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next.getName() + ": " + next.getType() + " at " + next.getLodging().getName());
        }
    }

    @Override
    public void listUsersIn(Service service, String order) {
        if(order.equals(">")){
            Iterator<Student> it = new FilterIterator<>((Iterator)students.iterator(), new InService(service));
            while(it.hasNext()){
                Student next = it.next();
                System.out.println(next.getName() + ": " + next.getType());
            }
        } else {//order.equals("<")
            TwoWayIterator<Student> iterator = students.twoWayiterator();
            while (iterator.hasPrevious()){
                Student previous = iterator.previous();
                if(previous.getLocation() == service)
                    System.out.println(previous.getName() + ": " + previous.getType());
            }
        }
    }

    @Override
    public void whereStudent(Student student) {
        Service location = student.getLocation();
        System.out.printf("%s is at %s %s (%d, %d).",
                student.getName(), location.getName(),
                location.getType(), location.getLatitude(),
                location.getLongitude());
    }
}
