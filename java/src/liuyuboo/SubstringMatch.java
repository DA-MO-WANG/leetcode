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

    public static void main(String[] args) {
        //SubstringMatch sub = new SubstringMatch();
        String s = "hi i am john";
        String t = "john";
        int bruteforce = SubstringMatch.bruteforce(s, t);
        System.out.println(bruteforce);

    }
}
