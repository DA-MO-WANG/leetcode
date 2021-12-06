
package liuyuboo;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Trie {
    //字典树
    //优势就是添加和查找，都不依赖集合内元素数目，而只与要查询的字符串长度有关
    //空间换时间
    class Node{
        boolean isWord;
        Map<Character,Node> next;

        public Node() {
            this.isWord = false;
            this.next = new TreeMap<>();
        }
    }
    Node root;
    int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }
    //非递归版
    public void add(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;//字符串最后一个元素不是叶子节点，这个时候，要标志它是一个单词的结尾
            size++;
        }//如果trie中已经有这个字符串了，此时size是没有变化的，所以size++前要判断一下这个节点是不是被标志过
    }
    //递归版
    public void add01(String word) {
        add01(this.root,word,0);
    }
    //在当前根节点上，添加字符c
    public void add01(Node node,String word,int i) {
        if (i == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }
        Character c = word.charAt(i);
        if (node.next.get(c) == null) {
            node.next.put(c,new Node());
        }
        add01(node.next.get(c),word,++i);

    }

    public boolean contains(String word) {
        Node cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;

    }

    public boolean contains01(String word) {
        return contains01(root,word,0);
    }
    public boolean contains01(Node node, String word, int i) {
        if (i == word.length()) {
            return node.isWord;
        }
        Character c = word.charAt(i);
        if (node.next.get(c) == null) {
            return false;
        }else {
            return contains01(node.next.get(c),word,++i);
        }
    }

    public static void main(String[] args) {
        Character c = new Character('c');
        Set<Map.Entry<Character, Node>> entries = root.next.entrySet();
        for (Map.Entry<Character, Node> entry : entries) {
            Node value = entry.getValue();

        }

        System.out.println(".".equals(c.toString()));
    }
}
