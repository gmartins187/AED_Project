import App.*;
import Exceptions.*;

import java.util.Scanner;

public class Main {

    private static final String EATING = "eating";
    private static final String LODGING = "lodging";
    private static final String LEISURE = "leisure";


    private static final String HELP = "help";
    private static final String EXIT = "exit";
    private static final String BOUNDS = "bounds";
    private static final String SAVE = "save";
    private static final String LOAD = "load";
    private static final String SERVICE = "service";
    private static final String SERVICES = "services";
    private static final String STUDENT = "student";
    private static final String STUDENTS = "students";
    private static final String LEAVE = "leave";
    private static final String GO = "go";
    private static final String MOVE = "move";
    private static final String USERS = "users";
    private static final String STAR = "star";
    private static final String WHERE = "where";
    private static final String VISITED = "visited";
    private static final String RANKING = "ranking";
    private static final String RANKED = "ranked";
    private static final String TAG = "tag";
    private static final String FIND = "find";

    private static final String HELP_TEXT = """
    bounds - Defines the new geographic bounding rectangle
    save - Saves the current geographic bounding rectangle to a text file
    load - Load a geographic bounding rectangle from a text file
    service - Adds a new service to the current geographic bounding rectangle. The service may be eating, lodging or leisure
    services - Displays the list of services in current geographic bounding rectangle, in order of registration
    student - Adds a student to the current geographic bounding rectangle
    students - Lists all the students or those of a given country in the current geographic bounding rectangle, in alphabetical order of the student’s name
    leave - Removes a student from the the current geographic bounding rectangle
    go - Changes the location of a student to a leisure service, or eating service
    move - Changes the home of a student
    users - List all students who are in a given service (eating or lodging)
    star - Evaluates a service
    where - Locates a student
    visited - Lists locations visited by one student
    ranking - Lists services ordered by star
    ranked - Lists the service(s) of the indicated type with the given score that are closer to the student location.
    tag - Lists all services that have at least one review whose description contains the specified word. This list is from the most recent review to the oldest
    find - Finds the most relevant service of a certain type, for a specific student
    help - Shows the available commands
    exit - Terminates the execution of the program""";
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


    public static void main(String[] args){
        commands();
    }




    private static void commands() {
        Scanner in = new Scanner(System.in);


        String command = in.next();

        while (!command.equals(EXIT)) {
            HomeAwayApp app = new homeAwayAppClass();

            switch (command) {
                case HELP -> System.out.println(HELP_TEXT);
                case BOUNDS -> newArea(app, in);
                case SAVE -> saveArea(app);
                case LOAD -> loadArea(app, in);
                case SERVICE -> newService(app, in);
                case SERVICES ->
                case STUDENT ->
                case STUDENTS ->
                case LEAVE ->
                case GO ->
                case MOVE ->
                case USERS ->
                case STAR ->
                case WHERE ->
                case VISITED ->
                case RANKING ->
                case RANKED ->
                case TAG ->
                case FIND ->
                default -> System.out.println(NOT_COMMAND_TEXT);
            }
            command = in.next();
        }
        System.out.println(EXIT_TEXT);
        in.close();
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
        String type = in.next();
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
}
