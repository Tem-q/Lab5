import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class for writing to a file
 */
public class Writer {
    File fileWay = new File(System.getenv("enV"));

    /**
     * Method writes the collection to a file
     * @param dragon
     * @throws IOException
     */
    public void writeFile(Dragon dragon) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileWay, true);
        String dradonInfo = dragon.getName() + ","
                + dragon.getCoordinates().getX() + ","
                + dragon.getCoordinates().getY() + ","
                + dragon.getAge() + "," + dragon.getDescription() + ","
                + dragon.getWeight() + ","
                + dragon.getType() + ","
                + dragon.getKiller().getName() + ","
                + dragon.getKiller().getHeight() + ","
                + dragon.getKiller().getWeight() + ","
                + dragon.getKiller().getLocation().getX() + ","
                + dragon.getKiller().getLocation().getY() + ","
                + dragon.getKiller().getLocation().getZ() + ","
                + dragon.getKiller().getLocation().getName() + "\n";
        fileOutputStream.write(dradonInfo.getBytes());
        fileOutputStream.close();
    }

    /**
     * Method clears the file before writing
     * @throws IOException
     */
    public void clearFile() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(fileWay, false);
        String s = "";
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();
    }
}
