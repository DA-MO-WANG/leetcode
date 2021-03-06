package liuyuboo;

import java.nio.charset.CharacterCodingException;

public class BinarySearch {
    public <E extends Comparable<E>> int search(E[] data, E target) {
        int lo = 0;
        int hi = data.length - 1;

        while (lo <= hi) {//=在逻辑中对应，单个元素也会走流程，而不会被拒绝
            //计算机也是对应的现实世界，他永远不可能脱离真实世界中的一切东西
            //编程语言只是一种符号体系，符号体系发明用来解释真实世界的一些东西
            //符号的背后还是各种关系-联系-目的-过程
            int mid = lo + ((hi - lo) >> 1);//不确定的时候加括号
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

    //>target的最小值
    public int upper(int[] arr, int target) {
        //[0,arr,length] 这个遍历范围是确保涵盖满足target结果的所有可能位置
        //尽管length处不存在<----为了让指针在最后一种情况时，跑到length处指示
        //[0,length - 1]无法判断target在最右面的情况，因为即使target比最大值都大，指针也是停留在length - 1
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        if (hi > arr.length - 1) {
            return -1;
        }
        return arr[hi];
    }

    public int lower_ceil(int[] arr, int target) {
        //>= target 的最小索引
        // error模版：(-1,length)的所有元素。错在没整理好数学表达式
        //>= target最小值的三种答案情况：最小是0 ，不可能是比0 小的值；
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ( arr[mid] < target) {
                lo = mid + 1;
            }else if (arr[mid] >= target){
                hi = mid;
            }

        }
        return hi;
    }

    public int lower(int[] arr, int target) {
        //解决空间： -1，length-1
        int lo = -1;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid;
            }else if (arr[mid] >= target) {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
       /* String str = "f";
        char[] letters =  str.toCharArray();

        Character le = 'f';
        Character[] letter = new Character[str.length()];
        for (int i = 0; i < letters.length; i++) {
            letter[i] = letters[i];
        }
        BinarySearch b = new BinarySearch();
        int search = b.<Character>search(letter, le);
        System.out.println(search == str.indexOf('f'));*/
        BinarySearch b = new BinarySearch();
        int lower_ceil = b.lower(new int[]{1,1,3,3,5,5}, 6);
        System.out.println(lower_ceil);
        //System.out.println(-1/2);

    }

}
