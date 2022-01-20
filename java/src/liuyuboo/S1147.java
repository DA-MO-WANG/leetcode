package liuyuboo;

public class S1147 {
    //段式回文
    public int longestDecomposition1(String text) {

        //先把逻辑框架搭好，再填充细节
        //递归：处理left-right区间范围内的字符串--字串概念
        return solve(text,0,text.length() - 1);
    }
    //[left,right]
    //返回left-right区间内的最大段数
    private int solve1(String s, int left, int right) {
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
    private boolean equal1(String s, int l1, int r1, int l2, int r2) {
        //用逐步遍历的方式来判断是否相等
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++,j++) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }




    private long MOD = (long)(1e9 + 7);
    //预处理准备一个幂值运算
    private long[] pow26;

    public int longestDecomposition(String text) {
        //字符串哈希函数的公式,所有的幂因子，用一个数组来存储
        pow26 = new long[text.length()];
        pow26[0] = 1;
        for (int i = 1; i < pow26.length; i++) {
            pow26[i] = pow26[i - 1] * 26 % MOD;
        }
        return solve(text, 0, text.length() - 1);
    }

    private int solve(String s, int left, int right) {
        if (left < right) return 0;
        //在第一版的基础上，替换了字符串比较的思路
        //改"逐个遍历字符，为比较字符串的哈希值"
        //===》工作转为如何计算哈希值
        long prehash = 0, posthash = 0;
        for (int i = left, j = right; i < j; i++,j--) {
            //不断的变化的字符串，没必要重新遍历，而是借助上一次的操作，得到相同性质的新的结果--这就是利用哈希的优势
            prehash = (prehash * 26 + (s.charAt(i) - 'a')) % MOD;//从左到右不断增加最低位
            posthash = ((s.charAt(j) - 'a') * pow26[right - j] + posthash) % MOD;//从右到左不断增加最高位
            //这里模仿了哈希表添加元素的逻辑，如果哈希冲突了，再去比较确切元素，加了一层保险，而不同的立刻就能通过哈希来判断出来
            if (prehash == posthash && equal(s,left,i,right,j)) return 2 + solve(s,i + 1, j - 1);
        }
        return 1;
    }

    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++,j++) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

}
