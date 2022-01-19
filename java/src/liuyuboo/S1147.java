package liuyuboo;

public class S1147 {
    //段式回文
    public int longestDecomposition(String text) {

        //先把逻辑框架搭好，再填充细节
        //递归：处理left-right区间范围内的字符串--字串概念
        return solve(text,0,text.length() - 1);
    }
    //[left,right]
    //返回left-right区间内的最大段数
    private int solve(String s, int left, int right) {
        //递归到底的情况：没有元素了--区间越界
        if (left > right) {
            return 0;
        }
        //从两头开始看，i从左往右走，j从右往左走
        for (int i = left, j = right; i < j; i++, j--) {
            //s[left,i] == s[j,right]，所以设计一个equal逻辑，来看这两部分是否相等
            //如果相等的话，就返回，已经有的2段+往下递归
            if (equal(s,left,i,j,right)) return 2 + solve(s,i + 1, j - 1);

        }
        //循环结束，另一种可能就是没有回文，一段
        return 1;
    }

    //[l1,r1]  == [l2,r2]
    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        //用逐步遍历的方式来判断是否相等
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++,j++) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
