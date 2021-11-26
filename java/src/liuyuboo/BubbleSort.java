package liuyuboo;

public class BubbleSort<E extends Comparable<E>> {
    public void bubbleSort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j+1]) > 0) {
                    swap(data,j,j+1);
                }
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
        Integer[] arr = new Integer[]{3,1,4,2,7};
        bubbleSort.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
