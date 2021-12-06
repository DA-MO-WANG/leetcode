package liuyuboo;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

class MapSum {
    class Node{
        boolean isWord;
        int v;
        HashMap<Character,Node> next;

        public Node() {
            this.isWord = false;
            this.next = new HashMap<Character, Node>();
            this.v = 0;
        }
    }
    Node root;
    //int size;

    public MapSum() {
        this.root = new Node();
        //this.size = 0;
    }

    public void insert(String key, int val) {
        Node cur = this.root;
        for (int i = 0; i < key.length(); i++) {
            Character c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
        cur.v = val;
    }

    public int sum(String prefix) {
        Node cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }
    //返回以这个节点为根节点的树的key数据之和
    public int sum(Node node) {
        if(node.next.entrySet() == null) {
            return node.v;
        }
        int sum1 = 0;
        Set<Map.Entry<Character, Node>> entries = node.next.entrySet();
        for (Map.Entry<Character, Node> entry : entries) {
            Node cur = entry.getValue();
            sum1+= sum(cur);
        }
        return sum1;

    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        int ap = mapSum.sum("ap");
        System.out.println(ap);

    }
}
