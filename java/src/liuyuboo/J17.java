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
        //所有的数字都只是0-9这10个数表示
        //找到n个位置，模拟这10个数字的变化
        if (n <= 0) {
            throw new IllegalArgumentException("不合法的参数！");
        }
        //所以说我需要一个数组来表示这n个位置
        char[] number = new char[n + 1];
        //关卡1：什么时候超过n位最大数---此时要停止模拟
        //因为要腾出一个最高位置，作为预警---数组是n+1==>第一位置从0变成1时，此时触发了
        while (!increment(number)) {
            printNumbers(number);

        }
    }

    public boolean increment(char[] number) {
        //设计一个标识位来标志溢出标志--因为只有两种状态--布尔型
        boolean isOverFlow = false;
        //设计一个进位值
        int nTakeOver = 0;
        int nLength = number.length;
        //从个位开始，模拟
        for (int i = nLength - 1; i >= 0; i--) {
            //把字符串翻译成数字--这个值每轮循环都在变化
            int nSum = (number[i] - '0') + nTakeOver;
            //个位位置时
            if (i == nLength - 1) {
                nSum++;
            }
            //单-位进1位置
            if (nSum >= 10) {
                //模拟到了第n + 1位，只有n位都满了，才会操作到这个位置
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    //溢出了之后，开始往下走（前面加，后面调）：11-》1；12-》2
                    nSum -= 10;
                    nTakeOver = 1;//进位值
                    //更新i位置上的变化
                    number[i] = (char) (nSum + '0');
                }
            } else {
                //单-位没有大于10---正常更新位置
                number[i] = (char) (nSum + '0');
                //只要小于10的情况，就会
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
