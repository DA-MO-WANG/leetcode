package liuyuboo;

public class BubbleSort<E extends Comparable<E>> {
    //优化看数据情况
    public void bubbleSort(E[] data) {
        boolean flag = false;
        for (int i = 0; i < data.length; i++) {//第一个循环是轮数

            for (int j = 0; j < data.length - i - 1; j++) {//第二个循环是比较环节
                if (data[j].compareTo(data[j+1]) > 0) {
                    flag = true;
                    swap(data,j,j+1);
                }
            }
            if (flag) {
                break;
            }
        }

    }
    public void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] arr = new Integer[]{1,2,3,4};
        bubbleSort.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
