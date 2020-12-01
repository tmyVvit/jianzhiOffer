package chapter2;

/**
 * 在长度为 n+1 的数组中，所有数字在 1 ～ n 的范围内，所以数组中至少有一个数字时重复的
 * 在不修改输入数组的基础上，找出任意一个重复的数字
 *
 */
public class FindDuplicateWithoutModifyArray {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,5,4,3,2,6,7};
        System.out.println(findDuplicate2(array));
    }

    // 1. 新建一个数组 时间空间均 O(n)
    public static int findDuplicate1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int[] copy = new int[array.length];
        for (int val : array) {
            if (copy[val-1] == 0) {
                copy[val-1] = val;
            } else {
                return val;
            }
        }
        return -1;
    }

    // 2. 利用二分法思想，用m将1～n分为 1～m  m+1～n，如果1～m的数组数量大于m 则其中一定包含重复数字，否则 m+1～n一定包含重复数字
    //    下面继续划分
    // 时间O(nlogn)   空间O(1)
    public static int findDuplicate2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 1, end = array.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            int count = 0;
            for (int value : array) {
                if (value >= start && value <= mid) {
                    count++;
                }
            }
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    return -1;
                }
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
