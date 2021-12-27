package liuyuboo;

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
    public Node treeToDoublyList(Node root) {
        //结果形式--和中序遍历类似
        //操作中序遍历的每个节点
    }

    public void inOrder(Node root) {

        inOrder(root.left);
        //
        
        inOrder(root.right);
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
