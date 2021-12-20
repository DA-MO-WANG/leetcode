package liuyuboo;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J34 {
    public class Stack<E> {
        LinkedList<E> list;
        public Stack(){
            list = new LinkedList();
        }
        public E pop(){
            return list.removeLast();
        }
        public void push(E o){
            list.add(o);
        }
        public E getTop(){
            return list.getLast();
        }
        public boolean isEmpty(){
            return list.size()==0;
        }
        public int size(){
            return list.size();
        }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) return lists;
        Stack<Integer> path = new Stack<>();
        int currentSum = 0;
        findPath(root,target,path,currentSum);
        return lists;

    }
    ArrayList<Integer> pathlist = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();
    public void findPath(TreeNode root, int target, Stack<Integer> path, int currentSum ) {
        currentSum += root.val;
        path.push(root.val);

        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == target && isLeaf) {
            for (int i = 0; i < path.list.size(); i++) {
                pathlist.add(path.list.get(i));
            }
            lists.add(pathlist);
            pathlist.clear();
        }
        if (root.left != null) {
            findPath(root.left,target,path,currentSum);
        }
        if (root.right != null) {
            findPath(root.right,target,path,currentSum);
        }
        path.pop();
    }


}
