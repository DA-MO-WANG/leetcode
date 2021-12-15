package liuyuboo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class S630 {
    class Array<E> {

        private E[] data;
        private int size;

        // 构造函数，传入数组的容量capacity构造Array
        public Array(int capacity){
            data = (E[])new Object[capacity];
            size = 0;
        }

        // 无参数的构造函数，默认数组的容量capacity=10
        public Array(){
            this(10);
        }

        public Array(E[] arr){
            data = (E[])new Object[arr.length];
            for(int i = 0 ; i < arr.length ; i ++)
                data[i] = arr[i];
            size = arr.length;
        }

        // 获取数组的容量
        public int getCapacity(){
            return data.length;
        }

        // 获取数组中的元素个数
        public int getSize(){
            return size;
        }

        // 返回数组是否为空
        public boolean isEmpty(){
            return size == 0;
        }

        // 在index索引的位置插入一个新元素e
        public void add(int index, E e){

            if(index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

            if(size == data.length)
                resize(2 * data.length);

            for(int i = size - 1; i >= index ; i --)
                data[i + 1] = data[i];

            data[index] = e;

            size ++;
        }

        // 向所有元素后添加一个新元素
        public void addLast(E e){
            add(size, e);
        }

        // 在所有元素前添加一个新元素
        public void addFirst(E e){
            add(0, e);
        }

        // 获取index索引位置的元素
        public E get(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

        // 修改index索引位置的元素为e
        public void set(int index, E e){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            data[index] = e;
        }

        // 查找数组中是否有元素e
        public boolean contains(E e){
            for(int i = 0 ; i < size ; i ++){
                if(data[i].equals(e))
                    return true;
            }
            return false;
        }

        // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
        public int find(E e){
            for(int i = 0 ; i < size ; i ++){
                if(data[i].equals(e))
                    return i;
            }
            return -1;
        }

        // 从数组中删除index位置的元素, 返回删除的元素
        public E remove(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");

            E ret = data[index];
            for(int i = index + 1 ; i < size ; i ++)
                data[i - 1] = data[i];
            size --;
            data[size] = null; // loitering objects != memory leak

            if(size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);
            return ret;
        }

        // 从数组中删除第一个元素, 返回删除的元素
        public E removeFirst(){
            return remove(0);
        }

        // 从数组中删除最后一个元素, 返回删除的元素
        public E removeLast(){
            return remove(size - 1);
        }

        // 从数组中删除元素e
        public void removeElement(E e){
            int index = find(e);
            if(index != -1)
                remove(index);
        }

        public void swap(int i, int j){

            if(i < 0 || i >= size || j < 0 || j >= size)
                throw new IllegalArgumentException("Index is illegal.");

            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        @Override
        public String toString(){

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for(int i = 0 ; i < size ; i ++){
                res.append(data[i]);
                if(i != size - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }

        // 将数组空间的容量变成newCapacity大小
        private void resize(int newCapacity){

            E[] newData = (E[])new Object[newCapacity];
            for(int i = 0 ; i < size ; i ++)
                newData[i] = data[i];
            data = newData;
        }
    }
    class MinHeap<E extends Comparable<E>> {
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
    class PriorityQueue<E extends Comparable<E>> {
        class Array<E> {

            private E[] data;
            private int size;

            // 构造函数，传入数组的容量capacity构造Array
            public Array(int capacity){
                data = (E[])new Object[capacity];
                size = 0;
            }

            // 无参数的构造函数，默认数组的容量capacity=10
            public Array(){
                this(10);
            }

            public Array(E[] arr){
                data = (E[])new Object[arr.length];
                for(int i = 0 ; i < arr.length ; i ++)
                    data[i] = arr[i];
                size = arr.length;
            }

            // 获取数组的容量
            public int getCapacity(){
                return data.length;
            }

            // 获取数组中的元素个数
            public int getSize(){
                return size;
            }

            // 返回数组是否为空
            public boolean isEmpty(){
                return size == 0;
            }

            // 在index索引的位置插入一个新元素e
            public void add(int index, E e){

                if(index < 0 || index > size)
                    throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

                if(size == data.length)
                    resize(2 * data.length);

                for(int i = size - 1; i >= index ; i --)
                    data[i + 1] = data[i];

                data[index] = e;

                size ++;
            }

            // 向所有元素后添加一个新元素
            public void addLast(E e){
                add(size, e);
            }

            // 在所有元素前添加一个新元素
            public void addFirst(E e){
                add(0, e);
            }

            // 获取index索引位置的元素
            public E get(int index){
                if(index < 0 || index >= size)
                    throw new IllegalArgumentException("Get failed. Index is illegal.");
                return data[index];
            }

            // 修改index索引位置的元素为e
            public void set(int index, E e){
                if(index < 0 || index >= size)
                    throw new IllegalArgumentException("Set failed. Index is illegal.");
                data[index] = e;
            }

            // 查找数组中是否有元素e
            public boolean contains(E e){
                for(int i = 0 ; i < size ; i ++){
                    if(data[i].equals(e))
                        return true;
                }
                return false;
            }

            // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
            public int find(E e){
                for(int i = 0 ; i < size ; i ++){
                    if(data[i].equals(e))
                        return i;
                }
                return -1;
            }

            // 从数组中删除index位置的元素, 返回删除的元素
            public E remove(int index){
                if(index < 0 || index >= size)
                    throw new IllegalArgumentException("Remove failed. Index is illegal.");

                E ret = data[index];
                for(int i = index + 1 ; i < size ; i ++)
                    data[i - 1] = data[i];
                size --;
                data[size] = null; // loitering objects != memory leak

                if(size == data.length / 4 && data.length / 2 != 0)
                    resize(data.length / 2);
                return ret;
            }

            // 从数组中删除第一个元素, 返回删除的元素
            public E removeFirst(){
                return remove(0);
            }

            // 从数组中删除最后一个元素, 返回删除的元素
            public E removeLast(){
                return remove(size - 1);
            }

            // 从数组中删除元素e
            public void removeElement(E e){
                int index = find(e);
                if(index != -1)
                    remove(index);
            }

            public void swap(int i, int j){

                if(i < 0 || i >= size || j < 0 || j >= size)
                    throw new IllegalArgumentException("Index is illegal.");

                E t = data[i];
                data[i] = data[j];
                data[j] = t;
            }

            @Override
            public String toString(){

                StringBuilder res = new StringBuilder();
                res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
                res.append('[');
                for(int i = 0 ; i < size ; i ++){
                    res.append(data[i]);
                    if(i != size - 1)
                        res.append(", ");
                }
                res.append(']');
                return res.toString();
            }

            // 将数组空间的容量变成newCapacity大小
            private void resize(int newCapacity){

                E[] newData = (E[])new Object[newCapacity];
                for(int i = 0 ; i < size ; i ++)
                    newData[i] = data[i];
                data = newData;
            }
        }
        MinHeap<E> minHeap;

        public PriorityQueue() {
            this.minHeap = new MinHeap();
        }

        public void enqueue(E e) {
            minHeap.add(e);
        }
        public void dequeue() {
            minHeap.extract();
        }

        public boolean isEmpty() {
            return minHeap.isEmpty();
        }

        public int getSize() {
            return minHeap.size();
        }





    }
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Course> queue = new PriorityQueue<>();
        for (int i = 0; i < courses.length; i++) {
            if(courses[i][0] >courses[i][1]) {
                queue.enqueue(new Course(courses[i][0],courses[i][1]));
            }
        }



    }
    class Course implements Comparable<Course>{
        int duration;
        int lastday;

        public Course(int d, int last) {
            this.duration = d;
            this.lastday = last;
        }

        @Override
        public int compareTo(Course o) {
            return this.lastday - o.lastday;
        }
    }
}
