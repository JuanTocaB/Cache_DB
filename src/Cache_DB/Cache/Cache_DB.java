package Cache_DB.Cache;

import Cache_DB.lib.Exceptions.*;
import Cache_DB.lib.*;

import java.io.IOException;

public class Cache_DB implements ICache{

    private TreeMap<String, String> Cache;
    private FileManager fileManager = new FileManager();

    /**
     * Get all keys stored in cache.
     * @return array of stored keys
     */
    @Override
    public String[] getAll() {


        return new String[0];
    }
    /**
     * Get the value associated with the key passed as argument.
     * @param key Key to look for
     * @return The value associated with the key
     * @throws KeyNotFoundException if key does not exist.
     */
    @Override
    public String get(String key) throws IOException {
        return fileManager.getFileValue(key);
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
        return null;
    }

    /**
     * Check is a key exists in cache.
     * @param key Key to look for
     * @return True if key exists.
     */
    @Override
    public boolean exists(String key) throws IOException {
        fileManager.checkKey(key);
        return false;
    }
    /**
     * Add or update the value associated to a key.
     * @param key Key to be stored.
     * @param value Value to be stored.
     */
    @Override
    public void put(String key, String value) {}
    /**
     * Add a value to a new key. If key already exists, it throws an exception.
     * @param key Key to be stored.
     * @param value Value to be stored.
     * @throws DuplicatedKeyException the key already exists.
     */
    @Override
    public void addNew(String key, String value) throws IOException {
        fileManager.createFile(key, value);
    }
    /**
     * Remove a key and its value.
     * @param key Key to be stored.
     * @throws KeyNotFoundException if key does not exist.
     */
    @Override
    public void remove(String key) {
        fileManager.deleteFile(key);
    }
    /**
     * Count the keys (and values) stored in cache.
     * @return Count of keys.
     */
    @Override
    public int size() {
        return Cache.treeSize();
    }

}
