package liuyuboo;

public class BinarySearch {
    public <E extends Comparable<E>> int search(E[] data, E target) {
        int lo = 0;
        int hi = data.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) >> 1;
            if (target.compareTo(data[mid]))
        }
    }
}
