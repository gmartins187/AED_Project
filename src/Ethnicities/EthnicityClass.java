package Ethnicities;

import dataStructures.List;
import Students.Student;
import dataStructures.ListInArray;


public class EthnicityClass implements Ethnicity {

    private String ethnicityName;

    private int numOfStudents;
    private List<Student> students;


    /**
     * Constructor for EthnicityClass.
     * @param ethnicityName the name of the ethnicity
     */
    public EthnicityClass(String ethnicityName) {
        this.ethnicityName = ethnicityName;
        this.numOfStudents = 0;

        this.students = new ListInArray<>(numOfStudents);
    }
}
