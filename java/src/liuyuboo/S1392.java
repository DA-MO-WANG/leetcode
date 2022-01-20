package liuyuboo;

public class S1392 {

    //暴力解法思路：
    //逐步拿出备胎前缀，去找对应的备胎后缀（此时先不判断是否相等）---》备胎前缀从全部到只有1长度
    //然后进入判断字符串是否相等的逻辑---》代优化的地方

    public String longestPrefix1(String s) {
        //这个字符串的左端点是确定的，右端点是浮动的，不断挑选的
        for (int len = s.length(); len >= 1; len--) {
            if (equal(s,0,len - 1,s.length() - len, s.length() - 1)) {
                return s.substring(0,len);
            }
        }
        return "";
    }

    private boolean equal1(String s, int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    long MOD = (long)(1e9 + 7);
    //哈希优化版本
    public String longestPrefix(String s) {
        //准备一个预处理的数组
        long[] pow26 = new long[s.length()];
        pow26[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            pow26[i] = pow26[i - 1] * 26;
        }

        int prehash = 0, posthash = 0;

        for (int len = s.length(); len >= 1; len--) {
            //前缀哈希，是逐步缩短最后一位
            prehash = prehash - 

            if (equal(s,0,len - 1,s.length() - len, s.length() - 1)) {



                return s.substring(0,len);
            }
        }
        return "";
    }

    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
