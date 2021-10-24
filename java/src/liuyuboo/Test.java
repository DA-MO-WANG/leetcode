package liuyuboo;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    //输入位置-分数，按分数分成两队，保证两队分数相等，输出两个分队，保证误差在3之内，有多少种分队
    //保证两队分值相差不大
    //保证高手对高手
    //最接近的四数之和
    public List<List<Integer>> threeSumClosest(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int ret = nums[0] + nums[1] + nums[2];
        // 先将数组变为升序的
        Arrays.sort(nums);
        // 采用双指针遍历
        for (int i=0; i<nums.length-2; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int m = nums.length-1;
            for (int j=i+1; j<nums.length-1; j++) {
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                // 向左移动指针，且右指针在左指针的右边
                while(j < m && nums[i]+nums[j]+nums[m]>target) {
                    // 取最接近的值
                    if (Math.abs(ret - target) >= Math.abs(nums[i]+nums[j]+nums[m] - target)) {
                        ret = nums[i]+nums[j]+nums[m];
                    }
                    m = m-1;
                }
                if (j == m) {
                    break;
                }
                // 取最接近的值
                if (Math.abs(ret - target) >= Math.abs(nums[i]+nums[j]+nums[m] - target)) {
                    ret = nums[i]+nums[j]+nums[m];
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[m]);
                    lists.add(list);
                }
                /*if (ret == target) {
                    return ret;
                }*/
            }
        }
        return lists;
    }
    public void partQueue(int[] arr) {
        //按分值排队，输出分值也行
        //Arrays.sort(arr);
        int[] newarr = new int[7];
        int sumz = getSum(arr);
        System.arraycopy(arr,1,newarr,0,newarr.length);

        List<List<Integer>> lists = threeSumClosest(newarr, sumz / 2 - arr[0] );
            for(int i = 0; i < lists.size(); i++) {
                List<Integer> list = lists.get(i);
                IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(value -> value));
                long sum = collect.getSum();
                System.out.print("本次分队选择"+(i + 1)+"： ");
                System.out.print(arr[0] + " ");
                print(list);
                System.out.print("  分队差值："+ ((sum + arr[0]) * 2 - sumz));
                System.out.println("  当前总分：" + sumz);
                //print(list);
            }

        }
        //int diff = 0;
        //Map<Integer,Integer> map = new HashMap<>(8);

        //diff = sum * 2 - sumz;
        //System.out.println("本队差值： "+(0 - diff));


    /**
     * 求和
     * @param arr
     * @return
     */
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
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
        int[] arr = {10,3,10,9,5,5,7,8};
        //test.part();
        //List<List<Integer>> list = test.threeSumClosest(arr, 57 / 2 - 10);
        test.partQueue(arr);

    }
}
