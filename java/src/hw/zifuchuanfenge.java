package hw;

import java.util.Scanner;

public class zifuchuanfenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
                    for (int k = 0; )
                }
            }


        }

        System.out.println();

    }
}
