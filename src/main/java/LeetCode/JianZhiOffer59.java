package LeetCode;


import java.util.LinkedList;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
public class JianZhiOffer59 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        printArray(maxSlidingWindow(nums, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        // 使用一个单调队列
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果上一个窗口最左边的元素等于最大的元素，则将队列中的第一个元素出列
            if (i >= k && nums[i-k] == queue.getFirst()) {
                queue.removeFirst();
            }
            // 当一个元素入队时，删除队列中所有小于该元素的元素
            while(!queue.isEmpty() && queue.getLast() < nums[i]) queue.removeLast();
            queue.addLast(nums[i]);
            if (i >= k - 1)
                res[j++] = queue.getFirst();
        }
        return res;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
