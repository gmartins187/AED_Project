import App.*;
import Exceptions.*;

import java.util.Scanner;

public class Main {

    private static final String EATING = "eating";
    private static final String LODGING = "lodging";
    private static final String LEISURE = "leisure";

    private static final String EXIT_TEXT = "Bye!";
    private static final String NOT_COMMAND_TEXT = "Unknown command. Type help to see available commands.";
    private static final String INVALID_BOUNDS = "Invalid bounds.";
    private static final String AREA_EXISTS_ALREADY = "Bounds already exists. Please load it!";
    private static final String NO_CURRENT_AREA = "System bounds not defined.";
    private static final String INVALID_TYPE = "Invalid service type!";
    private static final String INVALID_LOCATION = "Invalid location.";
    private static final String INVALID_MENU_PRICE = "Invalid menu price!";
    private static final String INVALID_DISCOUNT_PRICE = "Invalid discount price!";
    private static final String ALREADY_EXISTS = " already exists!";
    private static final String NO_SERVICES = "No services yet!";
    private static final String INVALID_STU_TYPE = "Invalid student type!";
    private static final String INVALID_LODGING = "Lodging %s does not exist!";
    private static final String SERVICE_FULL = "%S %s is full!";
    private static final String UNKNOWN = "Unknown %s!";
    private static final String DOES_NOT_EXIST = "%s does not exist!";
    private static final String INVALID_SERVICE = "%s is not a valid service!";
    private static final String ALREADY_THERE = "Already there!";
    private static final String NO_STUDENTS = "No students yet!";
    private static final String NO_STUDENTS_FROM = "No students from %s!";
    private static final String CURRENT_HOME = "That is %s's home!";
    private static final String LODGING_FULL = "Lodging %s is full!";
    private static final String INVALID_MOVE = "Move is not acceptable for %s!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String INVALID_ROOM_PRICE = "Invalid room price!";
    private static final String INVALID_TICKET_PRICE = "Invalid ticket price!";
    private static final String DOES_NOT_CONTROL = "%s does not control student entry and exit!";
    private static final String HAS_NOT_VISITED = "%s has not visited any locations!";
    private static final String IS_THRIFTY = "%s is thrifty!";
    private static final String INVALID_RATE = "Invalid evaluation!";
    private static final String NO_SERVICES_SYS = "No services in the system.";
    private static final String INVALID_STARS = "Invalid stars!";
    private static final String NO_TYPE_SERVICES = "No %s services!";
    private static final String NO_TYPE_SERVICES_AVG = "No %s services with average!";
    private static final String NO_TAG = "There are no services with this tag!";



    public static void main(String[] args){commands();}

    /**
     * Handles all commands.
     */
    private static void commands() {
        Scanner in = new Scanner(System.in);
        HomeAwayApp App = new homeAwayAppClass();

        Command command;
        do{
            command = getCommand(in);
            switch (command){
                case EXIT -> System.out.println(EXIT_TEXT);
                case HELP -> {executeHelp();in.nextLine();}
                case BOUNDS -> newArea(App, in);
                case SAVE -> saveArea(App);
                case LOAD -> loadArea(App, in);
                case SERVICE -> newService(App, in);
                case SERVICES -> allServices(App);
                case STUDENT -> newStudent(App, in);
                case LEAVE -> removeStudent(App, in);
                case STUDENTS -> listStudents(App, in);
                case GO -> changeStudentLocation(App, in);
                case MOVE -> changeStudentHome(App, in);
                case USERS -> listUsersInService(App, in);
                case WHERE -> locateStudent(App, in);
                case VISITED -> listVisitedLocations(App, in);
                case STAR -> rateService(App, in);
                case RANKING -> listServicesByRating(App);
                case RANKED -> listServicesByTypeAndRating(App, in);
                case TAG -> allServicesWithTag(App, in);
                case FIND -> mostRelevantService(App, in);
                case UNKNOWN -> {System.out.println(NOT_COMMAND_TEXT);
                    in.nextLine();}
            }
        } while(!command.equals(Command.EXIT));
        in.close();
    }




