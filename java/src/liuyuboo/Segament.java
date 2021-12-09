package liuyuboo;

public interface Segament<E> {
    //返回[l,r]区间上的统计信息
    public E query(int l, int r);
    //修改原数据的指定位置元素值，更新线段树
    public void replace(int index, E e);
}
