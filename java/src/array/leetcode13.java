package array;

import edu.princeton.cs.algs4.StdOut;

public class leetcode13 {
    public int romanToInt(String s) {
        //先考虑没有特殊规则
        double sum = 0;
        char[] letters = s.toCharArray();
        boolean flag = false;
        int n = letters.length;
        for (int i = n - 1; i >= 0; i--) {
            if (((i-1) >= 0) & (letters[i] == 'I' && ((letters[i - 1] == 'V') || (letters[i - 1]) == 'X') {
                flag = true;
            }else if (((i-1) >= 0) & (letters[i] == 'X' && ((letters[i - 1] == 'L') || (letters[i - 1]) == 'C') {
                flag = true;
            }else if (((i-1) >= 0) & letters[i] == 'C' && ((letters[i - 1] == 'D') || (letters[i - 1]) == 'M'){
                flag = true;
            }
            if (flag) {
                int pre = transfer(letters[i]);
                int next = transfer(letters[i - 1]);
                int cur = pre - next;
                sum += cur;
                flag = false;
                i--;
            }else {
                int transfer = transfer(letters[i]);
                sum += transfer;
            }        
        }
        return Integer.parseInt(Double.toString(sum).substring(0,Double.toString(sum).lastIndexOf('.')));

    }

    public int transfer(char a) {
        switch (a) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        throw new IllegalArgumentException("未知字符！");
    }

    public static void main(String[] args) {
        leetcode13 leetcode1 = new leetcode13();
        int iii = leetcode1.romanToInt("MCMXCIV");
        System.out.println(iii);

    }
}
