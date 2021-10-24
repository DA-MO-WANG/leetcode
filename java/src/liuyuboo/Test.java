package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    //输入位置-分数，按分数分成两队，保证两队分数相等，输出两个分队，保证误差在3之内，有多少种分队
    //保证两队分值相差不大
    //保证高手对高手

    //最接近的四数之和
    

    public void partQueue(int[] arr) {
        //按分值排队，输出分值也行
        //Arrays.sort(arr);
        int sumz = getSum(arr);
        List<List<Integer>> lists = fourSum(arr, sumz << 1);

        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).stream().forEach(System.out::println);
            IntSummaryStatistics collect = lists.get(i).stream().collect(Collectors.summarizingInt(value -> value));
            long sum = collect.getSum();
            System.out.println("本次分队差值： "+ (sum * 2 - sumz));

        }
        //int diff = 0;
        //Map<Integer,Integer> map = new HashMap<>(8);

        //diff = sum * 2 - sumz;
        //System.out.println("本队差值： "+(0 - diff));
    }

    /**
     * 求和
     * @param arr
     * @return
     */
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
        }
        return sum;
    }
    //处理输入问题，把字符串转化成数组
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
