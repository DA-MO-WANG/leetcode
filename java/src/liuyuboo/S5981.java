package liuyuboo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class S5981 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int leftsum = 0;
        int leftnum = 0;

        int rightsum = 0;


        for(int x : nums) {
            rightsum += x;
        }

        //int[] dp = new int[nums.lenght];
        Integer res = leftnum - leftsum + rightsum;
        HashMap<Integer,Integer> map = new HashMap();
        Integer hit = 0;
        map.put(hit,res);
        for(int i = 1; i <= nums.length; i++) {



            leftsum += nums[i - 1];
            leftnum = i;
            rightsum -= nums[i - 1];


            res = leftnum - leftsum + rightsum;

            if(map.get(hit) < res) {
                map.remove(hit);
                map.put(i,res);
                hit = i;

            }else if(map.get(hit) == res) {
                map.put(i,res);
                hit = i;
            }
        }



        List<Integer> list = new ArrayList();
        Set<Integer> set = map.keySet();
        for(Integer x : set) {
            list.add(x);
        }
        return list;

        //top k 问题

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,0};
        S5981 s5981 = new S5981();
        List<Integer> integers = s5981.maxScoreIndices(arr);
        for (Integer num : integers) {
            System.out.print(num + " ");
        }

    }
}
