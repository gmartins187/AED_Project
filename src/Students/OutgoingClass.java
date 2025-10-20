package Students;

import Services.Service;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.ListInArray;

public class OutgoingClass extends StudentAbstractClass implements Outgoing {

    private int numberOfServicesVisited;
    private List<Service> visitedServices;


    /**
     * Constructor for StudentAbstractClass.
     *
     * @param name           the name of the student
     * @param ethnicity      the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public OutgoingClass(String name, String ethnicity, Service currentService, String type) {
        super(name, ethnicity, currentService, type);
        visitedServices = new ListInArray<>(numberOfServicesVisited);
        this.numberOfServicesVisited = 0;
    }

    @Override
    public boolean hasVisited() {
        return numberOfServicesVisited == 0;
    }

    @Override
    public void getVisitedPlaces() {
        Iterator<Service> it = visitedServices.iterator();
        while(it.hasNext())
            System.out.println(it.next().getName());
    }

    @Override
    public void pingService(Service service) {
        this.visitedServices.add(numberOfServicesVisited++, service);
    }
}
