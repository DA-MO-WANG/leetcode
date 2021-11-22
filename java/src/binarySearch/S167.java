package binarySearch;

import java.util.HashMap;

public class S167 {
    public int[] twoSum(int[] numbers, int target) {
        //在这个场合，重要的不是解决问题，而是训练去感受怎么分析问题
        //不因人为难度等级标定，而产生什么先入为主的偏见


        //问题空间的所有要素：
        //目的：返回满足条件的索引数组
        //输入材料：非递减数组   目标数
        //条件：两数之和满足目标、索引从1开始、只存在一个答案
        HashMap<Integer,Integer> hashMap = new HashMap();
        int[] ret = new int[2];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                ret[count++] = (Integer) hashMap.get(target - numbers[i]);
                if (count == 2) {
                    break;
                }
            }else {
                hashMap.put(numbers[i],i+1);
            }
        }
        return ret;


    }
}
