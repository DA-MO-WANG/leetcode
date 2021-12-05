package liuyuboo;



import java.util.*;
import java.util.Map;

public class S5942 {
    public int[] getOrder(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        HashSet<Integer> set = new HashSet<Integer>();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }

            int three = arr[i] * 100;
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                int two = arr[j] * 10;
                for (int q = 0; q < arr.length; q++) {
                    if (q == i || q == j || arr[q] % 2 != 0) {
                        continue;
                    }
                    int one = arr[q] * 1;
                    set.add(three + two + one);
                }

            }
        }
        int[] ret = new int[set.size()];
        int count = 0;
        for (Integer v : set) {

            ret[count++] = v;

        }
        Arrays.sort(ret);
        return ret;
    }

    //废弃
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int m = 0; m < 10; m++) {
                    set.add(i * 100 + j * 10 + m * 1);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer v : set) {
            int three = v / 100;
            int two = v / 10 % 10;
            int one = v % 100 % 10;
            int index3 = contains(digits,three);
            int index2 = contains(digits,two) ;
            int index1 = contains(digits,one);
            //if (contains(digits,three) && contains(digits,two) && contains(digits,one) && one % 2 == 0) {
              //  list.add(v);
            //}
        }
        int[] ret = new int[list.size()];
        Arrays.sort(ret);
        return ret;

    }
    public int contains(int[] arr, int v) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == v) {
                return mid;
            }else if (arr[mid] > v) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    //Set<List<Integer>> lists=new ArrayList<>();
    //List<Integer> list =new ArrayList<>();

    void backtrack(此时已经走完的路径，此次可选择的选择列表){
        if 满足结束条件：
        result.add(路径)；
        return；//一定要加，这个表示这个方向的结束；
        for（int i=0;i<选择列表长度；i++）{//这里要遍历所有的选择，将所有的选择考虑进去
            if 是否满足需求：
            //放入已经走完的路径里；
        else
            continue;
            //backtrack（此时已经走完的路径，此时的选择列表）；//注意这里的选择列表已经发生了变化，是刚放进路径的节点下一步的所有选择
            //撤销上一步的路径；
        }
    }
    public int[] findEvenNumbers(int[] digits) {
        digits
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0,0};
        S5942 s5942 = new S5942();
        int[] order = s5942.findEvenNumbers(arr);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }

    }
}