    /**
     * Reads the command from input (taken from source code of problem A from moodle)
     * @param input the scanner to read input from
     * @return the command
     */
    private static Command getCommand(Scanner input) {
        try {
            String comm = input.next().toUpperCase();
            return Command.valueOf(comm);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }


    /**
     * Prints all available commands (taken from source code of problem A from moodle)
     */
    private static void executeHelp() {
        Command[] help=Command.values();
        for(int i=0; i<help.length-1;i++)
            System.out.println(help[i].getMsg());
    }


    /**
     * Creates a new region in the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void newArea(HomeAwayApp app, Scanner in){
        try {
            int top = in.nextInt();
            int left = in.nextInt();
            int bottom = in.nextInt();
            int right = in.nextInt();

            String areaName = in.next();

            app.newArea(top,left,bottom,right, areaName);

            System.out.println(areaName + "created.");
        } catch (InvalidArea e){
            System.out.println(INVALID_BOUNDS);
        } catch (AlreadyExists e){
            System.out.println(AREA_EXISTS_ALREADY);
        }
    }

    /**
     * Saves the current region to a text file
     * @param app the region manager (app object)
     */
    private static void saveArea(HomeAwayApp app) {
        try{
            app.saveArea();
            System.out.println("saved.");
        } catch (NoCurrentArea e){
            System.out.println(NO_CURRENT_AREA);
        }
    }

    /**
     * Loads the region from a text file
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void loadArea(HomeAwayApp app, Scanner in) {
        String areaName = in.next();
        try{
            app.loadArea(areaName);
            System.out.println(areaName + "loaded.");
        } catch (InvalidArea e){
            System.out.println("Bounds" + areaName + "does not exists.");
        }
    }


    /**
     * Creates and adds a new service in the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void newService(HomeAwayApp app, Scanner in) {
        String name = "";
        String type = "";
        try {
            type = in.next().trim();
            int latitude = in.nextInt();
            int longitude = in.nextInt();
            int value1 = in.nextInt();
            int value2 = in.nextInt();
            name = in.next();

            app.newService(latitude, longitude, value1, value2, name);

            System.out.println("Eating " + name + " added.");
        } catch (InvalidType e){
            System.out.println(INVALID_TYPE);
        } catch (InvalidLocation e){
            System.out.println(INVALID_LOCATION);
        } catch (InvalidPrice e){
            switch(type){
                case EATING -> System.out.println(INVALID_MENU_PRICE);
                case LODGING -> System.out.println(INVALID_ROOM_PRICE);
                case LEISURE -> System.out.println(INVALID_TICKET_PRICE);
            }
        } catch (InvalidValue e){
            System.out.println(INVALID_DISCOUNT_PRICE);
        } catch (ServiceFull e) {
            System.out.println(INVALID_CAPACITY);
        } catch (AlreadyExists e){
            System.out.println(name + ALREADY_EXISTS);
        }
    }


    /**
     * Lists all services in the app
     * @param app the region manager (app object)
     */
    private static void allServices(HomeAwayApp app) {
        try{
            app.listAllServices();
        } catch (DoesNotExist e){
            System.out.println(NO_SERVICES);
        }
    }


    /**
     * Creates and adds a new student in the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void newStudent(HomeAwayApp app, Scanner in) {
        String name = "";
        String lodgingName = "";
        try{
            String type = in.next().trim();
            name = in.next();
            String country = in.next().trim();
            lodgingName = in.next();

            app.newStudent(type, name, country, lodgingName);
        } catch (InvalidType e){
            System.out.println(INVALID_STU_TYPE);
        }
        //TEST PRINTF
        catch (InvalidLocation e){
            System.out.printf(INVALID_LODGING, lodgingName);
        } catch (ServiceFull e){
            System.out.printf(SERVICE_FULL, LODGING, lodgingName);
        } catch (AlreadyExists e){
            System.out.println(name + ALREADY_EXISTS);
        }
    }

    /**
     * Removes a student from the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void removeStudent(HomeAwayApp app, Scanner in) {
        String name = in.next();
        try{
            app.removeStudent(name);
        } catch (DoesNotExist e){
            System.out.println(name + " does not exist!");
        }
    }

    /**
     * Lists all students in the app
     * @param app the region manager (app object)
     */
    private static void listStudents(HomeAwayApp app, Scanner in) {
        String from = "";
        try{
            from = in.next();

            app.listStudents(from);
        } catch (DoesNotExist e){
            System.out.println(NO_STUDENTS);
        } catch (InvalidArea e){
            System.out.printf(NO_STUDENTS_FROM, from);
        }
    }


    /**
     * change the location of a student to an eating or leisure place
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void changeStudentLocation(HomeAwayApp app, Scanner in) {
        String name = "";
        String locationName = "";
        try{
            name = in.next();
            locationName = in.next();

            app.changeStudentLocation(name, locationName);
        } catch (InvalidLocation e){
            System.out.printf(UNKNOWN, locationName);
        } catch (DoesNotExist e){
            System.out.printf(DOES_NOT_EXIST, name);
        } catch (InvalidService e){
            System.out.printf(INVALID_SERVICE, locationName);
        } catch (AlreadyThere e){
            System.out.println(ALREADY_THERE);
        } catch (ServiceFull e){
            System.out.printf(SERVICE_FULL, EATING, locationName);
        }
    }


    /**
     * change the home of a student to a lodging place
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void changeStudentHome(HomeAwayApp app, Scanner in) {
        String name = "";
        String lodgingName = "";
        try{
            name = in.next();
            lodgingName = in.next();

            app.changeStudentHome(name, lodgingName);
        } catch (InvalidLocation e){
            System.out.printf(INVALID_LODGING, lodgingName);
        } catch (DoesNotExist e){
            System.out.printf(DOES_NOT_EXIST, name);
        } catch (AlreadyThere e){
            System.out.printf(CURRENT_HOME, name);
        } catch (ServiceFull e){
            System.out.printf(LODGING_FULL, lodgingName);
        } catch (InvalidService e){
            System.out.printf(INVALID_MOVE, name);
        }
    }


    /**
     * List users in a service (eating or lodging)
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void listUsersInService(HomeAwayApp app, Scanner in) {
        String serviceName = "";
        try{
            String order = in.next();
            serviceName = in.next();

            app.listUsersInService(order, serviceName);
        } catch (InvalidOrder e){
            System.out.println("This order does not exist!");
        } catch (DoesNotExist e){
            System.out.printf(DOES_NOT_EXIST, serviceName);
        } catch (InvalidType e){
            System.out.printf(DOES_NOT_CONTROL, serviceName);
        }
    }


    /**
     * Locates a student (current service location)
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void locateStudent(HomeAwayApp app, Scanner in) {
        String name = "";
        try{
            name = in.next();

            app.locateStudent(name);
        } catch (DoesNotExist e){
            System.out.printf(DOES_NOT_EXIST, name);
        }
    }


    /**
     * Lists locations visited by one student
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void listVisitedLocations(HomeAwayApp app, Scanner in) {
        String name = "";
        try{
            name = in.next();

            app.listVisitedLocations(name);
        } catch (DoesNotExist e){
            System.out.printf(DOES_NOT_EXIST, name);
        } catch (InvalidType e){
            System.out.printf(IS_THRIFTY, name);
        } catch (Untouched e){
            System.out.printf(HAS_NOT_VISITED, name);
        }
    }


    /**
     * Rates a service with a star and a comment
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void rateService(HomeAwayApp app, Scanner in) {
        String name = "";
        try {
            int numericRate = in.nextInt();
            name = in.next();
            String tag = in.next();

            app.rateService(name, numericRate, tag);
        } catch (InvalidValue e){
            System.out.println(INVALID_RATE);
        } catch (DoesNotExist e){
            System.out.printf(DOES_NOT_EXIST, name);
        }
    }


    /**
     * Lists services ordered by rating
     * @param app the region manager (app object)
     */
    private static void listServicesByRating(HomeAwayApp app) {
        try {
            app.listServicesByRating();
        } catch (DoesNotExist e){
            System.out.println(NO_SERVICES_SYS);
        }
    }


    /**
     * Lists the service(s) of the indicated type with the given score that are closer to the student location.
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void listServicesByTypeAndRating(HomeAwayApp app, Scanner in) {
        String type = "";
        String name = "";
        try {
            int numericRate = in.nextInt();
            type = in.next().trim();
            name = in.next();

            app.listServicesByTypeAndRating(numericRate, type, name);
        } catch (InvalidValue e) {
            System.out.println(INVALID_STARS);
        } catch (DoesNotExist e) {
            System.out.printf(DOES_NOT_EXIST, name);
        } catch (InvalidType e) {
            System.out.println(INVALID_TYPE);
        } catch (Untouched e) {
            System.out.printf(NO_TYPE_SERVICES, type);
        } catch (ServiceFull e) {
            System.out.printf(NO_TYPE_SERVICES_AVG, type);
        }
    }


    /**
     * Lists all services that have at least one review whose description contains the specified word.
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void allServicesWithTag(HomeAwayApp app, Scanner in) {
        try {
            String tag = in.next();

            app.allServicesWithTag(tag);
        } catch (Untouched e) {
            System.out.println(NO_TAG);
        }
    }


    /**
     * Displays the most relevant service of a certain type, for a specific student
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void mostRelevantService(HomeAwayApp app, Scanner in) {
        String name = "";
        String type = "";
        try {
            name = in.next();
            type = in.next().trim();

            app.mostRelevantService(name, type);
        } catch (InvalidType e) {
            System.out.println(INVALID_TYPE);
        } catch (DoesNotExist e) {
            System.out.printf(DOES_NOT_EXIST, name);
        } catch (Untouched e) {
            System.out.printf(NO_TYPE_SERVICES, type);
        }
    }
}
