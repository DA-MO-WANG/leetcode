package liuyuboo;

import javax.print.DocFlavor;
import java.util.Random;

public class S215 {
    public int findKthLargest(int[] nums, int k) {
        //和k最小，本质是一样的，就是颠倒过来
        int findk = findk(nums, 0, nums.length - 1, k, new Random());
        return findk;

    }
    public int findk(int[] arr, int l, int r,int k,Random random) {
        if (l >= r) return -1;
        int p = partition(arr, l, r, random);
        if (p == k) return arr[p];
        if (p > k) return findk(arr,l,p - 1,k,random);
        if (p < k) return findk(arr,p + 1,r,k,random);
        return -1;
    }
    public int partition(int[] arr, int l ,int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        int v = arr[p];
        int lt = l;
        int gt = r;
        int i = l + 1;
        while (i < gt) {
            //lt+1-i-1 ==v
            if (i < gt && arr[i] == v) {
                i++;
            }
            //l+1-lt >v
            if (i < gt && arr[i] > v) {
                swap(arr,i,lt + 1);
                lt++;
                i++;
            }
            //gt-r<v
            if (i < gt && arr[i] < v) {
                swap(arr,i,gt);
                gt--;
            }
        }
        swap(arr,0,lt);
        return lt;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        //swap(arr,i ,j);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        S215 s215 = new S215();
        int findk = s215.findk(arr, 0, arr.length - 1, 5, new Random());
        System.out.println(findk);
    }
}
