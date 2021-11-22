package liuyuboo;

public class MaxHeap<E extends Comparable<E>> {
    //底层用动态数组来表示
    Array<E> data;

    int size;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    //给出最大堆一个索引，让我返回父索引
    private int parent(int index){
        if (index == 0) {
            throw new IllegalArgumentException("索引0处没有父节点");
        }
        return index / 2;
    }

    private int leftChild(int index){
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }
    //添加元素
    public void add(E e){

        //1.添加到尾部
        data.addLast(e);
        siftUp(data.getSize() - 1);


        //2.上浮，浮到他应该在的位置
    }

    private void siftUp(int k) {
        while (k >= 1 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            //执行交换
            swap(data,k,parent(k));
            k = parent(k);
        }
    }

    private void swap(Array<E> data, int i , int j) {
        E temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }
    //从最大堆中移除元素
    public E extractMax(){

        //1.把尾部元素与顶部元素交换
        swap(data,1,data.getSize() - 1);
        //2.删除尾部元素
        E e = data.removeLast();
        //3.下沉原最后元素
        siftDown(1);
        return e;
    }

    private void siftDown(int k) {
        while(leftChild(k) < data.getSize()){//底部边界
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 )//数组中不越界，右部端点比左部大
                j ++;//用j来保存较大值的索引--即使右端点不存在，默认j还是左端点
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;

            data.swap(k, j);
            k = j;//一个j就解决了我的一堆if-else
        }
    }
    //堆排序
    public void sort(E[] data) {

    }
    //这里都是指最大位置
    public void replace(E e) {
        data.set(1,e);
        siftDown(1);
    }

    public void heapify(Array data) {
        //找到非叶子结点的最后一个位置
        this.data = data;//从0 开始
        int j = parent(data.getSize() - 1);//考虑到索引偏移--这里有问题！！！！
        for (int i = j; i >=1; i--) {
            siftDown(i);
        }
    }


}
