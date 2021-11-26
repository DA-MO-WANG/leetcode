package liuyuboo;

public class J13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 0;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                if (hasPathCore(m,n,i,j,k,sum,visited)) {
                    count = Math.max(count,sum);
                }
            }
        }
        return count;

    }

    public boolean hasPathCore(int rows, int cols, int m, int n, int k, int count, boolean[][] visited) {
        boolean flag = false;
        if (m >= 0 && m < rows && n >= 0 && n <cols && !visited[m][n] && getSum(m,n) <= k) {
            count++;
            visited[m][n] = true;
            flag = hasPathCore(rows,cols,m+1,n,k,count,visited) || hasPathCore(rows,cols,m - 1,n,k,count,visited)
                    ||hasPathCore(rows,cols,m,n - 1,k,count,visited) ||hasPathCore(rows,cols,m,n+1,k,count,visited);
            if (!flag) {
                --count;
                visited[m][n] = false;
            }
        }
        return flag;
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
}
