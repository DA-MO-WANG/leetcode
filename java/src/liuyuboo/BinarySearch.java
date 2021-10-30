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

    public static void main(String[] args) {
        String str = "f";
        char[] letters =  str.toCharArray();

        Character le = 'f';
        Character[] letter = new Character[str.length()];
        for (int i = 0; i < letters.length; i++) {
            letter[i] = letters[i];
        }
        BinarySearch b = new BinarySearch();
        int search = b.<Character>search(letter, le);
        System.out.println(search == str.indexOf('f'));

    }

}
