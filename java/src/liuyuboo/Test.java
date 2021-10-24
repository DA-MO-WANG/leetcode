package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    //输入位置-分数，按分数分成两队，保证两队分数相等，输出两个分队，保证误差在3之内，有多少种分队
    public static void partQueue(int[] arr) {
        //按分值排队，输出分值也行
        Arrays.sort(arr);
        for (int i = 0; i < arr.length/2; i++) {
            System.out.println(arr[i]+" "+ arr[arr.length - 1 - i]);
        }

    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = {3,10,9,5,5,7,8,9};
        test.partQueue(arr);
    }
}
