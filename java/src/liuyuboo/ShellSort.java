package liuyuboo;

public class ShellSort {
    public void shellSort(int[] arr) {
        int n = arr.length / 2;
        for (int sz = n; sz > 0; sz = sz / 2) {
            for (int i = 0; i < 0 + sz; i++) {
                InsertSort(arr,sz,i,index(arr.length,sz,i));
            }
        }
    }

    public void InsertSort(int[] arr, int sz , int m , int n) {
        for (int i = m + 1; i <= n; i = i + sz) {
            for (int j = i - 1; j >= m; j = j - sz) {
                if (arr[i] < arr[j]) {
                    swap(arr,i,j);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int index(int len, int sz, int i) {
        int right = 0;
        right = i + sz;
        while (right + sz < len) {
            right += sz;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,3,4,11,9,7};
        ShellSort s = new ShellSort();
        s.shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
