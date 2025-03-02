import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;
        
        int j = 0, k = (n / 2) + (n % 2);
        
        for (int i = n - 1; i >= 0; i--) {
            nums[i] = (i % 2 == 0) ? sorted[j++] : sorted[k++];
        }
    }
}
