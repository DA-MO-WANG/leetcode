package liuyuboo;

/**
 * 基于链表实现的映射
 */
public class LinkedListMap<K,V> implements Map<K,V>{
    @Override
    public boolean contains(K key) {
        Node pre = dummyNode.next;
        while (pre != null) {
            Node cur = pre;
            if (key.equals(cur.k)) {
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyNode.next = new Node(key,value);
            size++;
        }else {
            node.v = value;
        }


    }

    @Override
    public V remove(K key) {
        //先看键是否存在
        return null;
    }

    @Override
    public V get(K key) {
        Node<K,V> node = getNode(key);
        if (node == null) {
            return null;
        }
        return node.v;
    }

    @Override
    public boolean isEmpty() {
        return dummyNode.next == null ? false: true;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public V set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        V oldValue = (V) node.v;
        node.v = value;
        return oldValue;
    }

    //这个函数是其他函数的基础，要先写
    public Node<K,V>  getNode(K key) {
        Node pre = dummyNode.next;
        while (pre != null) {
            Node cur = pre;
            if (key.equals(cur.k)) {
                return cur;
            }
            pre = pre.next;
        }
        return null;
    }

    //基于链表实现
    class Node<K,V> {
        //数据部分
        public K k;
        public V v;
        //引用部分
        Node next;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.next = null;
        }

        public Node() {
        }
    }

    Node dummyNode;
    int size;

    public LinkedListMap() {
        this.dummyNode = new Node();
        this.size = 0;
    }
}
