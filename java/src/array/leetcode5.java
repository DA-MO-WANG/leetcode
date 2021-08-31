package array;

public class leetcode5 {
    //思路1：动态规划-灵活路线——》失败！没看懂
    //业务理解：学会问题分解
        //把问题分解成如何拿到子串---》拿到两个区间端点
        //如何判断回文---》分而治之：回文去掉两头还是回文
        //如何获得最大长度的字串----》区间端点可以表示


    //思路2：中心扩散
    //第二个问题：除了从外向内解决，也可以从内向外解决——状态转移方程的观察角度
    //从回文中心，向外扩展，直到扩展到不能扩展——》每一个确定的回文中心对应一个最大回文长度'/
    //回文中心有两种类型：奇数的单个、偶数的双个--如何拿到回文中心：遍历下标
    //2：利用扩展的边界一对值
    //3：最大长度，利用math函数夹在算法里面


    public String longestPalindromez(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        //先拿到回文中心
        for(int i = 0; i < n; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int expand(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
//    int res = 0;
//        int[] two = new int[2];
//        public void valid(boolean[][] dp, String s, int i, int j) {
//            if (i == j) {
//                dp[i][j] = true;
//                //return true;
//            }else if(i == j - 1) {
//                dp[i][j] = (s.charAt(i) == s.charAt(j));
//                //return dp[i][j];
//            }else if(i > j){
//                return;
//            }
//        dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
//        if (dp[i][j]) {
//            if (res != Math.max(res,j - i + 1)) {
//                two[0] = i;
//                two[1] = j;
//            }
//        }
//        //res = dp[i][j] ? Math.max(res,j - i + 1);str = i + j + "": res;
//        //return dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
//    }

    public static void main(String[] args) {
        String str = "cbbd";
        leetcode5 lee5 = new leetcode5();

        System.out.println(lee5.longestPalindromez(str));
    }
}
