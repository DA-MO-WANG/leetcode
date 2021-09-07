package hw;

import java.util.Scanner;

public class zifuchuanfenge {
    public static void main1(String[] args) {
        //获取键盘上输入的数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            if (ch.length <= 8) {
                for (char cr : ch) {
                    System.out.print(cr);
                }
                for(int i = 1; i <= 8 - ch.length; i++) {
                    System.out.print('0');
                }
                System.out.println();
            }else {
                for (int i = 0; i < ch.length; i++) {
                    System.out.print(ch[i]);
                    if ((i + 1) % 8 == 0) {
                        System.out.println();
                    }
                }
                if (ch.length % 8 != 0) {
                    for (int i = 1; i <= 8 - ch.length % 8; i++) {
                        System.out.print('0');
                    }
                    System.out.println();
                }
            }
        }






    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = new String[100];
        //读取字符，遇到回车键截止
        s[0] = in.nextLine();
        s[1] = in.nextLine();//输入两次，所以读取两次

        //同时处理两个输入
        for(int i=0;i<2;i++) {//用s[i]来处理
            //如果恰好一个字符串的长度是8，不用特殊处理
            if (s[i].length() == 8) {
                System.out.println(s[i]);
            }
            //特殊：什么样的字符串好处理——》恰好等于8，或者小于8
            if (s[i].length() < 8) {
                System.out.print(s[i]);
                //8 - s.length 的方式处理了补0
                for (int j = 0; j < 8 - s[i].length(); j++) {
                    System.out.print("0");
                }
                System.out.println();
            } else {//长度大于8----想这个问题，关键在把握字符串的长度
                int n = s[i].length() / 8;//有几个
                int m = s[i].length() % 8;//最后剩几个
                if (m == 0) {//恰好被8分割--按递推式来截取
                    for (int k = 0; k < n; k++) {
                        System.out.println(s[i].substring(8 * k, 8 * k + 8));
                    }
                } else {
                    //如果有剩余，先把整齐划分的那部分整完
                    for (int k = 0; k < n; k++) {
                        System.out.println(s[i].substring(8 * k, 8 * k + 8));
                    }
                    //从最后一轮开始，遍历多余的部分
                    for (int x = 8 * n; x < s[i].length(); x++) {
                        System.out.print(String.valueOf(s[i].charAt(x)));
                    }
                    //补0
                    for (int y = 0; y < 8 + 8 * n - s[i].length(); y++) {
                        System.out.print("0");
                    }
                }
            }
            if (i == 0) {//一次输入中间的间隔
                System.out.println();
            }


        }
    }
    //独立练习
    public static void main(String[] args) {
        //输入：两次随机长度字符串
        //输出：每次都能做到按8分割，不足补0

        //先从键盘上存储字符串
        Scanner sc = new Scanner(System.in);
        String[] str = new String[100];
        str[0] = sc.nextLine();
        str[1] = sc.nextLine();

        for (int i = 0; i < 2; i++) {
            if (str[i].length() == 8) {
                System.out.println(str[i]);
            }
            if (str[i].length() < 8) {
                System.out.print(str[i]);
                for (int j = 0; j < 8 - str[i].length(); j++) {

                }
            }
        }

    }

}
