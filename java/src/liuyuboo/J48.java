package liuyuboo;

public class J48 {
    public void rotate(int[][] matrix) {
        rotateUp_Down(matrix);
        rotateDJ(matrix);
    }

    public void rotateUp_Down(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows;
        for (int i = 0; i <= rows / 2; i++) {
            for (int j = 0; j < rows; j++) {
                swap(matrix,i,j,rows - 1 - i,j);
            }
        }
    }

    public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void rotateDJ(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col > row; col++) {
                swap(matrix,row,col,col,row);
            }
        }
    }
}
