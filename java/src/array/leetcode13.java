package array;

public class leetcode13 {
    public int romanToInt(String s) {
        //先考虑没有特殊规则
        double sum = 0;
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int transfer = transfer(letters[i]);
            sum += transfer * (Math.pow(10,letters.length - i));
        }
        
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
}
