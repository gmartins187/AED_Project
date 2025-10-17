package Students;

import Ethnicities.Ethnicity;
import Services.Service;

public class OutgoingClass extends StudentAbstractClass implements Outgoing {
    /**
     * Constructor for StudentAbstractClass.
     *
     * @param name           the name of the student
     * @param ethnicity      the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public OutgoingClass(String name, Ethnicity ethnicity, Service currentService, String type) {
        super(name, ethnicity, currentService, type);
    }
}
