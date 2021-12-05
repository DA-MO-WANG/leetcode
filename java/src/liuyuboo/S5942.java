package liuyuboo;



import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

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

    public int[] getOrder(int[] nums) {
        
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0,0};
        S5942 s5942 = new S5942();
        int[] order = s5942.getOrder(arr);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }

    }
}
