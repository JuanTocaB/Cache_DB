package Cache_DB.lib;

public class MapEntry <TKey extends Comparable<TKey>, TValue> implements Comparable<MapEntry<TKey, TValue>> {

    private final TKey key;
    private final TValue value;

    public MapEntry(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    public TKey getKey() {return key;}

    public TValue getValue() {return value;}

    @Override
    public int compareTo(MapEntry<TKey, TValue> other) {return this.key.compareTo(other.key);}

}
