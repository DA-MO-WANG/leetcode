package liuyuboo;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr,l,r);
    }
    public void mergeSort(int[] arr, int l, int r) {

        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1, r);
        merge(arr,l,mid,r);
    }
    public void merge(int[] arr, int l, int mid, int r) {
        int[] newarr = Arrays.copyOfRange(arr, l,r + 1);

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            //左边数组走完了，只剩下右边数组
            if (i > mid) {
                arr[k] = newarr[j - l];
                j++;
            }else if (j > r) {
                arr[k] = newarr[i - l];
                i++;
            }else if (newarr[i - l] < newarr[j - l]) {
                arr[k] = newarr[i - l];
                i++;
            }else {
                arr[k] = newarr[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,9,6,4,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        //Arrays.asList(arr).forEach(item->System.out.println(item));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
