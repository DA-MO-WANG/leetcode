package liuyuboo;

public class BinarySearch {
    public <E extends Comparable<E>> int search(E[] data, E target) {
        int lo = 0;
        int hi = data.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) >> 1;
            if (target.compareTo(data[mid]) == 0) {
                return mid;
            }else if (target.compareTo(data[mid]) < 0) {
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "abcdefghgk";
        char[] letters = str.toCharArray();
        

    }
}
