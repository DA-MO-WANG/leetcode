package liuyuboo;

public class SegamentTree_fx<E> {
    //快速查找一个区间上的统计信息
    //快速==》每个节点存储这个统计信息
    //把查找的过程固态化

    //存放待处理的数据信息
    E[] data;
    //表示线段树结构
    E[] tree;

    public SegamentTree_fx(E[] arr) {
        //初始化这个线段树结构
        this.data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        //模拟满二叉树
        this.tree = (E[])new Object[4 * arr.length];


    }
}
