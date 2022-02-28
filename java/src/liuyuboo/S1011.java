package liuyuboo;

import java.util.Arrays;

public class S1011 {
    public int shipWithinDays(int[] weights, int D) {
        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();
        //System.out.println(hi);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!check(weights,mid,D)) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo + (hi - lo) / 2;
    }
    public boolean check(int[] weights, int k, int D) {
        //System.out.println(k);
        int sum = 0;
        int sumpre = 0;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            System.out.println("中间sum" + sum);
            if (sum + weights[i] > k) {
                sum = 0;
                count++;
            }
            sum += weights[i];

        }
        if (sum <= k) {
            count++;
        }
        return count <= D;
    }
    public int getSum(int[] arr, int key) {
        int sum = 0;
        for (int i = 0; i <= key; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        /*int[] arr = {1,2,3,1,1};
        S1011 s1011 = new S1011();
        int i = s1011.shipWithinDays(arr, 4);
        System.out.println(i);*/






    }
}
