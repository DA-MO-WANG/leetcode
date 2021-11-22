package liuyuboo;

import java.util.Arrays;

public class MergeSort {
    //第一轮温故知新
    //先清点一下自己肚子里这方面有多少存活--知道自己有多少东西，才能谈获取新东西，否则新旧不分就容易造成混乱



    //自底向上的归并排序
    public void mergeSort1_2(int[] arr) {
        int[] oldArr = Arrays.copyOf(arr,arr.length);
        //收获：先搞清原理---不是说有了原理就够了，原理代表全部。而是原理对于一个算法，是最容易接触的开始。而且也是逻辑链的开端
        //知道了原理和写出来是两回事
        //我写不出来，是因为我不知道这个逻辑中，哪里在提示我要用循环
        //知道要用循环了，循环要想写对，离不开搞清循环不变量。这里的循环不变量就是那一对处理区间，这些我没意识到。
        //计算机为什么跟数学老说有联系，因为数学是规律学科，计算机是机械学科，规律本身特别适合用机械表示
        for (int sz = 1; sz < arr.length; sz = sz + sz) {
            for (int i = 0; i < arr.length - sz; i = i + sz + sz) {
                //循环不变量：处理区间-  [i,i+sz )  [i+sz, i + sz + sz)
                int hi = i + sz + sz -1;
                //特殊情况：没凑对，有落单-n-1
                if (i + sz + sz - 1 > arr.length -1) {
                    hi = arr.length - 1;
                }
                mergeSort1_1(arr,i,hi,oldArr);
            }
        }
        //间隔sz  1-arr.length
    }

    public void mergeSort1_1(int[] arr) {
        //递归方案
        int[] oldArr = new int[arr.length];
        mergeSort1_1(arr,0,arr.length - 1,oldArr);

    }
    //第二个问题：分开两部分，分别排序
    //方法参数的设计取决于我要做什么，我要处理[lo,hi]这个区间上的未排序数据
    public void mergeSort1_1(int[] arr, int lo , int hi, int[] oldArr) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort1_1(arr,lo,mid,oldArr);//[lo,mid]
        mergeSort1_1(arr,mid + 1,hi,oldArr);//[mid + 1,hi]
        merge1_1(arr,lo,mid,hi,oldArr);
    }
    //分解问题为小规模的问题
    //把两个有序数组合并成一个大的有序数组
    public void merge1_1(int[] arr, int lo, int mid, int hi, int[] oldArr) {
        System.arraycopy(arr,lo,oldArr,lo,hi - lo + 1);
        //oldArr = Arrays.copyOfRange(arr, lo, hi + 1);//error1:这个API负责[lo,hi + 1) = [lo,hi]
        //如何处理这个辅助数组，涉及指针的操作
        int i = lo;//我需要一个东西帮我跑完左边数组
        int j = mid + 1;//我需要一个东西帮我跑完右边
        int p = lo;//我需要一个东西帮我记录排序后新状态
        for (p = lo; p <= hi; p++){
            //情况一：左边用尽，右边还有
            if (i > mid && j <= hi) {//外层有循环，所以用if
                arr[p] = oldArr[j++];
            }else if ( j > hi && i <= mid) {//情况2：右边用尽，左边还有
                arr[p] = oldArr[i++];
            }else if (oldArr[i] < oldArr[j]) {//情况3：两边都能拿出来元素
                arr[p] = oldArr[i++];
            }else {
                arr[p] = oldArr[j++];
            }
        }
    }







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
        /*//StringBuffer
        int[] arr = {7,5,6,4};
        MergeSort mergeSort = new MergeSort();
        int pairs = mergeSort.reversePairs(arr);
        //Arrays.asList(arr).forEach(item->System.out.println(item));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n---------------");
        System.out.println(pairs);*/


        //测试1_1
        MergeSort mergeSort = new MergeSort();
        int[] left = {2,5,8,9};
        int[] right = {3,10,17,33};
        int[] arr = {2,5,8,9,3,10,17,33};
        mergeSort.mergeSort1_1(arr,0,7,new int[8]);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n---------------");
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
