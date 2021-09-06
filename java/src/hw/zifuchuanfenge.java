package hw;

import java.util.Scanner;

public class zifuchuanfenge {
    public static void main(String[] args) {
        //获取键盘上输入的数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            if (ch.length <= 8) {
                for (char cr : ch) {
                    System.out.print(cr);
                }
            }
        }






        String[] s = new String[100];
        s[0] = in.nextLine();
        s[1] = in.nextLine();
        for (int i = 0; i < 2; i++) {
            if (s[i].length() == 8) {
                System.out.println(s[i]);
            }
            if (s[i].length() < 8) {
                System.out.println(s[i]);
                for (int j = 0; j < 8 - s[i].length(); j++) {
                    System.out.println("0");
                }
                System.out.println();
            }else {
                int n = s[i].length() / 8;
                int m = s[i].length() % 8;
                if (m == 0) {
                    for (int k = 0; k) {
                        System.out.println(s[i].substring(8*k, 8*k + 8));
                    }
                }else {
                    for (int k = 0; k) {
                        System.out.println(s[i].substring(8*k, 8*k + 8));
                    }
                }
            }


        }

        System.out.println();

    }
}
