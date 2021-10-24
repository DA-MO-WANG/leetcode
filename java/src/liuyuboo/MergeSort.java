package liuyuboo;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        this.count = 0;
        mergeSort(arr,l,r);
    }
    public void mergeSort(int[] arr, int l, int r) {

        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid + 1, r);
        merge(arr,l,mid,r);
    }
    int count = 0;
    public void merge(int[] arr, int l, int mid, int r) {
        int[] newarr = Arrays.copyOfRange(arr, l,r + 1);
        //int[] newarr = Arrays.copyOf(arr, arr.length);
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
            }else if (newarr[i - l] <= newarr[j - l]) {
                arr[k] = newarr[i - l];
                i++;
            }else {
                arr[k] = newarr[j - l];
                count += mid - i + 1;
                j++;
            }
        }



       /* while (i <= mid && j <= r) {
            if (newarr[i] < newarr[j]) {
                arr[l] = newarr[i];
                i++;
                l++;
            }else {
                arr[l] = newarr[j];
                l++;
                j++;
            }
        }
        while (i <= mid) {
            arr[l] = newarr[i];
            i++;
        }
        while (j <= r) {
            arr[l] = newarr[j];
            j++;
        }*/
    }

    public static void main(String[] args) {
        //StringBuffer
        int[] arr = {7,5,6,4};
        MergeSort mergeSort = new MergeSort();
        int pairs = mergeSort.reversePairs(arr);
        //Arrays.asList(arr).forEach(item->System.out.println(item));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n---------------");
        System.out.println(pairs);
    }

    public int reversePairs(int[] nums) {
        int[] temp = Arrays.copyOf(nums,nums.length);
        return mergeSort(nums,0,nums.length - 1,temp);
    }
    //返回[l,r]区间中的逆序对数量
    public int mergeSort(int[] arr, int l , int r,int[] temp) {
        int mid = l + (r - l) / 2;
        if(l >= r) return 0;
        int res = 0;
        res += mergeSort(arr,l,mid,temp);
        res += mergeSort(arr,mid+1, r, temp);
        res += merge(arr,l,mid,r,temp);
        return res;
    }
    //合并有序数组[l,mid] [mid+1,r]到一个新的数组,处理l-r区间内的数据
    public int merge(int[] arr, int l , int mid, int r, int[] temp) {
        System.arraycopy(arr,l,temp,l,r - l + 1);
        int i = l;
        int j = mid + 1;
        int count = 0;
        for(int k = l; k <= r; k++) {
            if(i > mid) {
                arr[k] = temp[j];
                j++;
                continue;
            }
            if(j > r) {
                arr[k] = temp[i];
                i++;
                continue;
            }
            if(temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                count += mid - i + 1;
                j++;
            }
        }
        return count;
    }


}
