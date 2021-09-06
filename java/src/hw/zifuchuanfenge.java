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
        
    }
}
