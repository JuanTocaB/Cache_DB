package Cache_DB.Cache;

import java.io.File;
import java.io.*;

import Cache_DB.lib.Exceptions.DuplicatedKeyException;
import Cache_DB.lib.Exceptions.KeyNotFoundException;
public class FileManager {

    public FileManager(){}

    /**
     * Creates a file with a key and value
     * @param Key Key to be stored.
     * @param Value value to be stored.
     * @throws IOException when the fileWriter doesn't work.
     */
    public void createFile(String Key, String Value) throws IOException {
        try {
            FileWriter dataWrite = new FileWriter("./" + String.format("%d", Key.hashCode()) + ".txt");
            dataWrite.write(String.format("%d => " + Value , Key.hashCode()));
            dataWrite.write("\n");
            dataWrite.close();
        } catch (IOException error) {throw new IOException();}

        if (!checkKey(Key)) {
            FileWriter keys = new FileWriter("./Keys.txt", true);
            keys.write(String.format("%d => " + Key, Key.hashCode()));
            keys.write("\n");
            keys.close();
        }

    }

    /**
     * gets the key's value
     * @param Key Key for getting the value
     * @throws IOException the file wasn't found.
     * @throws KeyNotFoundException when the key wasn't found
     */
    public String getFileValue(String Key) throws IOException, KeyNotFoundException {

        try {
            String fileHash = String.format("%d", Key.hashCode());
            String filePath = "./" + fileHash + ".txt";
            FileReader file = new FileReader(filePath);
            BufferedReader fileBuffered = new BufferedReader(file);
            String readLine = fileBuffered.readLine();
            while (readLine != null) {
                if (readLine.contains(fileHash)) {
                    return readLine.replace(fileHash + " => " , "");
                }
                readLine = fileBuffered.readLine();
            }
        } catch (FileNotFoundException error) {throw new KeyNotFoundException();}
        return null;
    }

    /**
     * Checks if the key exists
     * @param key to check if exists
     * @throws IOException the file wasn't found.
     */
    public boolean checkKey(String key) throws IOException {
        try{
            BufferedReader fileBuffered = new BufferedReader(new FileReader("./Keys.txt"));
            String readLine = fileBuffered.readLine();
            while (readLine != null) {
                if (readLine.contains(key)) return true;
                readLine = fileBuffered.readLine();
            }
        } catch (FileNotFoundException error) {return false;}
        return false;

    }

    /**
     * deletes file
     * @param Key to check if exists
     */
    public void deleteFile(String Key) {
        String fileHash = String.format("%d", Key.hashCode());
        File fileToDelete = new File("./" + fileHash + ".txt");
        fileToDelete.delete();
    }

}
