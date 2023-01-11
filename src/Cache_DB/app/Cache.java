package Cache_DB.app;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;
import Cache_DB.Cache.*;

@Command(name = "CacheDB", mixinStandardHelpOptions = true, version = "CacheDB 1.0",
        description = "Edai Project")
class Cache implements Callable<Integer> {
    Cache_DB cacheDB = new Cache_DB();
    @Command (name = "get")
    public Integer get(@Parameters(arity = "1", paramLabel = "Key") String key) {
        try {
            System.out.println(cacheDB.get(key));
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "getAll")
    public Integer getAll() {
        try {
            System.out.println(Arrays.toString(cacheDB.getAll()));
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "getOrDefault")
    public Integer getOrDefault(
            @Parameters(arity = "1", paramLabel = "Key") String key,
            @Parameters(arity = "1", paramLabel = "defaultValue") String defaultValue) {
        try {
            System.out.println(cacheDB.getOrDefault(key, defaultValue));
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "exists")
    public Integer exists(@Parameters(arity = "1", paramLabel = "Key") String key) {
        try {
            System.out.println(cacheDB.exists(key));
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "put")
    public Integer put(
            @Parameters(arity = "1", paramLabel = "Key") String key,
            @Parameters(arity = "1", paramLabel = "value") String value) {
        try {
            cacheDB.put(key, value);
            System.out.println("Put function is done");
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "addNew")
    public Integer addNew(
            @Parameters(arity = "1", paramLabel = "Key") String key,
            @Parameters(arity = "1", paramLabel = "value") String value) {
        try {
            cacheDB.addNew(key, value);
            System.out.println("key & value where added");
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "remove")
    public Integer remove(@Parameters(arity = "1", paramLabel = "Key") String key) {
        try {
            cacheDB.remove(key);
            System.out.println("file was deleted");
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Command (name = "size")
    public Integer size() {
        try {
            System.out.println(cacheDB.size());
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.print("list of functions: get, getAll, size, remove, addNew, put, exists, getOrDefault");
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Cache()).execute(args);
        System.exit(exitCode);
    }
}
