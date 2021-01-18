package chapter2.algorithm.backtrack;

/**
 *  面试题12. 矩阵中的路径
 *  设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *  路径可以从矩阵的任意一格开始，每一步可以在矩阵中向上下左右移动一格。不能重复进入同一个格子
 *
 */
public class FindPathInMatrix {

    public static void main(String[] args) {
        char[][] mat = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        FindPathInMatrix findPathInMatrix = new FindPathInMatrix();

        System.out.println(findPathInMatrix.hasPath(mat, "bfcd", 3, 4));
    }

    public boolean hasPath(char[][] matrix, String str, int rows, int cols) {
        if (matrix == null || str == null || rows < 1 || cols < 1) return false;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, str, rows, cols, i, j, visited, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[][] matrix, String str, int rows, int cols, int row, int col, boolean[][] visited, int index) {
        if (index == str.length()) return true;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row][col] && matrix[row][col] == str.charAt(index)) {
            index++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, str, rows, cols, row, col+1, visited, index)
                    || hasPathCore(matrix, str, rows, cols, row, col-1, visited, index)
                    || hasPathCore(matrix, str, rows, cols, row-1, col, visited, index)
                    || hasPathCore(matrix, str, rows, cols, row+1, col, visited, index);

            if (!hasPath) {
                visited[row][col] = false;
                index--;
            }
        }
        return hasPath;
    }
}
