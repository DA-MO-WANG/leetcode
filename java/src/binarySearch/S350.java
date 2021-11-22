package binarySearch;

import java.util.LinkedList;

public class S350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //转结构-被匹配数组
        LinkedList list = new LinkedList();
        for (int num : nums2) {
            list.add(num);
        }
        int[] ret = new int[Math.min(nums1.length,nums1.length)];
        int i = 0;
        for (int v : nums1) {
            if (list.contains(v)) {
                ret[i++] = v;
                list.remove(new Integer(v));
            }
        }
        return ret;
    }
}
