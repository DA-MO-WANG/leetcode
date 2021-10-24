package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    //输入位置-分数，按分数分成两队，保证两队分数相等，输出两个分队，保证误差在3之内，有多少种分队
    //保证两队分值相差不大
    //保证高手对高手

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        //mergeSort(nums, 0, len - 1, new int[len]);
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        if (len < 4) return list;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = len - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[m]);
                        l.add(nums[n]);
                        list.add(l);
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    }
                }
            }
        }
        return list;
    }
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
