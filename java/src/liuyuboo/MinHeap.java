package liuyuboo;

public class MinHeap<E extends Comparable<E>> {
    Array<E> data;

    public MinHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MinHeap() {
        this.data = new Array<>();
    }

    public int size() {
        return this.data.getSize();
    }

    public boolean isEmpty() {
        return this.data.getSize() == 0;
    }

    //获取父节点索引--从0开始计数
    public int parent(int k) {
        if (k == 0) {
            throw new IllegalArgumentException("索引0处没有父节点");
        }
        return (k - 1) / 2;
    }

    public int leftChild(int k) {
        return k * 2 + 1;
    }
    public int rightChild(int k) {
        return k * 2 + 2;
    }

    //添加元素
    public void add(E e) {
        this.data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //交换
    public void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void swap(int i, int j) {
        E temp = this.data.get(i);
        this.data.set(i,this.data.get(j));
        this.data.set(j,temp);
    }
    //移除元素
    public E extract() {
        swap(0,data.getSize() - 1);
        E e = this.data.removeLast();
        siftDown(0);
        return e;
    }

    //获取最小值
    public E findMin() {
        return data.get(0);
    }
    //替换
    public void replace(E e) {
        data.set(0,e);
        siftDown(0);
    }

    //堆化
    public void heapify(E[] arr) {
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            //[0,非叶子节点]每一个都下沉到该在的位置，每一个元素与越来越多的元素去比对
            siftDown(arr,i);
        }
    }

    //堆排序
    public void heapSort(E[] arr) {
        heapify(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr,0,i);
            siftDown(arr,0,i);
        }
    }
}

    //上浮
    public void siftUp(E[] arr, int k) {
        while (parent(k) >= 0) {
            if (arr[parent(k)].compareTo(arr[k]) < 0) {
                break;
            }else {
                swap(parent(k),k);
            }
            k = parent(k);
        }
    }
    public void siftUp(int k) {
        while (parent(k) >= 0) {
            if (data.get(parent(k)).compareTo(data.get(k)) < 0) {
                break;
            }else {
                swap(parent(k),k);
            }
            k = parent(k);
        }
    }

    //下沉
    public void siftDown(E[] arr, int k, int n) {
        while (leftChild(k) < n) {
            int i = leftChild(k);
            if (i + 1 < n && arr[i + 1].compareTo(arr[i]) < 0) {
                i = i + 1;
            }
            if (arr[k].compareTo(arr[i]) > 0) {
                swap(arr, k, i);
            } else {
                break;
            }
            k = i;
        }
    }
    public void siftDown(E[] arr, int k) {
        while (leftChild(k) < arr.length) {
            int i = leftChild(k);
            if (i + 1 < arr.length && arr[i + 1].compareTo(arr[i]) < 0) {
                i = i + 1;
            }
            if (arr[k].compareTo(arr[i]) > 0) {
                swap(arr,k,i);
            }else {
                break;
            }
            k = i;
    }
    public void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int i = leftChild(k);
            if (i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(i)) < 0) {
                i = i + 1;
            }
            if (data.get(k).compareTo(data.get(i)) > 0) {
                swap(k,i);
            }else {
                break;
            }
            k = i;

        }
    }
}
