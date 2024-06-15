/* 4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 
of size m and n respectively, return the median 
of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

*/
package Java.Hard;
public class LC4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) { // Ensure nums1 is the smaller array
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < m && nums1[i] < nums2[j - 1]) {
                imin = i + 1; // i is too small, must increase it
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1; // i is too large, must decrease it
            } else { // i is perfect
                int maxOfLeft;
                if (i == 0) { maxOfLeft = nums2[j - 1]; }
                else if (j == 0) { maxOfLeft = nums1[i - 1]; }
                else { maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]); }
                if ((m + n) % 2 == 1) { return maxOfLeft; }

                int minOfRight;
                if (i == m) { minOfRight = nums2[j]; }
                else if (j == n) { minOfRight = nums1[i]; }
                else { minOfRight = Math.min(nums1[i], nums2[j]); }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0; // If input arrays are not sorted or not valid
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median is: " + findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median is: " + findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }
}
