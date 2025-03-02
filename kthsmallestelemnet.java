import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int h = matrix[n - 1][n - 1];

        while (l < h) {
            int mid = l + (h - l) / 2;
            int count = 0;

            for (int i = 0; i < n; i++) {
                count += upperBound(matrix[i], mid);
            }

            if (count < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return l;
    }

    private int upperBound(int[] row, int target) {
        int left = 0, right = row.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
