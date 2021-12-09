package liuyuboo;

import java.util.ArrayList;

public class J17 {
    //第一次尝试独立做2h，失败！
    public int[] printNumbers(int n) {
        ArrayList<String> list = printNumber(n);
        int[] ret = new int[list.size()];
        int i = 0;
        for (String num : list) {
            ret[i++] = Integer.valueOf(num);
        }
        return ret;

    }

    //第二次照抄
    //n位数字可能会突破任何正数类型的范围--只能用字符串来表示
    public void printToMaxOfNDigits(int n) {


        //ArrayList<ArrayList> lists = new ArrayList<>();
        //难点1:大数的问题越界
        String str = "";
        //ArrayList<String> list = null;
        ArrayList<String> list2 = null;
        if (n <= 0) {
            throw new IllegalArgumentException("不合法的参数！");
        }
        char[] number = new char[n];
        while (!increment(number)) {
            str = printNumbers(number);
            list2.add(str);
            //lists.add(list);
        }


    }

    public boolean increment(char[] number) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) (nSum + '0');
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverFlow;
    }


    public String printNumbers(char[] number) {
        //ArrayList<String> list = new ArrayList();
        String ret = "";
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                ret += number[i] + "";
            }
        }
        return ret;
    }

    //难点2:打印问题

    public void add(int[] wei, int n, int m) {
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

    public static void main(String[] args) {
        int m= (int)Math.pow(2,77);
        System.out.println(m);
    }
}
