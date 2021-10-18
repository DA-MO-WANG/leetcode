package liuyuboo;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr,l,r);
    }
    public void mergeSort(int[] arr, int l, int r) {
        int mid = (l + r) / 2;
        if (l > r) return;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1, r);
        merge(arr,l,mid,r);
    }
    public void merge(int[] arr, int l, int mid, int r) {
        int[] newarr = Arrays.copyOf(arr, arr.length);
        int i = l;
        int j = mid + 1;
        while (i > mid || j >r) {
            if (newarr[i] < newarr[j]) {
                arr[i] = newarr[i];
                i++;
            }else {
                arr[j] = newarr[j];
                j++;
            }
        }
        while (i <= mid) {
            arr[i] = newarr[i];
            i++;
        }
        while (j <= r) {
            arr[j] = newarr[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,9,6,4,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        
    }
}
