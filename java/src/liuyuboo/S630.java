package liuyuboo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class S630 {
    public int scheduleCourse(int[][] courses) {
        int rows = courses.length;
        int cols = courses[0].length;
        boolean[] hg = new boolean[rows];

        ArrayList<HashMap> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            if (courses[i][0] > courses[i][1]) {
                hg[i] = true;
            }else {
                HashMap<Integer,Integer> map = new HashMap();
                map.put(courses[i][1],courses[i][0]);
                list.add(map);
            }
        }





return 1;
    }
}
