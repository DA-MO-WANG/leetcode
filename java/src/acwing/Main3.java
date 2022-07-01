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
        char[] words = input.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i],1);
            }else {
                map.put(words[i],2);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue() == 1)
        }


    }
}
