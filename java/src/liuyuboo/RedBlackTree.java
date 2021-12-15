package liuyuboo;

import java.util.PriorityQueue;
import java.util.Queue;

public class RedBlackTree<E extends Comparable<E>> {
    private static final boolean Red = true;
    private static final boolean Black = false;
    //成员变量
    Node root;
    int size;
    //构造器


    public RedBlackTree(Node root) {
        this.root = root;
        this.size = 0;
    }

    //内部类
    class Node {
        E data;
        Node left;
        Node right;
        boolean color;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.color = Red;
        }
    }


    //获取容量
    public int getSize() {
        return this.size;
    }
    public boolean getColor(Node node) {
        return node.color;
    }


    //CRUD

    //递归版
    public void add_(E data) {
        this.root = add2(this.root,data);
        //维护最终版红黑树的性质
        this.root.color = Black;
    }

    public Node rotateLeft(Node node) {
        //    node           x
        //      \    --->   /
        //       x       node
        Node x = node.right;
        //人可以走，但得留下一点东西--就是最近的兄弟
        node.right = x.left;
        x.left = node;
        x.color = node.color;//不破坏与外部的关系，保持原有颜色
        node.color = Red;//内部属于解放区，可以换颜色了
        return x;
    }
    //颜色合理化
    public void flipColors(Node node) {
        node.color = Red;
        node.left.color = Black;
        node.right.color = Black;
    }
    public Node rotateRight(Node node) {
        Node root = node.left;
        node.left = root.right;
        root.right = node;
        root.color = node.color;
        node.color = Black;
        //flipColors(root);
        return root;
    }



    public Node add2(Node root, E data) {
        if (root == null) {
            Node node = new Node(data);
            return node;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = add2(root.left, data);
        }else {
            //问题：没考虑待添加的元素已经有了
            root.right = add2(root.right,data);
        }
        return root;
    }


}
