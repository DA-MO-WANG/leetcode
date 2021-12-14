package liuyuboo;

public class J29 {
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        String ret = "";
        if((rows & 1) == 1) {
            //row 偶数---》每次走一个完整的四方形，走rows/2
            //row 奇数---》rows /2 个四方形， 加一个单边
            ret = print(matrix,0,rows,0,cols,rows);
        }else {
            ret = print(matrix,0,rows,0,cols,rows);

        }
        char[] chars = ret.toCharArray();
        int[] rets = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            rets[i] = Integer.valueOf(chars[i]);
        }
        return rets;



    }
    public String print(int[][] matrix, int rowbegin, int rows, int colbegin, int cols, int rowlen) {
        if((rowbegin + 1) > (rowlen / 2)) {
            return "";
        }
        boolean flag = true;
        if(rowlen % 2 != 0) {
            flag = (rowbegin == rowlen / 2 ? false : true);
        }

        //row = 0 , col = 0, col - 1
        String ret = "";

            for (int col = colbegin; col < cols - 1; col++) {
                ret += matrix[rowbegin][col];
            }


        //col = col -1; row- 0,row -1
        if(flag) {
            for (int row = rowbegin; row < rows - 1; row++) {
                ret += matrix[row][cols - 1];
            }
            //row = row -1 , col :col - 1, 0
            for (int col = cols - 1; col > colbegin; col--) {
                ret += matrix[rows - 1][col];
            }
            //col = 0.; row = row -1 , 0
            for (int row = rows - 1; row > rowbegin; row--) {
                ret += matrix[row][colbegin];
            }
        }
            return ret + print(matrix,++rowbegin,--rows,++colbegin,--cols,rowlen);

    }

    public static void main(String[] args) {
        int[][] ma = {};
    }
}

