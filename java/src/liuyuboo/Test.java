package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    //输入位置-分数，按分数分成两队，保证两队分数相等，输出两个分队，保证误差在3之内，有多少种分队
    public static void partQueue(int[] arr) {
        //按分值排队，输出分值也行
        Arrays.sort(arr);
        int sum = 0;
        int sumz = 0;
        int diff = 0;

        for (int i = 0; i < arr.length/2; i++) {
            sumz = arr[i] + arr[arr.length - 1];
            if (i == 0 || i == 3) {
                sum = arr[i] + arr[arr.length - 1];
            System.out.print(arr[i]+" "+ arr[arr.length - 1 - i] + " ");
            }
        }
        diff = sum * 2 - sumz;
        System.out.println("本队差值： "+(0 - diff));
    }
    public void part() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[8];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        //int[] arr = {3,10,9,5,5,7,8,9};
        partQueue(arr);
    }

    public static void main(String[] args) {
        Test test = new Test();
        //int[] arr = {3,10,9,5,5,7,8,9};
        test.part();
    }
}
