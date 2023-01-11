package Cache_DB.Cache;

import java.io.File;
import java.io.*;
import Cache_DB.lib.Exceptions.KeyNotFoundException;
public class FileManager {

    public FileManager(){}

    public void createFile(String Key, String Value) throws IOException {
        try {
            FileWriter dataWrite = new FileWriter("./" + String.format("%d", Key.hashCode()) + ".txt");
            dataWrite.write(String.format("%d => " + Value , Key.hashCode()));
            dataWrite.write("\n");
            dataWrite.close();
        } catch (IOException error) {throw new IOException();}

        if (!checkKey(Key)) {
            FileWriter keys = new FileWriter("./Keys.txt", false);
            keys.write(String.format("%d => " + Key, Key.hashCode()));
            keys.write("\n");
            keys.close();
        }

    }

    public String getFileValue(String Key) throws IOException, KeyNotFoundException {

        try {
            String fileHash = String.format("%d", Key.hashCode());
            String filePath = "./" + fileHash + ".txt";
            FileReader file = new FileReader(filePath);
            BufferedReader fileBuffered = new BufferedReader(file);
            while (fileBuffered.readLine() != null) {
                if (fileBuffered.readLine().contains(fileHash)) {
                    return fileBuffered.readLine().replace(" => " + fileHash, "");
                }
            }
        } catch (FileNotFoundException error) {throw new KeyNotFoundException();}
        return null;
    }

    public boolean checkKey(String key) throws IOException {
        try{
            BufferedReader fileBuffered = new BufferedReader(new FileReader("./Keys.txt"));
            while (fileBuffered.readLine() != null) {if (fileBuffered.readLine().contains(key)) return true;}
        } catch (FileNotFoundException error) {return false;}
        return false;

    }

    public boolean checkHash(String hash) throws IOException {
        try {new FileReader("./"+ hash + ".txt");}
        catch (FileNotFoundException error) {return false;}
        return true;

    }

}
