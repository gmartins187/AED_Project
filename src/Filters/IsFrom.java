package Filters;

import Students.Student;
import dataStructures.Predicate;

public class IsFrom implements Predicate<Student>{

    private final String from;

    public IsFrom(String from){
        this.from=from;
    }

    @Override
    public boolean check(Student student) {
        if(this.from.equals("all")) return true;
        else{
            return this.from.equals(student.getEthnicity());
        }
    }
}
