public class Solution {
    public int firstBadVersion(int n) {
        int start = 0, end = n, minBadVersion = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                minBadVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minBadVersion;
    }

    private boolean isBadVersion(int version) {
        return true; 
    }
}
