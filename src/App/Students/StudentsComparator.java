package App.Students;

import dataStructures.Comparator;

public class StudentsComparator implements Comparator<Student> {

    /**
     * comparator to put the order in alphabetical order in this case by the name
     * @param x
     * @param y
     * @return
     */
    @Override
    public int compare(Student x, Student y) {
        return x.getName().compareTo(y.getName());
    }
}
