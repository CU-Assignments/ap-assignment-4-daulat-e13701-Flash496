class Solution {
    public int lengthOfLIS(int[] nums, int k) {
         SegmentTree root = new SegmentTree(1, 100000);
        int res = 0;
        for (int num : nums) {
            int preMax = root.rangeMaxQuery(root, num - k, num - 1);
            root.update(root, num, preMax + 1);
            res = Math.max(res, preMax + 1);
        }
        return res;
    }
}
