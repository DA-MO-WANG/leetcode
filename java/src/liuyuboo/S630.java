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
    class MinHeap<E> {
        Array<E> data;
        Comparator<E> comparator;
        public MinHeap(int capacity) {
            this.data = new Array<>(capacity);
        }

        public MinHeap(Comparator<E> comparator) {
            this.data = new Array<>();
            this.comparator = comparator;
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
            siftUp(data.getSize() - 1,comparator);
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
            siftDown(0,comparator);
            return e;
        }

        //获取最小值
        public E findMin() {
            return data.get(0);
        }
        //替换
        public void replace(E e) {
            data.set(0,e);
            siftDown(0,comparator);
        }

        //堆化
        public void heapify(E[] arr) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                //[0,非叶子节点]每一个都下沉到该在的位置，每一个元素与越来越多的元素去比对
                siftDown(arr,i,comparator);
            }
        }

        //堆排序
        public void heapSort(E[] arr) {
            heapify(arr);
            for (int i = arr.length - 1; i >= 0; i--) {
                swap(arr,0,i);
                siftDown(arr,0,i,comparator);
            }
        }

        //上浮
        public void siftUp(E[] arr, int k,Comparator<E> comparator) {
            while (parent(k) >= 0) {
                if (comparator.compareTo(arr[parent(k)],arr[k]) < 0) {
                    break;
                }else {
                    swap(parent(k),k);
                }
                k = parent(k);
            }
        }
        public void siftUp(int k,Comparator<E> comparator) {
            while (parent(k) >= 0) {
                if (comparator.compareTo(data.get(parent(k)),data.get(k)) < 0) {
                    break;
                }else {
                    swap(parent(k),k);
                }
                k = parent(k);
            }
        }

        //下沉
        public void siftDown(E[] arr, int k, int n,Comparator<E> comparator) {
            while (leftChild(k) < n) {
                int i = leftChild(k);
                if (i + 1 < n && comparator.compareTo(arr[i + 1],arr[i]) < 0) {
                    i = i + 1;
                }
                if (comparator.compareTo(arr[k],arr[i]) > 0) {
                    swap(arr, k, i);
                } else {
                    break;
                }
                k = i;
            }
        }
        public void siftDown(E[] arr, int k,Comparator<E> comparator) {
            while (leftChild(k) < arr.length) {
                int i = leftChild(k);
                if (i + 1 < arr.length && comparator.compareTo(arr[i + 1],arr[i]) < 0) {
                    i = i + 1;
                }
                if (comparator.compareTo(arr[k],arr[i]) > 0) {
                    swap(arr,k,i);
                }else {
                    break;
                }
                k = i;
            }
        }
        public void siftDown(int k,Comparator<E> comparator) {
            while (leftChild(k) < data.getSize()) {
                int i = leftChild(k);
                if (i + 1 < data.getSize() && comparator.compareTo(data.get(i + 1),data.get(i)) < 0) {
                    i = i + 1;
                }
                if (comparator.compareTo(data.get(k),data.get(i)) > 0) {
                    swap(k,i);
                }else {
                    break;
                }
                k = i;

            }
        }
    }
    class PriorityQueue<E> {
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

        public PriorityQueue(Comparator<E> comparator) {
            this.minHeap = new MinHeap(comparator);
        }

        public void enqueue(E e) {
            minHeap.add(e);
        }
        public E dequeue() {
            return minHeap.extract();
        }

        public boolean isEmpty() {
            return minHeap.isEmpty();
        }

        public int getSize() {
            return minHeap.size();
        }





    }
    interface Comparator<E>{
        int compareTo(E e1, E e2);
    }
    public class PriorityQueue1<E> {
        //
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
        class MaxHeap<E> {

            private Array<E> data;
            Comparator<E> comparator;
            public MaxHeap(int capacity,Comparator<E> comparator){
                data = new Array(capacity);
                this.comparator = comparator;
            }

            public MaxHeap(Comparator<E> comparator){
                data = new Array<>();
                this.comparator = comparator;
            }

            public MaxHeap(E[] arr){
                data = new Array<>(arr);
                if(arr.length != 1){
                    for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
                        siftDown(i,comparator);
                }
            }

            // 返回堆中的元素个数
            public int size(){
                return data.getSize();
            }

            // 返回一个布尔值, 表示堆中是否为空
            public boolean isEmpty(){
                return data.isEmpty();
            }

            // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
            private int parent(int index){
                if(index == 0)
                    throw new IllegalArgumentException("index-0 doesn't have parent.");
                return (index - 1) / 2;
            }

            // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
            private int leftChild(int index){
                return index * 2 + 1;
            }

            // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
            private int rightChild(int index){
                return index * 2 + 2;
            }

            // 向堆中添加元素
            public void add(E e){
                data.addLast(e);
                siftUp(data.getSize() - 1,comparator);
            }

            private void siftUp(int k, Comparator<E> comparator){

                while(k > 0 && comparator.compareTo(data.get(parent(k)),data.get(k)) < 0 ){
                    data.swap(k, parent(k));
                    k = parent(k);
                }
            }

            // 看堆中的最大元素
            public E findMax(){
                if(data.getSize() == 0)
                    throw new IllegalArgumentException("Can not findMax when heap is empty.");
                return data.get(0);
            }

            // 取出堆中最大元素
            public E extractMax(){

                E ret = findMax();

                data.swap(0, data.getSize() - 1);
                data.removeLast();
                siftDown(0,this.comparator);

                return ret;
            }

            private void siftDown(int k, Comparator<E> comparator){

                while(leftChild(k) < data.getSize()){
                    int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
                    if( j + 1 < data.getSize() &&
                            comparator.compareTo(data.get(j + 1),data.get(j)) > 0 )
                        j ++;
                    // data[j] 是 leftChild 和 rightChild 中的最大值

                    if(comparator.compareTo(data.get(k),data.get(j)) >= 0 )
                        break;

                    data.swap(k, j);
                    k = j;
                }
            }

            // 取出堆中的最大元素，并且替换成元素e
            public E replace(E e){

                E ret = findMax();
                data.set(0, e);
                siftDown(0,comparator);
                return ret;
            }
        }

        MaxHeap<E> maxHeap;

        public PriorityQueue1(Comparator<E> comparator) {
            this.maxHeap = new MaxHeap(comparator);
        }

        public void enqueue(E e) {
            maxHeap.add(e);
        }
        public E dequeue() {
           return maxHeap.extractMax();
        }
        public E peer1() {
            return maxHeap.findMax();
        }

        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }

        public int getSize() {
            return maxHeap.size();
        }





    }
    public int scheduleCourse(int[][] courses) {
        Comparator<Course> lastc = new Comparator<Course>() {
            @Override
            public int compareTo(Course e1, Course e2) {
                return e1.lastday - e2.lastday;
            }
        };
        PriorityQueue<Course> minqueue = new PriorityQueue<>(lastc);

        for (int i = 0; i < courses.length; i++) {
            if(courses[i][0] >courses[i][1]) {
                minqueue.enqueue(new Course(courses[i][0],courses[i][1]));
            }
        }
        Comparator<Course> dc = new Comparator<Course>() {
            @Override
            public int compareTo(Course e1, Course e2) {
                return e1.duration - e2.duration;
            }
        };
        PriorityQueue1 maxqueue = new PriorityQueue1(dc);
        Course[] cret = new Course[minqueue.getSize()];
        Course cbegin = minqueue.dequeue();
        cret[0] = cbegin;
        maxqueue.enqueue(cbegin);
        int sumdua = 0;
        int index = 0;
        while (minqueue.isEmpty()) {

            //待选择列表中最小截止期限
            Course lmin = minqueue.dequeue();
            //当前选择的课程的持续时间

            //已选择当中，持续时间最长的
            Course dmax = (Course) maxqueue.peer1();
            sumdua += cret[index].duration;
            if(sumdua + lmin.duration > lmin.lastday) {
                if (dmax.duration > lmin.duration) {
                    maxqueue.dequeue();
                    cret[index] = lmin;
                    maxqueue.enqueue(lmin);
                    sumdua -= dmax.duration;
                }else {
                    break;
                }
            }else {
                maxqueue.enqueue(lmin);
                cret[index + 1] = lmin;
            }
            index++;
        }
        return maxqueue.getSize();

    }
    class Course{
        int duration;
        int lastday;

        public Course(int d, int last) {
            this.duration = d;
            this.lastday = last;
        }
    }
}
