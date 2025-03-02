import java.util.*;

class Solution {
    public int upperBound(int[] nums, int number) {
        int s = 0, e = nums.length - 1, ans = nums.length;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > number) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public int calc(int[] nums1, int[] nums2, int number) {
        int ans = 0;
        if (nums1.length > 0) ans += upperBound(nums1, number);
        if (nums2.length > 0) ans += upperBound(nums2, number);
        return ans;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        int low2 = Integer.MAX_VALUE, high2 = Integer.MIN_VALUE;

        if (nums1.length > 0) {
            low = Arrays.stream(nums1).min().getAsInt();
            high = Arrays.stream(nums1).max().getAsInt();
        }

        if (nums2.length > 0) {
            low2 = Arrays.stream(nums2).min().getAsInt();
            high2 = Arrays.stream(nums2).max().getAsInt();
        }

        low = Math.min(low, low2);
        high = Math.max(high, high2);
        low2 = low;
        high2 = high;

        int req = (nums1.length + nums2.length) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallerElements = calc(nums1, nums2, mid);

            if (smallerElements <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return low;
        }

        int first = low;

        while (low2 <= high2) {
            int mid = low2 + (high2 - low2) / 2;
            int smallerElements = calc(nums1, nums2, mid);

            if (smallerElements < req) {
                low2 = mid + 1;
            } else {
                high2 = mid - 1;
            }
        }

        int second = low2;
        return (first + second) / 2.0;
    }
}
