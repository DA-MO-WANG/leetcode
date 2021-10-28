package liuyuboo;

import com.sun.tools.javac.util.Pair;

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
        while (true) {
            while (i <= j && arr[i] < v) {
                i++;
            }
            while (j >= i && arr[j] > v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap23(arr,i,j);
            i++;
            j--;

        }
        swap23(arr,j,l);
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


    //三路快排
    public void sort31(int[] arr) {
        quickSort33(arr,0,arr.length-1,new Random());
    }
    public Pair<Integer,Integer> partition32(int[] arr, int l , int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap34(arr,p,l);
        int v = arr[l];
        int lt = l;
        int gt = r;
        int i = l + 1;
        while (i < gt) {
            //lt+1  i-1
            if (arr[i] == v) {
                i++;
            }else if (arr[i] < v) {//扩展--占据挨着的别人来扩展
                //l+1,lt
                swap34(arr,i,lt + 1);
                lt++;//为了维护循环不变量，更新lt
            }else {//扩展大的区间，占据挨着的待处理来扩展
                swap34(arr,gt - 1, i);
                gt--;//为了维护 gt-r
                //gt--始终维护大v的第一个元素
                //lt--始终维护=v的前一个元素
            }

        }
        //i把所有元素都处理完了，必然会和gt碰头--此时进入终止态
        //到了处理标定点的事了
        swap34(arr,l,lt);
        //最后lt成为=v的第一个元素
        Pair pair = new Pair(lt,gt - 1);
        return pair;
    }

    public void quickSort33(int[] arr, int l, int r, Random random) {
        if (l >= r) return;
        Pair<Integer,Integer> pair = partition32(arr,l,r,random);
        quickSort33(arr,l,pair.fst - 1,random);
        quickSort33(arr,pair.snd + 1,r,random);
    }

    public void swap34(int[] arr, int i, int j) {
        swap23(arr,i,j);
    }



    public static void main(String[] args) {
        int[] arr = new int[]{4,6,2,1,67,3,3,2,8};
        QuickSort q = new QuickSort();
        q.sort31(arr);
        for (int v  : arr) {
            System.out.print(v + " ");
        }
    }
}
