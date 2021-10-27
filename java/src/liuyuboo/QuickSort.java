package liuyuboo;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class QuickSort {
    private QuickSort() {}
    private void sort(int[] arr) {
        quichSort(arr,0,arr.length - 1);

    }
    public void quichSort(int[] arr, int l , int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quichSort(arr,l,p - 1);
        quichSort(arr,p + 1, r);
    }
    //确定标界点v，让v归位，营造出<v  v  >v 的效果
    public int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        //i用来走遍历
        //j用来作为两部分的分界点，扩容小区间
        for (int i = l + 1; i <= r; i++) {
            //暂时不处理v有重复的情况
            if (arr[i] > v) {
                //大区间：j+1,i

            }else {
                //j++为交换做准备，通过交换扩容小区间
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    public void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //双路排序
    public void sort21(int[] arr) {
        Random random = new Random();
        quickSort22(arr,0,arr.length - 1,random);
    }
    public int partition24(int[] arr, int l , int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr,p,l);
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (i <= j && i <= r && j > l) {
            if (arr[i] < v) {
                i++;
            }
            if (arr[j] > v) {
                j--;
            }
            if (arr[i] >= v && arr[j] <= v) {
                swap23(arr,i,j);
                i++;
                j--;
            }
        }
        swap23(arr,j + 1,l);
        return j;

    }
    public void quickSort22(int[] arr, int l, int r, Random random) {
        if ( l >= r) return;
        int p = partition24(arr, l, r, random);
        quickSort22(arr,l,p-1,random);
        quickSort22(arr,p + 1, r,random);
    }

    public void swap23(int[] arr, int i , int j) {
        swap(arr,i,j);
    }




    public static void main(String[] args) {
        int[] arr = new int[]{10,9,5,3,2,4};
        QuickSort q = new QuickSort();
        q.sort21(arr);
        for (int v  : arr) {
            System.out.print(v + " ");
        }
    }
}
