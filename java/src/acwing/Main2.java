package acwing;

import java.util.Scanner;

/**
 * @Description TO DO
 * @Classname Main2
 * @Date 2022/6/30 20:00
 * @Created by richheart
 * Copyright (c) All Rights Reserved, 2022.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int input = sc.nextInt();
            if(input == 0) {
                break;
            }
            for (int i = 1; i <= input; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
