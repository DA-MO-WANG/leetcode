package liuyuboo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Z5952 {
    public int countPoints(String rings) {
        int size = rings.length();
        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        int count = 0;
        int sum = 0;


        for(int i = 1; i < size; i = i + 2) {
            Character gan = rings.charAt(i);
            Character huan = rings.charAt(i - 1);
            if (map.containsKey(gan)) {
                map.get(gan).add(huan);
            }
            HashSet<Character> set = new HashSet<>();
            set.add(huan);
            map.put(gan,set);
        }
        int ret = 0;
        Set<Map.Entry<Character, HashSet<Character>>> entries = map.entrySet();
        for (Map.Entry<Character, HashSet<Character>> entry : entries) {
            if(entry.getValue().size() >= 3) {
                ret++;
            }
        }
        return ret;


    }

    public static void main(String[] args) {
        String str = "B0B6G0R6R0R6G9";
        Z5952 z5952 = new Z5952();
        int i = z5952.countPoints(str);
        System.out.println(i);

    }
}
