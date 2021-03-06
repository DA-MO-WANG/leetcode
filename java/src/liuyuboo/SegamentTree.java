package liuyuboo;

public class SegamentTree<E> {
    //有两个底层结构
    //一个是表示要处理的数据
    E[] data;
    //一个是用来表示线段树结构的数组-完全二叉树
    E[] tree;
    Merge<E> merge;

    public SegamentTree(E[] arr, Merge<E> merge) {
        //error1:data必须new分配内存，否则无法初始化
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.merge = merge;
        //开空间，内存分配
        this.tree =(E[]) new Object[4 * data.length];
        buildSegamentTree(0,0,data.length - 1);
    }

    //线段树中的索引关系
    public int leftChild(int treeIndex) {
        return 2 * treeIndex + 1;
    }

    public int rightChild(int treeIndex) {
        return 2 * treeIndex + 2;
    }
    //这个函数我要做的是：
    //在表示线段树结构的数组上，在treeIndex位置上，构建[l,r]区间内的线段树
    //treeIndex是关乎tree的；l r 是关乎data的
    public void buildSegamentTree(int treeIndex, int l , int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChidIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        buildSegamentTree(leftChidIndex,l,mid);
        buildSegamentTree(rightChildIndex,mid + 1, r);
        tree[treeIndex] = merge.merge(tree[leftChidIndex],tree[rightChildIndex]);
    }
    public E query(int l, int r) {
        return query(0,0,data.length - 1, l, r);
    }

    public E query(int treeIndex, int l , int r, int queryl, int queryr) {
        //边界检查
        if (queryl < 0 || queryr >= data.length ) {
            throw new IllegalArgumentException("argument is illegal!");
        }
        if (queryl == l && queryr == r) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        if (queryl >= mid + 1) {
            return query(rightChildIndex,mid + 1,r,queryl,queryr);
        }else if (queryr < mid + 1) {
            return query(leftChildIndex,l,mid,queryl,queryr);
        }
        E e = query(leftChildIndex,l,mid,queryl,mid);
        E e1 = query(rightChildIndex,mid + 1, r, mid + 1,queryr);
        return merge.merge(e,e1);
    }

    public void replace(int index, E e) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("index is illegal!");
        }
        data[index] = e;
        //更新线段树上的区间值
    }
    //在以treeIndex为根的线段树上更新值e
    public void set(int treeIndex, int l, int r, int index , E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        //递归分支89
        if (index >= mid + 1) {
            set(rightChildIndex,mid + 1, index,index,e);
        }else {
            set(leftChildIndex,l,mid,index,e);
        }
        //重新构建一次
        merge.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    public static void main(String[] args) {
        int[] arr = new int[0];
    }
}
