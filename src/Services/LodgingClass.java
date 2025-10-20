package Services;

import dataStructures.List;
import Students.Student;
import dataStructures.ListInArray;

public class LodgingClass extends ServiceAbstractClass implements Lodging {

    private final int capacity;
    private int numOfPeople;

    List<Student> visited;


    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param name      the name of the service
     * @param type      the type of the service
     */
    public LodgingClass(long latitude, long longitude, int price, int capacity, String name, String type) {
        super(latitude, longitude, price, name, type);

        this.numOfPeople = 0;
        this.capacity = capacity;

        visited = new ListInArray<>(capacity);
    }

    @Override
    public boolean isFull() {
        return numOfPeople == capacity;
    }

    @Override
    public void addStudent(Student student) {
        numOfPeople++;
        visited.add(numOfPeople++, student);
    }

    @Override
    public void removeStudent(Student student) {
        numOfPeople--;
        visited.remove(visited.indexOf(student));
    }
}
