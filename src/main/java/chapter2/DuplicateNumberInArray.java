package chapter2;

import java.util.Arrays;

/**
 * 在一个长度为n的数组中，所有数字都在0～n-1范围内。
 * 数组中的某些数字是重复的，但不知道重复数字的个数及重复次数
 * 请找出任意一个重复的数字
 * ··
 */
public class DuplicateNumberInArray {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,3,2,5,3};
        System.out.println(findDuplicateNumber3(array));
    }
    // 1. 先将数组排序，然后扫描
    //  时间：O(nlogn)   空间：O(1)
    public static int findDuplicateNumber1(int[] array) {
        Arrays.sort(array);
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == pre) {
                return pre;
            }
            pre = array[i];
        }
        return -1;
    }
    // 2. 使用一个哈希表,遍历扫描原数组，如果数字不在hash表中，则加入hash表
    //    如果在hash表中，说明之前已经出现过这个数，可以直接返回
    // 时间：O(n)  空间：O(n)
    public static int findDuplicateNumber2(int[] array) {
        int n = array.length;
        int[] map = new int[n];
        for (int value : array) {
            if (map[value] == 0) {
                map[value] = 1;
            } else {
                return value;
            }
        }
        return -1;
    }

    // 3. 考虑到数组数字在0~n-1的范围内，如果数组中没有重复数字的话，
    //    重新排序，那么数字i就应该在下标i处
    // 我们遍历扫描数组，当扫描到下标为 i 的数字时，首先比较 array[i] 是否等于 i
    // 如果相等则继续下一个数字，否则判断 array[i] 是否等于 array[array[i]]，如果相等，则找到一个重复数字
    // 否者 下标为 i 的数字和下标为 array[i] 的数字 交换

    // 时间：O(n)  空间：O(1)
    public static int findDuplicateNumber3(int[] array) {
        for (int i=0; i < array.length; ) {
            if (i == array[i]) {
                i++;
            } else if(array[i] == array[array[i]]) {
                return array[i];
            } else {
                int tmp = array[i];
                array[i] = array[tmp];
                array[tmp] = tmp;
            }
        }
        return -1;
    }
}
