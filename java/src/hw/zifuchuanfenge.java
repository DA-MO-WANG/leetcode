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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = new String[100];
        s[0] = in.nextLine();
        s[1] = in.nextLine();
        for(int i=0;i<2;i++) {
            if(s[i].length()==8) {
                System.out.println(s[i]);
            }
            if(s[i].length()<8) {
                System.out.print(s[i]);
                for(int j=0;j<8-s[i].length();j++) {
                    System.out.print("0");
                }
                System.out.println();
            }
            else {
                int n = s[i].length()/8;
                int m = s[i].length()%8;
                if(m==0) {
                    for(int k=0;k<n;k++) {
                        System.out.println(s[i].substring(8*k, 8*k+8));
                    }
                }
                else {
                    for(int k=0;k<n;k++) {
                        System.out.println(s[i].substring(8*k, 8*k+8));
                    }
                    for(int x=8*n;x<s[i].length();x++) {
                        System.out.print(String.valueOf(s[i].charAt(x)));
                    }
                    for(int y=0;y<8+8*n-s[i].length();y++) {
                        System.out.print("0");
                    }
                }
            }
            if(i==0) {
                System.out.println();
            }
        }
    }
}
