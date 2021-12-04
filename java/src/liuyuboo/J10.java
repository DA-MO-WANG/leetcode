package liuyuboo;

public class J10 {
    public int hammingWeight(int n) {
        int m = 1;
        int count = 0;
        while (n >= m) {
            if ((n & m) == m) {
                count++;
            }
            m = m << 1;
        }
        return count;

    }

    public static void main(String[] args) {
        J10 j10 = new J10();
        int i = j10.hammingWeight(-9);
        System.out.println(i);
    }
}
