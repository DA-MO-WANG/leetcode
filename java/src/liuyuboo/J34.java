package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class J34 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return lists;
        ArrayList<Integer> path = new ArrayList<>();
        int currentSum = 0;
        findPath(root,target,path,currentSum);

    }
    ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();
    public void findPath(TreeNode root, int target, ArrayList<Integer> path, int currentSum ) {
        currentSum += root.val;

        pathSum(root.left,target - root.val,sum + root.val);
        pathSum(root.right,target - root.val,sum + root.val);
    }


}
