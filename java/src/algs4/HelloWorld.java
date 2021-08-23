package algs4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class HelloWorld {
    public static void main(String[] args) {
        int n = 3;
        Double a[] = new Double[n];
        //Integer a[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }
        Quick.sort(a);
        Example.show(a);

    }
}
