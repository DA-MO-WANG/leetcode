package liuyuboo;

public class J13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 0;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] arr = new int[1];
                arr[0] = 0;
                if (hasPathCore(m,n,i,j,k,arr,visited)) {
                    count = Math.max(count,arr[0]);
                }
            }
        }
        return count;

    }

    public boolean hasPathCore(int rows, int cols, int m, int n, int k, int[] arr, boolean[][] visited) {
        boolean flag = false;
        if (m >= 0 && m < rows && n >= 0 && n <cols && !visited[m][n] && getSum(m,n) <= k) {
            arr[0] = arr[0] + 1;
            visited[m][n] = true;
            flag = hasPathCore(rows,cols,m+1,n,k,arr,visited) || hasPathCore(rows,cols,m - 1,n,k,arr,visited)
                    ||hasPathCore(rows,cols,m,n - 1,k,arr,visited) ||hasPathCore(rows,cols,m,n+1,k,arr,visited);
            if (!flag) {
                arr[0] = arr[0] - 1;
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

    public static void main(String[] args) {
        J13 j13 = new J13();
        int sum = j13.movingCount(3,2,17);
        System.out.println(sum);

    }
}
