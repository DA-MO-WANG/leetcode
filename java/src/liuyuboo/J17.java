package liuyuboo;

public class J17 {
    public int[] printNumbers(int n) {
        //难点1:大数的问题越界
        int[] wei = new int[n];

        for (int i = wei.length - 1; i < wei.length;) {
            wei[i] = wei[i] + 1;
            if(wei[i] == 10) {
                wei[i + 1] = wei[i + 1] + 1;
                wei[i] = 0;
                i = i + 1;
            }else if (wei[i + 1]){

            }
        }


        //难点2:打印问题

    }
}
