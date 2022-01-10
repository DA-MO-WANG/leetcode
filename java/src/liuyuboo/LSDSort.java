package liuyuboo;

import edu.princeton.cs.algs4.LSD;

import java.util.Arrays;

public class LSDSort {
    private LSDSort() {}
    public static void  sort(String[] arr,int w) {
        for (String s : arr) {
            if (s.length() != w) {
                throw new IllegalArgumentException("All Strings' length must be the same.");
            }
        }
        //char有256种可能
        int R = 256;//范围
        //用来计数的数组
        int[] cnt = new int[R];//统计每种范围出现的次数
        //暂时存储最终结果的辅助数组
        String[] temp = new String[arr.length];
        //矫正顺序的辅助数组，for边界
        int[] index = new int[R + 1];
        for (int r = w - 1; r >= 0; r--) {
            //往cnt数组中放0
            Arrays.fill(cnt,0);
            for (String s : arr) {
                //char本身是数字，数字与字母映射
                cnt[s.charAt(r)]++;
            }
            for (int i = 0; i < R; i++) {
                //做前缀和，前缀和也是for的边界
                index[i + 1] = index[i] + cnt[i];

            }

            for(String s : arr) {
                temp[index[s.charAt(r)]] = s;
                index[s.charAt(r)]++;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"BCA","CAB","ACB","BAC","ABC","CBA"};
        LSDSort.sort(arr,3);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
