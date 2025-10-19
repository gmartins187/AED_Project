package Filters;

import Services.Service;
import Students.Student;
import dataStructures.Predicate;

public class InService implements Predicate<Student> {

    private final Service service;


    public InService(Service service){
        this.service = service;
    }

    @Override
    public boolean check(Student student) {
        return this.service == student.getLocation();
    }
}
