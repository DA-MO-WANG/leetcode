package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class J34 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        pathSum(root,target,0);
        return lists;
    }
    ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();
    public void pathSum(TreeNode root, int target, int sum ) {
        if (root == null) {
            if (sum == target) {
                lists.add(list);
                list.clear();
            }
        }
        pathSum(root.left,target - root.val,sum + root.val);
        pathSum(root.right,target - root.val,sum + root.val);
    }


}
