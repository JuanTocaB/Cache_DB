package Cache_DB.lib.Exceptions;

public class DuplicatedKeyException  extends Exception{
    public DuplicatedKeyException() {super("The key seems to be duplicated");}
}
