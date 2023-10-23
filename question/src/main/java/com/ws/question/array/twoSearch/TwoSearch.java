package com.ws.question.array.twoSearch;
public class TwoSearch {
    static int twoSearch(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //while要加等号的原因
        //当左右边界重合的时候，还需要判断下，当前边界是否跟target是一样的才行
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) right = mid - 1;
            if (target > nums[mid]) left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target=9;
        System.out.println(twoSearch(nums, target));
    }
}
