import java.io.*;
/**
 * Class for reading from a file
 */
public class Reader {
    File fileWay;
    boolean checkEnvironmentVariable = true;
    public void setFileWay(String fileName) {
        fileWay = new File(fileName);
        checkEnvironmentVariable = false;
    }
    /**
     * Method reads a collection from a file
     * @param dragonCollection
     * @throws IOException
     */
    public void readFile(DragonCollection dragonCollection) throws IOException {
        if (checkEnvironmentVariable) {
            fileWay = new File(System.getenv("enV"));
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWay));


        String[] words;
        String line;

        long xcor = 0;
        double ycor = 0;
        Coordinates coordinates;

        float x = 0;
        int y = 0;
        float z = 0;
        String nameLocation = null;
        Location location;

        String personName = null;
        float personHeight = 0;
        long personWeight = 0;
        Person killer;

        String name = null;
        long age = 0;
        String description = null;
        int weight = 0;
        DragonType type = null;
        Dragon dragon = null;

        while((line = bufferedReader.readLine()) != null) {
            words = line.split(",");
            if (words.length == 14) {
                try {
                    while (true) {
                        xcor = Long.parseLong(words[1]);
                        if (Double.parseDouble(words[2]) <= 67) {
                            ycor = Double.parseDouble(words[2]);
                        } else {
                            System.out.println("The y coordinate must be less than or equal to 67");
                            break;
                        }
                        coordinates = new Coordinates(xcor, ycor);

                        x = Float.parseFloat(words[10]);
                        y = Integer.parseInt(words[11]);
                        z = Float.parseFloat(words[12]);
                        if ((words[13] != null)  && (!words[13].isEmpty())){
                            nameLocation = words[13];
                        } else {
                            System.out.println("The name of location can't be null or empty");
                            break;
                        }
                        location = new Location(x, y, z, nameLocation);

                        if ((words[7] != null) && (!words[7].isEmpty())) {
                            personName = words[7];
                        } else {
                            System.out.println("The name of person can't be null or empty");
                            break;
                        }
                        if (Float.parseFloat(words[8]) > 0) {
                            personHeight = Float.parseFloat(words[8]);
                        } else {
                            System.out.println("The height can't be null. The height must be greater than 0");
                            break;
                        }
                        if (Long.parseLong(words[9]) > 0) {
                            personWeight = Long.parseLong(words[9]);
                        } else {
                            System.out.println("The weight must be greater than 0");
                            break;
                        }
                        killer = new Person(personName, personHeight, personWeight, location);

                        if ((words[0] != null) && (!words[0].isEmpty())){
                            name = words[0];
                        } else {
                            System.out.println("The name of Dragon can't be null or empty");
                            break;
                        }
                        if ((Long.parseLong(words[3]) != 0) && (words[3] != null)) {
                            age = Long.parseLong(words[3]);
                        } else {
                            System.out.println("The age can't be 0");
                            break;
                        }
                        if (words[4] != null) {
                            description = words[4];
                        } else {
                            System.out.println("The description can't be null");
                            break;
                        }
                        if (Integer.parseInt(words[5]) > 0) {
                            weight = Integer.parseInt(words[5]);
                        } else {
                            System.out.println("The weight must be greater than 0");
                            break;
                        }
                        type = DragonType.valueOf(words[6]);

                        dragon = new Dragon(name, coordinates, age, description, weight, type, killer);

                        dragonCollection.addFromReader(dragon);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid values for some parameters. Check the values in the file");
                }
            }
        }
        bufferedReader.close();
    }
}
