package algs4;

/**
 * 实现Comparable接口的自定义数据类型-定义了可比较性这种性质
 */
public class Date implements Comparable<Date>{

    private final int day;
    private final int month;
    private final int year;
    //command + enter 自动生成构造方法、set\get方法
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int day() { return day;}
    public int month() { return month;}
    public int year() { return year;}

    @Override
    public int compareTo(Date that) {
        if (this.year > that.year) return +1;
        if (this.year < that.year) return -1;
        if (this.month > that.month) return +1;
        if (this.month < that.month) return -1;
        if (this.day > that.day) return +1;
        if (this.day < that.day) return -1;
        return 0;
    }
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
