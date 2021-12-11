package liuyuboo;

import java.util.PriorityQueue;
import java.util.Queue;
//平衡二叉树--由BST
public class AVL<E extends Comparable<E>,V> {
    //成员变量
    Node root;
    int size;
    //构造器


    public AVL(Node root) {
        this.root = root;
        this.size = 0;
    }

    //内部类
    class Node {
        E key;
        V value;
        int height;//添加高度概念
        //int balanceFactor;//添加平衡因子概念
        Node left;
        Node right;

        public Node(E key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public int getBalanceFactor() {
            //后续还要判断是那边倾斜--正负
            return this.left.height - this.right.height;
        }
    }


    //获取容量
    public int getSize() {
        return this.size;
    }


    //CRUD

    //非递归
    public void add(E key, V value) {
        Node cur = this.root;
        if (cur == null) {
            Node node = new Node(key,value);
            root = node;
            return;
        }
        while (cur != null) {
            //找到待插入的位置
            //不考虑相等 的情况
            if (key.compareTo(cur.key) < 0) {
                if (cur.left == null) {
                    Node node = new Node(key,value);
                    cur.left = node;
                    this.size++;
                    return;
                }
                cur = cur.left;
            }else {
                if (cur.right == null) {
                    Node node = new Node(key,value);
                    cur.right = node;
                    return;
                }
                cur = cur.right;
            }
        }
        this.size++;
    }

    //递归版
    public void add_(E key, V value) {
        this.root = add2(this.root,key,value);
    }
    public Node add2(Node root, E key, V value) {
        if (root == null) {
            Node node = new Node(key,value);
            return node;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = add2(root.left, key,value);
        }else {
            //问题：没考虑待添加的元素已经有了
            root.right = add2(root.right,key,value);
        }
        //平衡机制-高度维护
        root.height = 1 + Math.max(root.left.height,root.right.height);

        //平衡修正
        //情况1：左侧太偏
        if (root.getBalanceFactor() > 1 && root.left.getBalanceFactor() > 0) {
            return rotate_right(root);
        }else if(root.getBalanceFactor() < -1 && root.right.getBalanceFactor() > 0) {
            return rotate_left(root);
        }else if (root.getBalanceFactor() > 1 && root.left.getBalanceFactor() < 0) {
            //LR
            root.left =  rotate_left(root.left);
            return rotate_right(root);
        }else if (root.getBalanceFactor() < -1 && root.right.getBalanceFactor() > 0) {
            root.right = rotate_right(root.right);
            return rotate_left(root);
        }
        return root;
    }

    public Node rotate_left(Node x) {
        Node y = x.right;
        Node t3 = y.left;

        x.right = t3;
        y.left = x;

        x.height = 1 + Math.max(x.left.height,x.right.height);
        y.height = 1 + Math.max(y.left.height,y.right.height);
        return y;
    }


    public Node rotate_right(Node node) {
        Node node1 = node.left;
        Node node1_right = node1.right;
        node.left = node1_right;
        node1.right = node;

        //更新height
        //heightUpdate(node1);

        //只有node 和 node1 可能发生变化
        node.height = 1 + Math.max(node.left.height,node.right.height);
        node1.height = 1 + Math.max(node1.left.height,node1.right.height);
        return node1;
    }

    public int heightUpdate(Node node) {
        if (node == null) {
            return 0;
        }
        int h1 = heightUpdate(node.left);
        int h2 = heightUpdate(node.right);
        node.height = 1 + Math.max(h1,h2);
        return node.height;
    }


    //查询元素
    public boolean contains(E e) {
        return contains(this.root,e);
    }
    public boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.key) == 0) {
            return true;
        }else if (e.compareTo(root.key) < 0) {
            return contains(root.left,e);
        }else {
            return contains(root.right,e);
        }
    }
    //遍历

    //前序遍历
    public void traverse() {
        //前序遍历
        traverse_pre(this.root);
    }
    public void traverse_pre(Node root) {
        if (root == null) {
            return;
        }
        System.out.print("root");
        traverse_pre(root.left);
        traverse_pre(root.right);

    }

    //前序遍历非递归
    public void preOrder() {
        Node cur = this.root;
        if (cur == null) {
            return;
        }
        Stack<Node> stack = new ArrayStack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            //拿出来
            System.out.println(node.key);

            stack.push(node.right);
            stack.push(node.left);
        }
    }

    //层序遍历
    public void cengOrder() {
        Queue<Node> queue = new PriorityQueue();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.println(node.key);

            queue.add(node.left);
            queue.add(node.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new NullPointerException("没有元素");
        }
        return minimum(this.root).key;

    }
    public Node minimum(Node node) {
        Node cur = this.root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public E maxmum() {
        if (size == 0) {
            throw new NullPointerException("没有元素");
        }
        return maxmum(this.root).key;

    }
    public Node maxmum(Node node) {
        Node cur = this.root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public E removeMin() {
        E ret = minimum();
        this.root = removeMin(this.root);
        return ret;
    }
    //返回删除最小值节点后的树的根
    public Node removeMin(Node node) {
        //核心逻辑：只要不存在比他更小的，就能证明他是最小的
        //底基部分，就是最小操作树，这里的新树根就是右子节点
        if (node.left == null) {
            //有没有有子树，代码是一样的，因为null也是一棵树
            Node rightNode = node.right;
            node.right = null;
            this.size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
        }
        node.right = removeMax(node.right);
        return node;
    }
    //删除元素:删除键以node为根节点的bst中，以key为键的节点后的二分搜索树的根节点
    public Node removeElement(Node node, E key) {
        //单侧节点情况
        if (node == null) {
            return null;
        }
        //先找到e所在节点====>思路就有问题，还是不习惯用递归脑洞来解决问题
        if (key.compareTo(node.key) == 0) {
            if (node.left == null) {
                Node delNode = node;
                Node rightNode = delNode.right;
                delNode.right = null;
                return rightNode;
            }else if (node.right == null) {
                Node delNode = node;
                Node leftNode = delNode.left;
                delNode.left = null;
                return leftNode;
            }else {
                Node right_min = minimum(node.right);
                Node newroot = removeMin(node);
                right_min.left = node.left;
                right_min.right = newroot;

                node.left = node.right = null;
                return right_min;
            }

        }else if (key.compareTo(node.key) > 0) {
            node.right = removeElement(node.right,key);//更新右侧
            return node;
        }else {
            node.left = removeElement(node.left,key);
            return node;
        }
    }
    public Node get(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.key) == 0) {
            return node;
        }else if (e.compareTo(node.key) > 0) {
            return get(node.right,e);
        }else {
            return get(node.left,e);
        }
    }


    //floor-ceil问题
    //找到元素的floor解
    public E getFloor(E e) {
        //方案1：中序特性，保存好数组，然后二分查找
        return e;
    }

    //rank问题-select问题
    //方案：node维护一个size变量，代表以此节点为根，的树的节点数量
    //比root小，就肯定在一侧，然后就rank就排出了一个范围

}
