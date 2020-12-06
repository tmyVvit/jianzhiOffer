package chapter2.struct.array;

/**
 * 在一个二维数组中，每一行从左到右递增，每一列从上到下递增
 * 输入一个二维数组和一个整数，判断数组中是否包含该数
 *
 */
public class FindInTwoDimensionArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {  {1,2, 8,9},
                                        {2,4, 9,12},
                                        {4,7,10,13},
                                        {6,8,14,15}};
        System.out.println(find2(matrix, 14));
    }

    public static boolean find(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0][0] > target || array[array.length-1][array[0].length-1] < target) {
            return false;
        }
        int start = 0, end = array.length - 1;
        int y;
        // 首先二分查找 把所有数字都大于target的列剔除
        while (start < end) {
            int mid = (start + end + 1) >>1;
            if (array[0][mid] == target) {
                return true;
            } else if (array[0][mid] < target) {
                start = mid;
            } else {
                end = mid-1;
            }
        }
        // 此时 target 可能在 第 0，1，...，y 列中
        y = start;
        start = 0;
        end = array[0].length-1;
        // 继续使用二分法来判断所在行
        while (start <= end && y >= 0) {
            int mid = (end + start+1) >> 1;
            if (array[mid][y] == target) {
                System.out.printf("x: %d, y: %d\n", mid, y);
                return true;
            } else if (array[mid][y] < target) {
                // 此时当前行都小于target，所以直接找下一行
                start = mid + 1;
            } else {
                // 此时 y 列的剩余值都大于target，所以y--
                y--;
            }
        }
        return false;
    }

    // 和上面方法思想类似，我们从右上角开始比较
    // 如果右上角的值等于target则找到
    // 如果右上角的值大于target，则最右一列剩下的值都大于target，可以去掉这一列 col--
    // 如果右上角的值小于target，则这一行剩下的值都小于target，去掉这一行 rowu
    public static boolean find2(int[][] array, int target) {
        boolean found = false;
        if (array == null || array.length == 0 || array[0][0] > target || array[array.length-1][array[0].length-1] < target) {
            return false;
        }
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                found = true;
                break;
            } else if (array[row][col] > target) {
                col--;
            }else row++;
        }
        return found;
    }
}
