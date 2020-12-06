package chapter2.algorithm.findandsort;

public class QuickSort {

    public void sort(int[] nums) throws Exception {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int start, int end) throws Exception {
        int index = partition(nums, start, end);
        if (start < index)
            quickSort(nums, start, index-1);
        if (end > index)
            quickSort(nums, index+1, end);
    }

    private int partition(int[] nums, int start, int end) throws Exception {
        if (nums == null || nums.length == 0 || end < start || start < 0 || end >= nums.length) {
            throw new Exception("invalid input");
        }
        int choice = nums[start];

        while (start < end) {
            while (nums[end] >= choice && start < end) end--;
            nums[start] = nums[end];
            while (nums[start] <= choice && start < end) start++;
            nums[end] = nums[start];
        }
        nums[start] = choice;
        return start;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {6,4,5,1,2,7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        for (int num : arr){
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
