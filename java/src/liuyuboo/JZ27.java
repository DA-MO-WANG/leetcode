package liuyuboo;

import java.util.LinkedList;

public class JZ27 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

    }
    //目的：转化成排序的循环双向链表
    Node head = new Node();

    public Node treeToDoublyList(Node root) {
        //结果形式--和中序遍历类似
        //结果链表是一个由中序顺序组织的链表
        //所谓链表和bst都是节点靠指针维护的，这个结构是一致的，所以存在就地转换的可能
        //这个处理工程，只涉及两个点角色之间的指针调整，其他部分不需要===》需要head  cur两个小弟
        //cur 代表当前节点，而这个当前节点是中序顺序组织的节点；也就是中序遍历框架中间位置，会自然拿到当前节点
        //head 这里就要记录前一个节点
        //前一个节点与当前节点的互动，只有三部分：两部分指针调整-前一个后指针指向下一个；后一个前指针指向前一个；记得更新head，来保证始终维持root的前一个节点
        Node begin = head;
        inOrder(root);
        Node cur = ret;
        while (cur.left != begin) {
            cur = cur.left;
        }
        return cur;


    }
    Node ret = null;
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        head.right = root;
        root.left = head;
        head = head.right;
        ret = root;
        inOrder(root.right);
        LinkedList
    }


        //分化瓦解--三个部分，每个部分都具有和上级同样的问题实质
       /* Node lastNode = null;
        convertNode(root,lastNode);
        Node headNode = lastNode;
        while (headNode != null && headNode.left != null) {
            headNode = headNode.left;
        }
        return headNode;


    }

    public void convertNode(Node root,Node lastNode) {
        if (root == null) {
            return;
        }
        Node current = root;
        if (current.left != null) {
            convertNode(current.left,lastNode);
        }
        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            convertNode(current.right,lastNode);
        }
    }*/


       /* if (root.left == null)

        //小问题：左子树
        leftTo(root.left).right = root;

        //小问题：右子树
        rightTo(root.right).left = root;

        return root;

    }
    //返回左子树最大节点
    public Node leftTo(Node root) {
        if(root.left == null && root.right == null) {
            return root;
        }
        leftTo(root.left).right = root;
        rightTo(root.right).left = root;
        return findMax(root.right);

    }

    public Node findMax(Node root) {
        if(root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    public Node findMin(Node root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }
    //返回右子树最小节点
    public Node rightTo(Node root) {
        if(root.left == null && root.right == null) {
            return root;
        }
        leftTo(root.left).right = root;
        rightTo(root.right).left = root;
        return findMin(root.left);
    }
*/

}
