package App.Students;

import App.Services.Leisure;
import App.Services.Service;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.ListInArray;

public class BookishClass extends StudentAbstractClass implements Bookish {

    private final List<Service> visitedServices;

    /**
     * Constructor for StudentAbstractClass.
     *
     * @param name           the name of the student
     * @param ethnicity      the ethnicity of the student
     * @param currentService the current service the student is at and their home
     */
    public BookishClass(String name, String ethnicity, Service currentService, String type) {
        super(name, ethnicity, currentService,type);
        visitedServices = new DoublyLinkedList<>();
    }

    @Override
    public boolean hasnotVisited() {
       //Iterator<Service> it = visitedServices.iterator();
       //while(it.hasNext()) if(it.next() instanceof Leisure) return true;

        return visitedServices.isEmpty();
    }

    @Override
    public Iterator<Service> getVisitedPlaces() {
        //List<Service> ret = new DoublyLinkedList<>();
        //Iterator<Service> it = visitedServices.iterator();
        //while(it.hasNext()){
        //    Service next = it.next();
        //    if(next instanceof Leisure)
        //        ret.addLast(next);
        //}
        //return ret.iterator();
        return visitedServices.iterator();
    }

    @Override
    public void pingService(Service service) {
        if(service instanceof Leisure &&
                visitedServices.indexOf(service) == -1)
            this.visitedServices.addLast(service);
    }
}
