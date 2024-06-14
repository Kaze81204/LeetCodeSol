/* 75. Sort Colors
Given an array nums with n objects colored 
red, white, or blue, sort them in-place so that 
objects of the same color are adjacent, with the colors 
in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the 
color red, white, and blue, respectively.

You must solve this problem without using the 
library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]



Approaches:
1. Brute Force - Any sorting Algorithm like bubble, insertion etc
    Time complexity - O(n*n)
    Space complexity - O(1)
2. HashMap or Count Sort - by Counting the frequency of (0,1,2)
    Time complexity - O(n)
    Space complexity - O(1)
    This Approach is used in the first code below
3. Dutch National Flag Algorithm (Best Approach)
    Array is divided in 4 parts using 3 pointers
    Parts: 
        1. From start(0) to low pointer -> Zeroes
        2. From low to mid pointer -> Ones
        3. From mid to high pointer -> Unknown
        4. From high to end -> Twos
    At the very start, whole array will be in Unknown region
    and with every step, we will be decreasing the unknown region to place
    elements in other 3 regions. And when the unknown region will be empty
    we can say that the array is sorted.


    Check value of arr[mid] -
        if 0, swap arr[low] and arr[mid], low++, mid++
        if 1, mid++
        if 2, swap arr[mid] and arr[high], high--

    for ex, - {1,1,2,0,0,1,2,2,1,0}
    Time complexity = O(n)
    Space complexity = O(1)
 */



package Java.Medium;

import java.util.Arrays;

public class LC75 {
    public static void sortArray(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp;


        while( mid <= high){
            if( nums[mid] == 0){
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if( nums[mid] == 1){
                mid++;
            }
            else if( nums[mid] == 2){
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args){
        int arr[] = {1,1,2,0,0,1,2,2,1,0};
        sortArray(arr);
        System.out.println("The sorted array is: " + Arrays.toString(arr));
    }
}
