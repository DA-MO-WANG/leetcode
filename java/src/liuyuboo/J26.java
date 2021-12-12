package liuyuboo;

public class J26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return isSubStructure1(A,B);


    }
    public boolean isSubStructure1(TreeNode max, TreeNode min) {
        if (max == null || min == null) {
            return true;
        }
        if (max.val == min.val) {
            return isSubStructure1(max.left,min.left) && isSubStructure1(max.right,min.right);
        }else if (max.val > min.val) {
            return isSubStructure1(max.left,min);
        }else {
            return isSubStructure(max.right,min);
        }
    }
}
