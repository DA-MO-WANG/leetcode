package liuyuboo;

public class J17 {
    public int[] printNumbers(int n) {
        //难点1:大数的问题越界
        int[] wei = new int[n];



        }


        //难点2:打印问题

    }

    public void add(int[] wei,int n,int m) {
        if (m > n) {
            return;
        }
        for (int i = 1; i <= m; ) {
            wei[n - i]++;
            if (wei[n - i] == 10) {
                wei[n - i + 1]++;
                wei[n - i] = 0;
            }
        }
}
