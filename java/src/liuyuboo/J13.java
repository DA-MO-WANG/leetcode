package liuyuboo;

public class J13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ret = hasPathCore(m,n,i,j,k,visited) ;
                    count = Math.max(count,ret);

            }
        }
        return count;

    }

    public int hasPathCore(int rows, int cols, int m, int n, int k, boolean[][] visited) {
        boolean flag = false;
        int count = 0;
        if (check(rows,cols,m,n,k,visited)) {
            visited[m][n] = true;
            count = 1 +  hasPathCore(rows,cols,m+1,n,k,visited) +  hasPathCore(rows,cols,m - 1,n,k,visited)
                    + hasPathCore(rows,cols,m,n - 1,k,visited) + hasPathCore(rows,cols,m,n+1,k,visited);
        }
        return count;
    }
    //用来校验机器人能不能走i,j这个格子
    public boolean check(int rows, int cols, int m, int n, int k, boolean[][] visited) {
        if (m >= 0 && m < rows && n >= 0 && n <cols && !visited[m][n] && getSum(m,n) <= k) {
            return true;
        }
        return false;
    }

    public int getSum(int m, int n) {
        int sum = 0;
        while (m != 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        J13 j13 = new J13();
        int sum = j13.movingCount(3,2,17);
        System.out.println(sum);

    }
}
