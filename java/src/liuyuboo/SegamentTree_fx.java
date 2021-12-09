package liuyuboo;
//复习完毕2021.12.9
public class SegamentTree_fx<E> implements Segament<E>{
    //快速查找一个区间上的统计信息
    //快速==》每个节点存储这个统计信息
    //把查找的过程固态化

    //存放待处理的数据信息
    E[] data;
    //表示线段树结构
    E[] tree;

    //封装一个统计器
    Merge<E> merge;

    public SegamentTree_fx(E[] arr,Merge<E> merge) {
        //初始化这个线段树结构
        this.data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.merge = merge;

        //模拟满二叉树
        this.tree = (E[])new Object[4 * arr.length];
        buildTree(0,0,data.length - 1,merge);


    }

    //构建树：从待处理结构到线段树结构
    //树的构建，至少有一种方法：天然递归结构。最小结构是一个节点，左右子树都为待定值
    //其余的部分就是替换这个左右部分，依次嵌套
    //谁来做这个最小结构的锚点-当前节点---》根节点的索引
    public void buildTree(int treeIndex, int l, int r, Merge<E> merge) {
        //递归的过程是不断切分 [l,r]
        //最底部-1个元素===>找定义：构建这一个元素的线段树--这一个元素值本身
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        //在切分过程中间
        //我来安排，左子树放什么-l,mid；右子树放什么-mid+1,r
        //要安排左子树，离不开左子树的根节点，右子树同理
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);

        int mid = l + (r - l) / 2;
        //tree[leftChildIndex]上的值已经填好了，根本不用函数返回
        //因为最底一层是单个区间值，返回的第一层递归，就是处理每个单区间的合并
        buildTree(leftChildIndex,l,mid,merge);
        buildTree(rightChildIndex,mid + 1, r,merge);
        tree[treeIndex] = merge.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    public int leftChildIndex(int treeIndex) {
        return 2 * treeIndex + 1;
    }

    public int rightChildIndex(int treeIndex) {
        return 2 * treeIndex + 2;
    }

    @Override
    public E query(int l, int r) {
        //lr指得是待处理元素，用户提供的部分

        return null;
    }
    //要查找，拿要查找的区间和线段树的结构区间去对比
    //queryl 和 l 比较--->现在思路上搞明白
    public E query(int treeIndex,int l , int r, int queryL, int queryR) {

        if (queryL == l && queryR == r) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);
        if (mid > queryR) {
            return query(leftChildIndex,l,mid,queryL,queryR);
        }else if(mid < queryL) {
            return query(rightChildIndex,mid + 1, r,queryL,queryR);
        }else {
            E e1 = query(leftChildIndex,l,mid,queryL,mid);
            E e2 = query(rightChildIndex,mid + 1, r, mid + 1,queryR);
            return merge.merge(e1,e2);
        }
    }


    @Override
    public void replace(int index, E e) {
        //int seindex = query1(0, 0, data.length - 1, index, index);
        data[index] = e;


    }
    //l，r是结构区间，不是要找的区间
    //结构区间要跟着变化
    //treeIndex--在这个根节点的树上，执行想要的操作--不断变换树
    public void set(int treeIndex, int l, int r, int index, E e) {
        //先走到底部
        if (l == r) {
            //既然走到这里了，那就说明按着预设路线走，终点一定是目标单节点
            tree[treeIndex] = e;
            //return e;
        }
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);
        //走到半截时--刚开始走--走到底部的前一步
        int mid = l + (r - l) / 2;
        if (mid >= index) {
            set(leftChildIndex,l,mid,index,e);
        }else {
            set(rightChildIndex,mid + 1, r,index,e);
        }
        //改变是位置的值，只要有固定的位置，就能拿到，不必返回
        merge.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }



}
