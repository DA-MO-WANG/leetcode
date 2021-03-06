package liuyuboo;

import java.util.ArrayList;

public class J17 {
    //第一次尝试独立做2h，失败！


    //第二次照抄
    //n位数字可能会突破任何正数类型的范围--只能用字符串来表示
    public void printToMaxOfNDigits(int n) {
        //所有的数字都只是0-9这10个数表示
        //找到n个位置，模拟这10个数字的变化
        if (n <= 0) {
            throw new IllegalArgumentException("不合法的参数！");
        }
        //所以说我需要一个数组来表示这n个位置--判断模拟终止时，是最高位变成10时，就标志布尔
        char[] number = new char[n];
        //char数组不会自动初始化
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        //关卡1：什么时候超过n位最大数---此时要停止模拟
        //因为要腾出一个最高位置，作为预警---数组是n+1==>第一位置从0变成1时，此时触发了
        //System.out.print(0 + " ");
        while (!increment(number)) {
            printNumbers(number);
        }
    }

    //难点1：常态情况下的模拟
    //难点2：进1状态下的模拟--走多轮循环，
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
            //当进位后，会进行第二轮循环，此时不会对第二个位置上的数字进行更新，后位数字只会依赖前一个数字来变化
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
                //第二轮循环--直接更新进1后的效果
                number[i] = (char) (nSum + '0');
                //只要小于10的情况，这个方法只执行一轮循环--进而方便把当时的状态打印出来
                break;
            }
        }
        return isOverFlow;
    }


    public void printNumbers(char[] number) {
        //当前位置是不是第一个不为0的地方
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            //第一个不是0的地方的前面的0都不用打印，只有后面的打印
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;//第一次不为0时，会被记录这个状态，自此之后，就不会改变
            }
            if (!isBeginning0) {
                System.out.print(number[i] + " ");
            }
        }
        //走完所有循环代表一个数
        System.out.print("\t");
    }



    //第二种方法
    //一个循环代表固定一个位置的数字变化
    //递归代表被固定位置的游走
    void printToMaxOfNDigits01(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char)(i + '0');//把第一个位置上的数字从0到9变化
            printRecursive(number,n,0);
        }


    }
    void printRecursive(char[] number, int length, int index) {
        if (index == length - 1) {//数组中的位置，一直到最后一个位置，都确定了
            printNumbers(number);//此时才开始打印
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)(i + '0');//从第二位开始从0-9变化
            printRecursive(number,length,index + 1);//递归操作下一个位置的变化，通过调节index
        }
    }




    public static void main(String[] args) {
        J17 j = new J17();
        j.printToMaxOfNDigits01(2);
        //System.out.println((char)('1' + 4));
    }
}
