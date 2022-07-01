package acwing;

import java.util.Scanner;

/**
 * @Description TO DO
 * @Classname Main4
 * @Date 2022/7/1 14:06
 * @Created by richheart
 * Copyright (c) All Rights Reserved, 2022.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String[] ss = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if(ss[i].equals(s2)) {
                res.append(s3+" ");
            }else {
                res.append(ss[i]+" ");
            }
        }
        System.out.println(res.toString());

    }
}
