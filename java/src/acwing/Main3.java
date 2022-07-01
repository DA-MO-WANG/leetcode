package acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description TO DO
 * @Classname Main3
 * @Date 2022/7/1 10:28
 * @Created by richheart
 * Copyright (c) All Rights Reserved, 2022.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] letters = input.toCharArray();
        int[] cnt = new int[100];
        for (int i = 0; i < letters.length; i++) {
            cnt[letters[i] - 'a']++;
        }
        boolean flag = false;
        for (int i = 0; i < letters.length; i++) {
            if(cnt[letters[i]-'a'] == 1) {
                flag = true;
                System.out.println(letters[i]);
                break;
            }
        }
        if(!flag) System.out.println("no");



    }
}
