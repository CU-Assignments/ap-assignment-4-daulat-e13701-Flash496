class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0, e = nums.length - 1;

        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
