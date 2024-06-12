/*287. Find the Duplicate Number
*Given an array of integers nums containing n + 1 
*integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, 
return this repeated number.

You must solve the problem without modifying the 
array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
 */

package Java;

public class LC287 {
    public static int findDuplicate(int[] nums){
        int tortoise = nums[0];
        int hare = nums[0];
        while (true){
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            if(tortoise == hare)
            break;
        }
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
            return tortoise;
    }

    public static void main (String [] args){
        int arr[] = {1,3,4,2,2};
        int result = findDuplicate(arr);
        System.out.println("The Duplicate Number is: " + result);
    }
}
