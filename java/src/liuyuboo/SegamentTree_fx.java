package liuyuboo;

public class SegamentTree_fx<E> {
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

    //
    public

}
