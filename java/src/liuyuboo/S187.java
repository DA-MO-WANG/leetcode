package liuyuboo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S187 {
    public List<String> findRepeatedDnaSequences(String s) {

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
}
