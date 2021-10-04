package labuladong;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class quanpailie {
    //存储每一个全排列情况
    List<List<Integer>> res = new LinkedList<>();
    //需要两个工具：选择列表nums  路径列表 track
    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }
    void backtrack(int[] nums,LinkedList<Integer>  track) {
        //终止条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        //回溯
        for (int i = 0; i < nums.length; i++) {
            //全排列不能重复
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        quanpailie q = new quanpailie();
        q.permute(new int[]{1,2,3,4});
        res.stream().forEach(System.out::println);


    }
}
