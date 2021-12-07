package liuyuboo;

public class UnionFind {
    //数组
    int[] id;

    public UnionFind(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public void unionElement(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }
        id[p] = qid;
    }
    public int find(int i) {
        if (id[i] == i) {
            return i;
        }
        return find(id[i]);
    }

    public boolean isConnected(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return true;
        }
        return false;
    }
}
