package liuyuboo;

public interface Map<K,V> {
    public boolean contains(K key);
    public void add(K key, V value);
    public V remove(K key);
    public V set(K key, V value);
    public V get(K key);
    boolean isEmpty();
    int getSize();
    //public BSTMap.Node getNode(K key);
    //public LinkedListMap.Node getNode(K key);
}
