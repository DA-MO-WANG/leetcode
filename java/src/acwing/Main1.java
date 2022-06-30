package acwing;

import java.util.Scanner;

/**
 * @Description TO DO
 * @Classname Main
 * @Date 2022/6/30 19:50
 * @Created by richheart
 * Copyright (c) All Rights Reserved, 2022.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 6; i ++) {
            //nextDouble() 把读取的值当作double 来处理，如果无法转换，就抛出异常
            //转化double， 并不改变正负性
            if(sc.nextDouble() > 0) {
                count++;
            }
        }

        System.out.printf("%d positive numbers",count);
    }
}
