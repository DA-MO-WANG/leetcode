package liuyuboo;

import java.util.ArrayList;

public class J29 {
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //String ret = "";
        if((rows & 1) == 1) {
            //row 偶数---》每次走一个完整的四方形，走rows/2
            //row 奇数---》rows /2 个四方形， 加一个单边
            print(matrix,0,rows,0,cols,rows);
        }else {
            print(matrix,0,rows,0,cols,rows);

        }
        //char[] chars = ret.toCharArray();
        int[] rets = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rets[i] = Integer.valueOf(list.get(i));
        }
        return rets;



    }
    ArrayList<Integer> list = new ArrayList<>();
    public void print(int[][] matrix, int rowbegin, int rows, int colbegin, int cols, int rowlen) {
        boolean flag = true;
        if(rowlen % 2 != 0) {
            flag = (rowbegin == rowlen / 2 ? false : true);
        }
        if(flag && ((rowbegin + 1) > (rowlen / 2))) {
            return;
        }
        if (!flag && ((rowbegin) > (rowlen / 2))) {
            return;
        }


        //row = 0 , col = 0, col - 1
        //String ret = "";
            if (!flag) cols = cols + 1;
            for (int col = colbegin; col < cols - 1; col++) {
                list.add(matrix[rowbegin][col]);
            }


        //col = col -1; row- 0,row -1
        if(flag) {
            for (int row = rowbegin; row < rows - 1; row++) {
                list.add(matrix[row][cols - 1]);
            }
            //row = row -1 , col :col - 1, 0
            for (int col = cols - 1; col > colbegin; col--) {
                list.add(matrix[rows - 1][col]);
            }
            //col = 0.; row = row -1 , 0
            for (int row = rows - 1; row > rowbegin; row--) {
                list.add(matrix[row][colbegin]);
            }
        }
            print(matrix,++rowbegin,--rows,++colbegin,--cols,rowlen);

    }

    public static void main(String[] args) {
        int[][] ma = {{1,2,3},{4,5,6},{7,8,9}};
        J29 j = new J29();
        int[] ints = j.spiralOrder(ma);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }

    }
}

