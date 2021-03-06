import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that manages the dragon collection
 */
public class DragonCollection {
    private Deque<Dragon> dragons = new ArrayDeque<>();

    /**
     * Method returns size of collection
     * @return dragons.size
     */
    public int collectionSize() {
        return dragons.size();
    }
    /**
     * Method displays information about the collection
     */
    public void info() {
        System.out.println(dragons.getClass().toString() + ", size: " + dragons.size());
    }

    /**
     * Method displays all the elements of the collection
     */
    public void show() {
        for (Dragon d: dragons) {
            System.out.println(d.toString());
        }
    }

    /**
     * Method adds the dragon to collection from file
     * @param dragon
     */
    public void addFromReader (Dragon dragon) {
        dragons.offer(dragon);
    }

    /**
     * Method adds a new element to the collection
     * Method updates the value of a collection element by its id
     * Method adds a new element to the collection if its value exceeds the value of the largest element in this collection
     * @param scanner
     * @param command
     * @param weightOrId
     */
    public void add(Scanner scanner, String command, int weightOrId) {
        long xcor = 0;
        double ycor = 0;
        float x = 0;
        int y = 0;
        float z = 0;
        String nameLocation = null;
        String personName = null;
        float personHeight = 0;
        long personWeight = 0;
        String dragonName = null;
        long dragonAge = 0;
        int dragonWeight = 0;
        DragonType dragonType = null;

        System.out.println("Enter the x coordinate. The x coordinate must be long type");
        while (true) {
            try {
                xcor = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("The x coordinate must be long type. Try again");
                scanner.nextLine();
            }
        }

        System.out.println("Enter the y coordinate. The y coordinate must be double type and less than or equal to 67");
        while (true) {
            try {
                double ycheck = scanner.nextDouble();
                if (ycheck <= 67) {
                    ycor = ycheck;
                    break;
                } else {
                    System.out.println("The y coordinate must be less than or equal to 67. Try again");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("The y coordinate must be double type. Try again");
                scanner.nextLine();
            }
        }
        Coordinates coordinates = new Coordinates(xcor, ycor);

        System.out.println("Enter the x location coordinate. The x location coordinate must be float type");
        while (true) {
            try {
                x = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("The x location coordinate must be float type. Try again");
                scanner.nextLine();
            }
        }
        System.out.println("Enter the y location coordinate. The y location coordinate must be int type");
        while (true) {
            try {
                y = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("The y location coordinate must be int type. Try again");
                scanner.nextLine();
            }
        }
        System.out.println("Enter the z location coordinate. The z location coordinate must be float type");
        while (true) {
            try {
                z = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("The z location coordinate must be float type. Try again");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        System.out.println("Enter the name of location. The name of location can't be null or empty");
        while (true) {
            String checkEmpty = scanner.nextLine();
            if(!checkEmpty.equals("")) {
                nameLocation = checkEmpty;
                break;
            } else {
                System.out.println("The name of location can't be null or empty. Try again");
            }
        }
        Location location = new Location(x, y, z, nameLocation);

        System.out.println("Enter the name of killer. The name of killer can't be null or empty");
        while (true) {
            String checkEmpty = scanner.nextLine();
            if(!checkEmpty.equals("")) {
                personName = checkEmpty;
                break;
            } else {
                System.out.println("The name of killer can't be null or empty. Try again");
            }
        }
        System.out.println("Enter the height of killer. The height of killer must be float type and greater than 0");
        while (true) {
            try {
                float personHeightCheck = scanner.nextFloat();
                if (personHeightCheck > 0) {
                    personHeight = personHeightCheck;
                    break;
                } else {
                    System.out.println("The height of killer must be greater than 0. Try again");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("The height of killer must be float type. Try again");
                scanner.nextLine();
            }
        }
        System.out.println("Enter the weight of killer. The weight of killer must be long type and greater than 0");
        while (true) {
            try {
                long personWeightCheck = scanner.nextLong();
                if (personWeightCheck > 0) {
                    personWeight = personWeightCheck;
                    break;
                } else {
                    System.out.println("The weight of killer must be greater than 0. Try again");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("The weight of killer must be long type. Try again");
                scanner.nextLine();
            }
        }
        Person killer = new Person(personName, personHeight, personWeight, location);

        scanner.nextLine();
        System.out.println("Enter the name of dragon. The name of dragon can't be null or empty");
        while (true) {
            String checkEmpty = scanner.nextLine();
            if(!checkEmpty.equals("")) {
                dragonName = checkEmpty;
                break;
            } else {
                System.out.println("The name of dragon can't be null or empty. Try again");
            }
        }
        System.out.println("Enter the age of dragon. The age of dragon must be long type and greater than 0");
        while (true) {
            try {
                long dragonAgeCheck = scanner.nextLong();
                if (dragonAgeCheck > 0) {
                    dragonAge = dragonAgeCheck;
                    break;
                } else {
                    System.out.println("The age of dragon must be greater than 0. Try again");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("The age of dragon must be long type. Try again");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        System.out.println("Enter the description of dragon");
        String dragonDescription = scanner.nextLine();
        if (command.equals("add_if_max")) {
            dragonWeight = weightOrId;
        } else {
            System.out.println("Enter the weight of dragon. The weight of dragon must be int type and greater than 0");
            while (true) {
                try {
                    int dragonWeightCheck = scanner.nextInt();
                    if (dragonWeightCheck > 0) {
                        dragonWeight = dragonWeightCheck;
                        break;
                    } else {
                        System.out.println("The weight of dragon must be greater than 0. Try again");
                        scanner.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The weight of dragon must be int type. Try again");
                    scanner.nextLine();
                }
            }
        }
        while (true) {
            System.out.println("Choose the type of dragon: " + DragonType.AIR + " " + DragonType.FIRE + " " + DragonType.UNDERGROUND);
            try {
                dragonType = DragonType.valueOf(scanner.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such type of dragon");
                scanner.nextLine();
            }
        }
        switch (command) {
            case "add":
                Dragon dragon = new Dragon(dragonName, coordinates, dragonAge, dragonDescription, dragonWeight, dragonType, killer);
                dragons.offer(dragon);
                break;
            case "update":
                Dragon dragon1 = new Dragon(weightOrId, dragonName, coordinates, dragonAge, dragonDescription, dragonWeight, dragonType, killer);
                dragons.offer(dragon1);
                break;
            case "add_if_max":
                Dragon dragon2 = new Dragon(dragonName, coordinates, dragonAge, dragonDescription, dragonWeight, dragonType, killer);
                dragons.offer(dragon2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        scanner.nextLine();
    }

    /**
     * Method removes an element from the collection by its id
     * @param id
     */
    public void removeById(int id) {
        dragons.removeIf(d -> d.getId() == id);
    }

    /**
     * Method clears the collection
     */
    public void clear() {
        if (!dragons.isEmpty()) {
            dragons.clear();
        } else {
            System.out.println("Collection is already empty");
        }
    }

    /**
     * Method saves the collection to a file
     */
    public void save() {
        try {
            Writer writer = new Writer();
            writer.clearFile();
            for (Dragon d: dragons) {
                writer.writeFile(d);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No such file or directory");
        }
    }

    /**
     * Method executes the script from the specified file
     * @param fileName
     * @return checkExit
     */
    public boolean executeScript(String fileName) {
        Scanner sc = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String line;
        boolean checkExit = true;
        try {
            while ((((line = bufferedReader.readLine()) != null)) && (checkExit)) {
                String[] parametrs = new String[]{"",""};
                parametrs = checkTask(line, parametrs);
                line = parametrs[0];
                switch (line) {
                    case "help":
                        Laba.help();
                        break;
                    case "info":
                        info();
                        break;
                    case "show":
                        show();
                        if (collectionSize() == 0) {
                            System.out.println("Collection is empty");
                        }
                        break;
                    case "add":
                        add(sc, "add", 0);
                        break;
                    case "update":
                        if (collectionSize() > 0) {
                            System.out.println("Enter the id to update the element. The id must be int type");
                            int updateId = 0;
                            while (true) {
                                try {
                                    updateId = sc.nextInt();
                                    if (checkIdForExistence(updateId)) {
                                        removeById(updateId);
                                        add(sc, "update", updateId);
                                        break;
                                    } else {
                                        System.out.println("There is no dragon with this id in the collection");
                                        sc.nextLine();
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("The id must be int type. Try again");
                                    sc.nextLine();
                                }
                            }
                        } else {
                            System.out.println("Collection is empty");
                        }
                        break;
                    case "remove_by_id":
                        if (collectionSize() > 0) {
                            System.out.println("Enter the id of dragon. The id must be int type");
                            int id = 0;
                            while (true) {
                                if (sc.hasNextInt()) {
                                    id = sc.nextInt();
                                    break;
                                } else {
                                    System.out.println("The id must be int type. Try again");
                                    sc.nextLine();
                                }
                            }
                            if (checkIdForExistence(id)) {
                                removeById(id);
                            } else {
                                System.out.println("There is no dragon with this id in the collection");
                            }
                            sc.nextLine();
                        } else {
                            System.out.println("Collection is already empty");
                        }
                        break;
                    case "clear":
                        clear();
                        break;
                    case "save":
                        save();
                        break;
                    case "execute_script":
                        try {
                            executeScript(parametrs[1]);
                        } catch (NullPointerException e) {
                            System.out.println("You didn't write a file name in the script");
                        } catch (StackOverflowError e) {
                            System.out.println("The script execution went into recursion");
                        }
                        break;
                    case "exit":
                        checkExit = false;
                        break;
                    case "head":
                        head();
                        break;
                    case "remove_head":
                        removeHead();
                        break;
                    case "add_if_max":
                        System.out.println("Enter the weight to add the element. The weight must be int type");
                        int addIfMaxWeight = 0;
                        while (true) {
                            try {
                                addIfMaxWeight = sc.nextInt();
                                if (checkWeightIfMax(addIfMaxWeight)) {
                                    add(sc, "add_if_max", addIfMaxWeight);
                                    break;
                                } else {
                                    System.out.println("The weight of this dragon is not the maximum");
                                    sc.nextLine();
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("The weight must be int type. Try again");
                                sc.nextLine();
                            }
                        }
                        break;
                    case "sum_of_age":
                        if (collectionSize() > 0) {
                            sumOfAge();
                        } else {
                            System.out.println("Collection is empty");
                        }
                        break;
                    case "filter_contains_name":
                        if (collectionSize() > 0) {
                            System.out.println("Please enter the name");
                            String name = sc.nextLine();
                            filterContainsName(name);
                        } else {
                            System.out.println("Collection is empty");
                        }
                        break;
                    case "filter_less_than_age":
                        if (collectionSize() > 0) {
                            System.out.println("Please enter the age. The age must be long type");
                            long age = 0;
                            while (true) {
                                if (sc.hasNextLong()) {
                                    age = sc.nextLong();
                                    break;
                                } else {
                                    System.out.println("The age must be long type. try again");
                                    sc.nextLine();
                                }
                            }
                            filterLessThanAge(age);
                            sc.nextLine();
                        } else {
                            System.out.println("Collection is empty");
                        }
                        break;
                    default:
                        System.out.println("Unknown command. Please try again");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No such file or directory");
        }
        return checkExit;
    }

    /**
     * Method prints the first element of the collection
     */
    public void head() {
        if (dragons.size() > 0) {
            System.out.println("The first element of collection:");
            System.out.println(dragons.getFirst());
        } else {
            System.out.println("Collections is empty");
        }
    }

    /**
     * Method prints the first element of the collection and removes it
     */
    public void removeHead() {
        if (dragons.size() > 0) {
            System.out.println(dragons.pollFirst());
        } else {
            System.out.println("Collections is empty");
        }
    }

    /**
     * Method prints the sum of the values of the age field for all the elements of the collection
     */
    public void sumOfAge() {
        long sum = 0;
        for (Dragon d: dragons) {
            sum += d.getAge();
        }
        System.out.println("Sum of dragon's age is " + sum);
    }

    /**
     * Method prints elements whose name field value contains the specified substring
     * @param name
     */
    public void filterContainsName(String name) {
        int count = 0;
        for (Dragon d: dragons) {
            if (d.getName().contains(name)) {
                System.out.println(d.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no elements containing this substring");
        }
    }

    /**
     * Method prints elements whose age field value is less than the specified value
     * @param age
     */
    public void filterLessThanAge(long age) {
        int count = 0;
        for (Dragon d: dragons) {
            if (d.getAge()<age) {
                System.out.println(d.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The values of the age field for all elements are greater than " + age);
        }
    }

    /**
     * Method finds a dragon with the specified id
     * @param updateId
     * @return checkId
     */
    public boolean checkIdForExistence(int updateId) {
        boolean checkId = false;
        for (Dragon d: dragons) {
            if (d.getId() == updateId) {
                checkId = true;
            }
        }
        return checkId;
    }

    /**
     * Method compares the specified age with the ages of the dragons
     * @param maxWeight
     * @return checkWeight
     */
    public boolean checkWeightIfMax(int maxWeight) {
        boolean checkWeight = false;
        int count = 0;
        for (Dragon d: dragons) {
            if (d.getWeight() < maxWeight) {
                count++;
            }
        } if (count == dragons.size()) {
            checkWeight = true;
        }
        return checkWeight;
    }

    /**
     * Method finds a command from the list in the input line
     * @param task
     * @return parametrs[]
     */
    public String[] checkTask(String task, String[] parametrs) {
        String[] command = task.split(" ");
        for (int i = 0; i<command.length; i++) {
            if ((command[i].equals("help")) || (command[i].equals("info")) || (command[i].equals("show")) || (command[i].equals("add")) || (command[i].equals("update")) || (command[i].equals("remove_by_id")) || (command[i].equals("clear")) || (command[i].equals("save")) || (command[i].equals("exit")) || (command[i].equals("head")) || (command[i].equals("remove_head")) || (command[i].equals("add_if_max")) || (command[i].equals("sum_of_age")) || (command[i].equals("filter_contains_name")) || (command[i].equals("filter_less_than_age"))) {
                parametrs[0] = command[i];
                break;
            }
            try {
                if (command[i].equals("execute_script")) {
                    parametrs[0] = command[i];
                    parametrs[1] = command[i+1];
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You didn't enter a file name");
            }

        }
        return parametrs;
    }
}
