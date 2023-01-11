package Cache_DB.Cache;

import Cache_DB.lib.Exceptions.*;
import Cache_DB.lib.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;

public class Cache_DB implements ICache{

    private final TreeMap<String, String> Cache = new TreeMap<>();
    private final FileManager fileManager = new FileManager();


    /**
     * Get all keys stored in cache.
     * @return array of stored keys
     */
    @Override
    public String[] getAll() throws IOException {
        String filePath = "./Keys.txt";
        FileReader file = new FileReader(filePath);
        BufferedReader fileBuffered = new BufferedReader(file);
        String readLine = fileBuffered.readLine();
        String[] result = new String[this.size()];
        int counter = 0;
        while (readLine != null) {
            String[] splitLine = readLine.split(" => ", 2);
            result[counter] = splitLine[0];
            readLine = fileBuffered.readLine();
            counter++;
        }
        return result;
    }
    /**
     * Get the value associated with the key passed as argument.
     * @param key Key to look for
     * @return The value associated with the key
     */
    @Override
    public String get(String key) throws IOException {
        Cache.put(key, fileManager.getFileValue(key));
        return Cache.get(key);
    }
    /**
     * Return the value of key passed as argument. Otherwise, return the
     * default value passed as second argument.
     * @param key Key to look for
     * @param defaultValue Value returned when key does not exist.
     * @return The value associated with the key or the defaultValue if key was not
    found.
     */
    @Override
    public String getOrDefault(String key, String defaultValue) {
        try {
            Cache.put(key, fileManager.getFileValue(key));
            return Cache.get(key);}
        catch (KeyNotFoundException | IOException error) {return defaultValue;}
    }

    /**
     * Check is a key exists in cache.
     * @param key Key to look for
     * @return True if key exists.
     */
    @Override
    public boolean exists(String key) throws IOException {
        try {Cache.put(key, fileManager.getFileValue(key));}
        catch (KeyNotFoundException error) {return false;}
        return Cache.contains(key);
    }
    /**
     * Add or update the value associated to a key.
     * @param key Key to be stored.
     * @param value Value to be stored.
     */
    @Override
    public void put(String key, String value) throws IOException {
        Cache.put(key, value);
        fileManager.createFile(key, value);
    }
    /**
     * Add a value to a new key. If key already exists, it throws an exception.
     * @param key Key to be stored.
     * @param value Value to be stored.
     */
    @Override
    public void addNew(String key, String value) throws IOException, DuplicatedKeyException {
        if (Cache.contains(key)) throw new DuplicatedKeyException();
        else {fileManager.createFile(key, value);}
    }
    /**
     * Remove a key and its value.
     * @param key Key to be stored.
     * @throws KeyNotFoundException if key does not exist.
     */
    @Override
    public void remove(String key) throws KeyNotFoundException, IOException {
        Cache.put(key, fileManager.getFileValue(key));
        if (!Cache.contains(key)) throw new KeyNotFoundException();
        else {fileManager.deleteFile(key);}
    }
    /**
     * Count the keys (and values) stored in cache.
     * @return Count of keys.
     */
    @Override
    public int size() throws IOException {
        String filePath = "./Keys.txt";
        FileReader file = new FileReader(filePath);
        BufferedReader fileBuffered = new BufferedReader(file);
        String readLine = fileBuffered.readLine();
        int counter = 0;
        while (readLine != null) {
            counter++;
            readLine = fileBuffered.readLine();
        }
        return counter;
    }

}
