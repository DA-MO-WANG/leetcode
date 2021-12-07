package liuyuboo;

public class J16 {
    public double myPow(double x, int n) {

        if (n < 0) {
            if (equals(x,0.0)) {
                throw new IllegalArgumentException("argument is illegal!");
            }else {
                return 1 / (myPow(x,-n));
            }
        }
        if (n == 0) {
            if (equals(x,0.0)) {
                throw new IllegalArgumentException("argument is illegal!");
            }
            return 1;
        }
        if (n > 0) {
            int ret = 0;
            while (n > 0) {
                ret *= ret;
                n--;
            }
            return ret;
        }
    }

    //double的相等问题--编码考虑
    public boolean equals(double i, double j) {
        return (i - j) < 0.000001 && (i - j) > -000001 ? true : false;
    }

    public static void main(String[] args) {
        J16 j16 = new J16();
        double v = j16.myPow(2.0, -2);
        System.out.println(v);

    }
}
