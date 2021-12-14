package liuyuboo;

import java.util.ArrayList;

public class J29 {
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) {
            return new int[]{};
        }
        if(rows == 1) {
            return matrix[0];
        }

        int cols = matrix[0].length;
        int min = Math.min(rows,cols);
        boolean flag1 = (rows == min) ? true : false;//扁的
        boolean flag2 = (min % 2 == 0) ? true : false;//四个都有-true

        if(flag1) {
            bprint(matrix,0,rows,0,cols,flag2);
        }else {
            cprint(matrix,0,rows,0,cols,flag2);
        }
        //row 偶数---》每次走一个完整的四方形，走rows/2
        //row 奇数---》rows /2 个四方形， 加一个单边

        //print(matrix,0,rows,0,cols,flag1,flag2);

        //char[] chars = ret.toCharArray();
        int[] rets = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rets[i] = Integer.valueOf(list.get(i));
        }
        return rets;



    }
    ArrayList<Integer> list = new ArrayList<>();

    public void bprint(int[][] matrix, int rowbegin, int rows, int colbegin, int cols, boolean flag2) {
        //奇数还是偶数
        if (flag2) {
            if (((rowbegin + 1) > (matrix.length / 2))) {
                return;
            }
            for (int col = colbegin; col < cols - 1; col++) {
                list.add(matrix[rowbegin][col]);
            }

            //col = col -1; row- 0,row -1

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
            bprint(matrix, ++rowbegin, --rows, ++colbegin, --cols, flag2);
        }else {
            if ((rowbegin == (matrix.length / 2))) {
                for (int col = colbegin; col < cols; col++) {
                    list.add(matrix[rowbegin][col]);
                }
                return;
            }

            for (int col = colbegin; col < cols - 1; col++) {
                list.add(matrix[rowbegin][col]);
            }

            //col = col -1; row- 0,row -1

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
            bprint(matrix, ++rowbegin, --rows, ++colbegin, --cols,flag2);
        }

    }
    public void cprint(int[][] matrix, int rowbegin, int rows, int colbegin, int cols, boolean flag2) {
        //奇数还是偶数
        if (flag2) {
            if (((colbegin + 1) > (matrix[0].length / 2))) {
                return;
            }
            for (int col = colbegin; col < cols - 1; col++) {
                list.add(matrix[rowbegin][col]);
            }

            //col = col -1; row- 0,row -1

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
            bprint(matrix, ++rowbegin, --rows, ++colbegin, --cols, flag2);
        }else {
            if ((colbegin == (matrix[0].length / 2))) {
                for (int row = rowbegin; row < rows; row++) {
                    list.add(matrix[row][cols - 1]);
                }
                return;
            }

            for (int col = colbegin; col < cols - 1; col++) {
                list.add(matrix[rowbegin][col]);
            }

            //col = col -1; row- 0,row -1

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
            cprint(matrix, ++rowbegin, --rows, ++colbegin, --cols,flag2);
        }
    }
    public static void main(String[] args) {
        int[][] ma = {{7},{8},{9}};
        J29 j = new J29();
        int[] ints = j.spiralOrder(ma);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }

    }
}

