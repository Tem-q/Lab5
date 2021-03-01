import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Kurovskiy Artem R3136
 * This is the main class
 */
public class Laba {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        help();
        DragonCollection dragonCollection = new DragonCollection();

        Reader reader = new Reader();
        try {
            try {
                reader.readFile(dragonCollection);
            } catch (NullPointerException e) {
                System.out.println("Enter the name of file");
                String fileName = scanner.nextLine();
                reader.setFileWay(fileName);
                reader.readFile(dragonCollection);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Enter the command please");
        boolean param = true;
        try {
            String task = scanner.nextLine();
            task = task.replaceAll("\\s*", "");
            while (param) {
                switch (task) {
                    case "help":
                        help();
                        break;
                    case "info":
                        dragonCollection.info();
                        break;
                    case "show":
                        dragonCollection.show();
                        break;
                    case "add":
                        dragonCollection.add(scanner, "add", 0);
                        break;
                    case "update":
                        System.out.println("Enter the id to update the element");
                        int updateId = 0;
                        while (true) {
                            try {
                                updateId = scanner.nextInt();
                                if (dragonCollection.checkIdForExistence(updateId)) {
                                    dragonCollection.removeById(updateId);
                                    dragonCollection.add(scanner, "update", updateId);
                                    break;
                                } else {
                                    System.out.println("There is no dragon with this id in the collection");
                                    scanner.nextLine();
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("The id must be int type. Try again");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case "remove_by_id":
                        if (dragonCollection.collectionSize() > 0) {
                            System.out.println("Enter the id of dragon");
                            int id = 0;
                            while (true) {
                                if (scanner.hasNextInt()) {
                                    id = scanner.nextInt();
                                    break;
                                } else {
                                    System.out.println("The id must be int type. try again");
                                    scanner.nextLine();
                                }
                            }
                            dragonCollection.removeById(id);
                            scanner.nextLine();
                        } else {
                            System.out.println("Collection is already empty");
                        }
                        break;
                    case "clear":
                        dragonCollection.clear();
                        break;
                    case "save":
                        dragonCollection.save();
                        break;
                    case "execute_script":
                        System.out.println("Enter the file name");
                        String fileName = scanner.nextLine();
                        param = dragonCollection.executeScript(fileName);
                        break;
                    case "exit":
                        param = false;
                        break;
                    case "head":
                        dragonCollection.head();
                        break;
                    case "remove_head":
                        dragonCollection.removeHead();
                        break;
                    case "add_if_max":
                        System.out.println("Enter the weight to add the element");
                        int addIfMaxWeight = 0;
                        while (true) {
                            try {
                                addIfMaxWeight = scanner.nextInt();
                                if (dragonCollection.checkWeightIfMax(addIfMaxWeight)) {
                                    dragonCollection.add(scanner, "add_if_max", addIfMaxWeight);
                                    break;
                                } else {
                                    System.out.println("The weight of this dragon is not the maximum");
                                    scanner.nextLine();
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("The weight must be int type. Try again");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case "sum_of_age":
                        dragonCollection.sumOfAge();
                        break;
                    case "filter_contains_name":
                        System.out.println("Please enter the name");
                        String name = scanner.nextLine();
                        dragonCollection.filterContainsName(name);
                        break;
                    case "filter_less_than_age":
                        System.out.println("Please enter the age");
                        long age = 0;
                        while (true) {
                            if (scanner.hasNextLong()) {
                                age = scanner.nextLong();
                                break;
                            } else {
                                System.out.println("The age must be long type. try again");
                                scanner.nextLine();
                            }
                        }
                        dragonCollection.filterLessThanAge(age);
                        scanner.nextLine();
                        break;
                    default:
                        System.out.println("Unknown command. Please try again");
                }
                if (param) {
                    System.out.println("Enter a command please");
                    task = scanner.nextLine();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Unknown command");
        }

    }

    /**
     * Method prints the legend
     */
    public static void help() {
        System.out.println("List of available commands: \n"
                + "help: display help for available commands \n"
                + "info: display information about the collection \n"
                + "show: display all the elements of the collection \n"
                + "add: add a new element to the collection \n"
                + "update: update the value of a collection element by its id \n"
                + "remove_by_id: delete an element from the collection by its id \n"
                + "clear: clear the collection \n"
                + "save: save the collection to a file \n"
                + "execute_script: execute the script from the specified file \n"
                + "exit: end the program (without saving it to a file) \n"
                + "head: print the first element of the collection \n"
                + "remove_head: print the first element of the collection and delete it \n"
                + "add_if_max: add a new element to the collection if its value exceeds the value of the largest element in this collection \n"
                + "sum_of_age: print the sum of the values of the age field for all the elements of the collection \n"
                + "filter_contains_name: print elements whose name field value contains the specified substring \n"
                + "filter_less_than_age: print elements whose age field value is less than the specified value");
    }
}
