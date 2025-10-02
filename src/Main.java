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
    private static void newArea(HomeAwayApp app, Scanner in) {
        try {
            int top = in.nextInt();
            int left = in.nextInt();
            int bottom = in.nextInt();
            int right = in.nextInt();

            String areaName = in.next();

            app.newArea(top,left,bottom,right);

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
        String type = in.next().toLowerCase();
        switch(type){
            case EATING -> newEatingService(app, in);
            case LODGING -> newLodgingService(app, in);
            case LEISURE -> newLeisureService(app, in);
            default -> System.out.println(INVALID_TYPE);
        }
    }

    /**
     * Creates and adds a new eating service in the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void newEatingService(HomeAwayApp app, Scanner in) {
        String name = "";
        try {
            int latitude = in.nextInt();
            int longitude = in.nextInt();
            int price = in.nextInt();
            int value = in.nextInt();
            name = in.next();

            app.newEatingService(latitude, longitude, price, value, name);

            System.out.println("Eating " + name + " added.");
        } catch (InvalidType e){
            System.out.println(INVALID_TYPE);
        } catch (InvalidLocation e){
            System.out.println(INVALID_LOCATION);
        } catch (InvalidPrice e){
            System.out.println(INVALID_MENU_PRICE);
        } catch (InvalidValue e){
            System.out.println(INVALID_DISCOUNT_PRICE);
        } catch (AlreadyExists e){
            System.out.println(name + ALREADY_EXISTS);
        }
    }

    /**
     * Creates and adds a new leisure service in the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void newLeisureService(HomeAwayApp app, Scanner in) {
        //TODO
    }

    /**
     * Creates and adds a new lodging service in the app
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void newLodgingService(HomeAwayApp app, Scanner in) {
        //TODO
    }

    /**
     * Lists all services in the app
     * @param app the region manager (app object)
     */
    private static void allServices(HomeAwayApp app) {
        try{
            app.listAllServices();
        } catch (DoesntExist e){
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
        } catch (DoesntExist e){
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
        } catch (DoesntExist e){
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
        } catch (DoesntExist e){
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
        //TODO
    }


    /**
     * List users in a service (eating or lodging)
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void listUsersInService(HomeAwayApp app, Scanner in) {
        //TODO
    }


    /**
     * Locates a student (current service location)
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void locateStudent(HomeAwayApp app, Scanner in) {
        //TODO
    }


    /**
     * Lists locations visited by one student
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void listVisitedLocations(HomeAwayApp app, Scanner in) {
        //TODO
    }


    /**
     * Rates a service with a star and a comment
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void rateService(HomeAwayApp app, Scanner in) {
        //TODO
    }


    /**
     * Lists services ordered by rating
     * @param app the region manager (app object)
     */
    private static void listServicesByRating(HomeAwayApp app) {
        //TODO
    }

    /**
     * Lists the service(s) of the indicated type with the given score that are closer to the student location.
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void listServicesByTypeAndRating(HomeAwayApp app, Scanner in) {
        //TODO
    }


    /**
     * Lists all services that have at least one review whose description contains the specified word.
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void allServicesWithTag(HomeAwayApp app, Scanner in) {
        //TODO
    }


    /**
     * Displays the most relevant service of a certain type, for a specific student
     * @param app the region manager (app object)
     * @param in the scanner to read input from
     */
    private static void mostRelevantService(HomeAwayApp app, Scanner in) {
        //TODO
    }
}
