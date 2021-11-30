package liuyuboo;

public class J6 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //先拿到第一层根节点:去前序序列
        int preroot = 0;
        int val = preorder[0];
        //找到中序序列的左右子序列：把中序序列分成左右两部分
        int inroot = getIndex(inorder,val);
        int inleft = 0;
        TreeNode root = new TreeNode(preorder[preroot]);
        //中序序列：左序[0,inroot)  右（inroot,len-1]
        //找前序序列的左右部分：节点数量一致=》前root后同样数量的区间就是前的左子区间
        //（preroot,preroot+inroot+1]  (preroot + inroot + 1,len - 1]
        TreeNode left = build(preroot + 1, preroot + inroot - inleft,preorder,inleft,inroot - 1,inorder);
        TreeNode right = build(preroot + inroot - inleft + 1, preorder.length - 1,preorder,inroot + 1,inorder.length - 1,inorder);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode build(int preleft, int preright, int[] preorder, int inleft1, int inright, int[] inorder) {
        if (preright < preorder.length && preleft == preright) {
            return new TreeNode(preorder[preleft]);
        }

        //先拿到第一层根节点:去前序序列
        int preroot = preleft;
        int val = preorder[preroot];
        //找到中序序列的左右子序列：把中序序列分成左右两部分
        int inroot = getIndex(inorder,val);
        int inleft = inleft1;
        TreeNode root = new TreeNode(preorder[preroot]);
        //中序序列：左序[0,inroot)  右（inroot,len-1]
        //找前序序列的左右部分：节点数量一致=》前root后同样数量的区间就是前的左子区间
        //（preroot,preroot+inroot+1]  (preroot + inroot + 1,len - 1]
        TreeNode left = build(preroot + 1, preroot + inroot + 1,preorder,inleft,inroot - 1,inorder);
        TreeNode right = build(preroot + inroot + 2, preright,preorder,inroot + 1,inright,inorder);
        root.left = left;
        root.right = right;
        return root;

    }

    public int getIndex(int[] arr, int val) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
