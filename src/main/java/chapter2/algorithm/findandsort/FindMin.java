package chapter2.algorithm.findandsort;

// 查找旋转数组的最小数字
// 把一个数组的最开始的若干个元素搬到数组的末尾，我们称为数组的旋转
// 现在我们给一个递增数组的旋转，输出数组的最小数值
public class FindMin {
    // 数组 nums 是一个递增数组的旋转
    // 例如[5,6,7,1,2]
    public static int findmin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length-1;
        while (nums[start] >= nums[end]) {
            if (start == end - 1) {
                break;
            }
            int mid = (start + end) / 2;
            // 当 三个数字相等时，无法判断中间数字时位于前面的子数组还是后面的子数组，只能顺序查找
            // {1,1,0,1,1,1,1}  {1,1,1,1,0,1,1}
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                return findMinOrder(nums, start, end);
            }
            if (nums[mid] >= nums[start]) {
                start = mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }
        return nums[end];
    }

    public static int findMinOrder(int[] nums, int start, int end) {
        int ans = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (ans > nums[i]) ans = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr  = {1,0,1,1,1,1};
        int[] arr2 = {1,1,1,0,1,1};
        System.out.println(findmin(arr));
    }
}
