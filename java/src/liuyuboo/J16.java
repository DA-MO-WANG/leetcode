package liuyuboo;

public class J16 {
    public double myPow(double x, int n) {
        double x1 = x;
        double ret = 1;
        if(equals(x,1.00)) {
            return x;
        }
        if (n < 0) {
            if (equals(x,0.0)) {
                throw new IllegalArgumentException("argument is illegal!");
            }else {
                int j = 0 - n;
                ret = 1 / cj(x,j);
            }
        }else if (n == 0) {
            if (equals(x,0.0)) {
                throw new IllegalArgumentException("argument is illegal!");
            }
            ret = 1.0;
        }else if (n > 0) {
            ret = cj(x1,n);
        }
        return ret;

    }
    public double cj(double x, int n) {
        double ret = 1.0;
        int j = n;
        //int ret = 0;
        while (j > 0) {
            ret *= x;
            j--;
        }

        return ret;
    }

    //double的相等问题--编码考虑
    public boolean equals(double i, double j) {
        return (i - j) < 0.00000001 && (i - j) > -0.00000001 ? true : false;
    }


    public static void main(String[] args) {
        J16 j16 = new J16();
        double v = j16.myPow(2.0, -2147483648);
        System.out.println(v);

    }
}
