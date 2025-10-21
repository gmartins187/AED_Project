package App.Services;

import App.Students.Student;
import dataStructures.List;
import dataStructures.ListInArray;

public class EatingClass extends ServiceAbstractClass implements Eating{

    List<Student> visited;

    private final int capacity;
    private int numOfPeople;


    /**
     * Constructor for ServiceAbstractClass.
     *
     * @param latitude  the latitude of the service
     * @param longitude the longitude of the service
     * @param price     the price of the service
     * @param capacity     the capacity of the service
     * @param name      the name of the service
     * @param type      the type of the service
     */
    public EatingClass(long latitude, long longitude, int price, int capacity, String name, String type) {
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
