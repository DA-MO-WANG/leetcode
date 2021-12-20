package liuyuboo;



import java.util.ArrayList;
import java.util.List;

public class J34 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return lists;
        Stack<Integer> path = new ArrayList();
        int currentSum = 0;
        findPath(root,target,path,currentSum);

    }
    ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();
    public void findPath(TreeNode root, int target, Stack<Integer> path, int currentSum ) {
        currentSum += root.val;
        path.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == target && isLeaf) {
            for (Integer v : path) {

            }
        }

        pathSum(root.left,target - root.val,sum + root.val);
        pathSum(root.right,target - root.val,sum + root.val);
    }


}
