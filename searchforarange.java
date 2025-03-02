class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1, -1};

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
