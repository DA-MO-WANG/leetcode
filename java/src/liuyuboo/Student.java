package liuyuboo;

import java.util.Comparator;

public class Student implements Comparable<Student>{
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }


    @Override
    public int compareTo(Student o) {
        return (this.score > o.score) ? 1 : -1;
    }

    public static void print(Student s1, Student s2, Comparator<Student> c) {
        int compare = c.compare(s1, s2);
        System.out.println(compare);

    }

    public static void main(String[] args) {
        Comparator c =
        Student.print(new Student("124",25),new Student("345",55),c);
    }
}
