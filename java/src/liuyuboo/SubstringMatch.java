package liuyuboo;

public class SubstringMatch {
    //输入字符串s，子字符串t，返回子字符串t在字符串s中的起始索引
    public static int bruteforce(String s, String t) {
        //设计出两个指针i j
        //i用来遍历s中的每个字符
        //j用来遍历子字符串中每个字符

        //[i,i+t.length() - 1]  与 t 比较
        for (int i = 0; i + t.length() - 1 < s.length(); i++) {
            int j = 0;
            for(; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if(j == t.length()) {
                return i;
            }
        }
        return -1;
    }
//算法简述
    /**
     * 暴力解法：
          i指向字符串s的起始位置，j指向t的起始位置，开始本轮i的字符对齐操作；
          如果发现无法对齐，提前结束break
          如果j走到t字符串的末尾，说明对齐成功，也就是在对齐循环的外面判断下，然后返回本轮i
          以此类推

     */
    public static void main(String[] args) {
        //SubstringMatch sub = new SubstringMatch();
        String s = "hi i am john";
        String t = "john";
        int bruteforce = SubstringMatch.bruteforce(s, t);
        System.out.println(bruteforce);

    }
}
