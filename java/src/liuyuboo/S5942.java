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
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        List<List<Integer>> lists=new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        //Map<Integer,Integer> map =new LinkedHashMap<>(3);
        //n 不需要-和目标
    //k 组合的数量
        public int[] findEvenNumbers1(int[] digits, int num) {
            Arrays.sort(digits);
            ArrayList list = new ArrayList()；

            backtrack(digits,num);
            //int[] ret = new int[set.size()];
            //int count = 0;
            //for (Integer v : set) {
           //     ret[count++] = v;
           // }
            //Arrays.sort(ret);
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
        int[] arr = {4,0,5,4,5,7,9,6,4,7,6,9,5,9,1,4,7,8,0,3,2,5,3,1,5,9,3,4,8,8,4,2,7,5,8,2,1,5,5,1,0,7,8,1,0,3,6,3,6,6,7,5,2,1,2,2,8,9,9,1,8,6,8,6,4,7,9,8,9,2,0,7,0,6,2,4,5,4,8,7,3,4,1,9,0,1,0,3,0,2,6,2,3,7,6,1,3,9,3,0};
        S5942 s5942 = new S5942();
        int[] order = s5942.findEvenNumbers(arr);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }


    }
}
