package liuyuboo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class S187 {
    public List<String> findRepeatedDnaSequences1(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i + 10 < s.length(); i++) {
            String key = s.substring(i,i + 10);
            if (seen.contains(key)) {
                res.add(key);
            }else {
                seen.add(key);
            }
        }
        return new ArrayList<>(res);

    }

    //哈希版
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        long[] map = new long[256];
        map['A'] = 1;
        map['C'] = 2;
        map['G'] = 3;
        map['T'] = 4;
        long hash = 0;
        long ten9 = (long)1e9;
        //hash初始值
        for(int i = 0; i < 9; i++) {
            hash = hash * 10 + map[s.charAt(i)];
        }
        HashSet<Long> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 9; i < s.length(); i++) {
            //hash前进一位
            hash = hash * 10 + map[s.charAt(i)];
            //String key = s.substring(i,i + 10);
            if (seen.contains(hash)) {
                res.add(s.substring(i - 9,i + 1));
            }else {
                seen.add(hash);
            }
            //hash剔除一位
            hash = hash - map[s.charAt(i - 9)] * ten9;
        }
        Arrays.sort();
        return new ArrayList<>(res);
    }
}
