package liuyuboo;

/**
 * 基于BST实现的映射
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{
    //成员变量
    Node root;
    int size;
    //构造器


    public BSTMap(Node root) {
        this.root = root;
        this.size = 0;
    }

    //内部类
    class Node {
        K k;
        V v;
        Node left;
        Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }
    @Override
    public boolean contains(K key) {

        return getNode(key) == null ? false : true;
    }

    @Override
    public void add(K key, V value) {


    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if (node != null) {

        }
        return null;
    }

    @Override
    public V set(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.v;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    //@Override
    public Node getNode(K key) {
        return getNode(root,key);
    }
    //返回以node为root节点的树中，key所在的节点
    public Node getNode(Node node , K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.k) < 0) {
            return getNode(node.left,key);
        }else if (key.compareTo(node.k) == 0) {
            return node;
        }else {
            return getNode(node.right,key);
        }
    }
}
