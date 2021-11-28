package liuyuboo;

public class ShellSort {
    /*public void shellSort(int[] arr) {
        int n = arr.length / 2;
        for (int sz = n; sz >= 0; sz = sz / 2) {
            for (int i = 0; i < )
        }
    }*/

    public void InsertSort(int[] arr, int sz , int m , int n) {
        for (int i = m + 1; i <= n; i = i + sz + 1) {
            for (int j = i - 1; j >= m; j = j - sz - 1) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,3,4};
        ShellSort s = new ShellSort();
        s.InsertSort(arr,0,0,arr.length -1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
