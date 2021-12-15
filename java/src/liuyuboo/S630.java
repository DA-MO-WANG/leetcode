package liuyuboo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class S630 {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Course> queue = new PriorityQueue<>();
        for (int i = 0; i < courses.length; i++) {
            if(courses[i][0] >courses[i][1]) {
                queue.enqueue(new Course(courses[i][0],courses[i][1]));
            }
        }
        
    }
    class Course implements Comparable<Course>{
        int duration;
        int lastday;

        public Course(int d, int last) {
            this.duration = d;
            this.lastday = last;
        }

        @Override
        public int compareTo(Course o) {
            return this.lastday - o.lastday;
        }
    }
}
