package liuyuboo;

import javax.print.DocFlavor;
import java.util.Random;

public class S215 {
    public int findKthLargest(int[] nums, int k) {
        //和k最小，本质是一样的，就是颠倒过来
        findk(nums, 0, nums.length - 1, k - 1, new Random());
        return this.count;

    }
    int count =  -1;
    public void findk(int[] arr, int l, int r,int k,Random random) {
        if (l > r) return ;
        int p = partition(arr, l, r, random);
        System.out.println(p);
        print(arr);
        if (p == k) count =  arr[p];
        if (p > k)  findk(arr,l,p - 1,k,random);
        if (p < k)  findk(arr,p + 1,r,k,random);
    }
    public void print(int[] arr) {
        System.out.print("当前元素：");
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
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
        int[] arr = new int[]{8,2};
        S215 s215 = new S215();
        int findk = s215.findKthLargest(arr,  2);
        System.out.println(findk);
    }
}
