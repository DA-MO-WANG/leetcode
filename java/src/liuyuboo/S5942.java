package liuyuboo;



import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.Map;
import java.util.Set;

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
    public int[] findEvenNumbers2(int[] digits) {
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


    //ArrayList<Integer> lists = new ArrayList();
    HashSet<Integer> set = new HashSet<>();
    LinkedList<Integer> list = new LinkedList<>();
    //n 不需要-和目标
    //k 组合的数量
    public int[] findEvenNumbers1(int[] digits, int num) {
        Arrays.sort(digits);
        if(digits[0] == digits[digits.length - 1] ) {
            if(digits[0] == 0) {
                return new int[]{};
            }else {
                int sum = digits[0] * 100 + digits[0] * 10 + digits[0];
                if(sum % 2 == 0) {
                    int[] ret1 = new int[1];
                    ret1[0] = sum;
                    return ret1;
                }else {
                    return new int[]{};
                }
            }

        }
        backtrack(digits,num);
        Integer[] ret = set.toArray(new Integer[0]);
        return Arrays.stream(ret).mapToInt(Integer::intValue).sorted().toArray();
    }
    public void backtrack(int[] arr, int k){
        int ret = 0;
        if(list.size()==k && (ret = check(arr,list)) > 0){
            set.add(ret);
            //lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i< arr.length;i++){
            //if(i>count && arr[i]==arr[i-1]) continue;
            if (list.size() < k && !list.contains(i)) {
                list.add(i);
                backtrack(arr,k);
                list.removeLast();
            }

        }
    }

    public int[] findEvenNumbers(int[] digits) {
        return findEvenNumbers1(digits,3);
    }
    public int check(int[] arr, LinkedList<Integer> list) {
        int ret = 0;
        int three = arr[list.get(0)];
        int two = arr[list.get(1)];
        int one = arr[list.get(2)];

        if (three == 0 || one % 2 != 0) {
            ret = -1;

        } else {
            ret = three * 100 + two * 10 + one * 1;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] arr = {6,2,5,4,9,7,7,6,2,9,1,4,4,5,4,2,9,5,9,8,3,4,0,0,3,7,6,0,5,7,4,8,3,7,2,5,2,0,6,3,1,8,6,7,1,6,1,2,9,8,5,2,3,3,4,5,4,1,0,5,0,1,2,7,6,8,8,3,1,4,0,8,1,0,0,5,9,7,8,6,5,1,6,9,9,7,0,8,4,9,3,7,3,3,2,9,2,6,1,8};
        S5942 s5942 = new S5942();
        int[] order = s5942.findEvenNumbers(arr);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }


    }
}
