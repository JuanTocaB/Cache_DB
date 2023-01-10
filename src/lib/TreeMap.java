package lib;

public class TreeMap <TKey extends Comparable<TKey>, TValue> {

    private final BinaryTreeNode<MapEntry<TKey, TValue>> treeNodes = new BinaryTreeNode<>();

    public boolean isItEmpty() {
        return treeNodes.isItEmpty();
    }

    public int treeSize() {
        return treeNodes.treeSize();
    }

    @SuppressWarnings("unchecked")
    public Object[] values() {
        Object[] entries = treeNodes.listAllNodesData(); // MapEntry<TKey, TValue>[]
        Object[] result = new Object[entries.length];

        int counter = 0;
        while (counter < entries.length) {
            MapEntry<TKey, TValue> entry = (MapEntry <TKey, TValue>) entries[counter];
            result[counter] = entry.getValue();
            counter++;
        }

        return result;
    }

    public void put(TKey key, TValue value) {
        MapEntry<TKey, TValue> newEntry = new MapEntry<>(key, value);
        treeNodes.add(newEntry);
    }

    public boolean contains(TKey key) {return treeNodes.dataSearch(createEntryForSearch(key)) != null;}

    private MapEntry<TKey, TValue> createEntryForSearch(TKey key) {return new MapEntry<TKey, TValue>(key, null);}

    public TValue get(TKey key) {
        var treeNode = treeNodes.dataSearch(createEntryForSearch(key));
        if (treeNode == null) {throw new KeyNotFoundException();}
        MapEntry<TKey, TValue> entry = treeNode.getNodeData();
        return entry.getValue();
    }

    public boolean remove(TKey key) {
        if (!contains(key)) return false;
        treeNodes.removeNode(createEntryForSearch(key));
        return true;
    }
}
