package Students;

import Services.Service;

public class ThriftyClass extends StudentAbstractClass implements Thrifty {
    /**
     * Constructor for StudentAbstractClass.
     *
     * @param name           the name of the student
     * @param ethnicity      the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public ThriftyClass(String name, String ethnicity, Service currentService, String type) {
        super(name, ethnicity, currentService, type);
    }
}
