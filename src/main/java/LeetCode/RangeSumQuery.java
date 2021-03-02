package LeetCode;
/*
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
*/
public class RangeSumQuery {
    int[][] pre;
    int row, col;

    public RangeSumQuery(int[][] matrix) {
        row = matrix.length;
        if (row <= 0) return ;
        col = matrix[0].length;
        pre = new int[row+1][col+1];
        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
                pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 >= row || row2 < 0 || row2 > row || col1 < 0 || col1 > col || col2 < 0 || col2 > col) return 0;
        int ans = pre[row2+1][col2+1];
        ans += (pre[row1][col1] - pre[row2+1][col1] - pre[row1][col2+1]);
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix =   {{3, 0, 1, 4, 2},
                            {5, 6, 3, 2, 1},
                            {1, 2, 0, 1, 5},
                            {4, 1, 0, 1, 7},
                            {1, 0, 3, 0, 5}};
        RangeSumQuery solution = new RangeSumQuery(matrix);
        print(solution.pre);
        System.out.println(solution.sumRegion(2,1,4,3));
        System.out.println(solution.sumRegion(1, 1, 2, 2));
        System.out.println(solution.sumRegion(1, 2, 2, 4));
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

