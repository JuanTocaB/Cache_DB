package Cache_DB.Cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Cache_DB.lib.Exceptions.DuplicatedKeyException;
import Cache_DB.lib.Exceptions.KeyNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestCacheDb {

    Cache_DB testCache = new Cache_DB();

    @Test
    void testGetAll() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello");
        testCache.addNew("fghjm", "hello5");
        testCache.addNew("edrfg", "hello");
        testCache.addNew("asdfg", "hello3");
        testCache = new Cache_DB();
        assertEquals(4, testCache.size());
    }

    @Test
    void testGet() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello4");
        testCache = new Cache_DB();
        assertEquals("hello4", testCache.get("asdfe"));
    }

    @Test
    void testGetOrDefault() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello4");
        testCache = new Cache_DB();
        assertTrue(testCache.exists("asdfe"));
        assertFalse(testCache.exists("noKey"));
    }

    @Test
    void testExists() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello4");
        testCache = new Cache_DB();
        assertEquals("hello4", testCache.getOrDefault("asdfe", "nope"));
        assertEquals("nope", testCache.getOrDefault("noKey", "nope"));
    }

    @Test
    void testPut() throws IOException {
        testCache.put("asdfe", "hello4");
        testCache = new Cache_DB();
        assertEquals("hello4", testCache.get("asdfe"));
        testCache.put("asdfe", "hello3");
        testCache = new Cache_DB();
        assertEquals("hello3", testCache.get("asdfe"));
    }

    @Test
    void testAddNew() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello4");
        testCache = new Cache_DB();
        assertEquals("hello4", testCache.get("asdfe"));
    }

    @Test
    void testRemove() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello4");
        testCache = new Cache_DB();
        assertEquals("hello4", testCache.get("asdfe"));
        testCache.remove("asdfe");
        testCache = new Cache_DB();
        try {
            testCache.remove("asdfe");
            Assertions.fail("failed test");
        }
        catch (KeyNotFoundException error) {}
    }

    @Test
    void testSize() throws IOException, DuplicatedKeyException {
        testCache.addNew("asdfe", "hello");
        testCache.addNew("fghjm", "hello5");
        testCache.addNew("edrfg", "hello");
        testCache.addNew("asdfg", "hello3");
        testCache = new Cache_DB();
        assertEquals(4, testCache.size());
    }

}
