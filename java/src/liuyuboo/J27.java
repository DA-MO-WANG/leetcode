package liuyuboo;

public class J27 {
    //返回镜像后的树的根节点
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode newright = mirrorTree(root.left);
        TreeNode newleft = mirrorTree(root.right);
        root.left = newleft;
        root.right = newright;
        return root;

    }
}
