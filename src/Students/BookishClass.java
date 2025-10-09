package Students;

import Ethnicities.Ethnicity;
import Services.Service;

public class BookishClass extends StudentAbstractClass implements Bookish {
    /**
     * Constructor for StudentAbstractClass.
     *
     * @param name           the name of the student
     * @param ethnicity      the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public BookishClass(String name, Ethnicity ethnicity, Service currentService) {
        super(name, ethnicity, currentService);
    }
}
