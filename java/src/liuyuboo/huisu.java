package liuyuboo;

public class huisu {
    boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
        //边界情况1：二维数组为空，字符串为空
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //标识矩阵==》路径不能重复进入相同格子：走过一遍就会做个标记
        boolean[][] visited = new boolean[rows][cols];
        //路径长度，记录字符数组的索引
        int pathLength = 0;
        //遍历二维矩阵
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                //是否有路径的核心方法
                if (hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)) {
                    return true;
                }
            }
        }
        visited = null;
        return false;
    }
    //由第一个与字符数组元素首位相同的元素位置开始，利用递归+回溯走这个位置上的各种可能，如果失败了说明第一个位置不合适，走下一个位置，只要一个位置的推演走到字符数组最后，说明就是找到了
    //实际利用递归还是把所有可能都枚举了一下

    //难点：递归认识的还是不够深
    boolean hasPathCore(char[][] matrix, int rows,int cols,int row,int col,char[] str,int pathLength, boolean[][] visited) {
        //递归基：要查的字符已经到字符数组末尾了
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col]== str[pathLength] && !visited[row][col]) {
            ++pathLength;//当前遍历到的二维矩阵中的元素与字符中相同，而且以前没走过==》按找到了算，可以往下走了
            visited[row][col] = true;//找到了就标记一下
            //对待下一个要查找的字符，去这个范围：当前找到的元素四周上下左右找一下
            hasPath = hasPathCore(matrix,rows,cols,row,col - 1,str,pathLength,visited)//左边
                    || hasPathCore(matrix,rows,cols,row - 1,col,str,pathLength,visited)//上边
                    || hasPathCore(matrix,rows,cols,row,col + 1,str,pathLength,visited)//右边
                    || hasPathCore(matrix,rows,cols,row + 1,col,str,pathLength,visited);//下边
            //反面答案--四个都往下的递归都传回false的信号，说明这个总司令有问题了，有了结果可以返回了
            if (!hasPath) {//四周都没有
                --pathLength;//当前元素四周都没有，去找另一种可能，回到n-1重新定位n
                visited[row][col] = false;//退回了就恢复处女地标识1
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        huisu h = new huisu();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String words = "ABCCED";
        char[] word = words.toCharArray();
        boolean ret = h.hasPath(board, 3, 4, word);
        System.out.println(ret);


    }
}
