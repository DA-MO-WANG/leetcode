package liuyuboo;

import java.util.Comparator;

public class Student {
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }




    public static void print(Student s1, Student s2, Comparator<Student> c) {
        int compare = c.compare(s1, s2);
        System.out.println(compare);

    }

    public static void main(String[] args) {
        //Comparator c =
        Student.print(new Student("124", 25), new Student("345", 55), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.score > o2.score) ? 1 : -1;
            }
        });
    }
}
