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




The solution is based on the Floyd's Tortoise and Hare Algorithm
It is typically used to detect loop in Linked List but it can be used
here.
In this, two pointers, tortoise and hare iterate through the array, 
but they doesnt iterate linearly, pointer starts from index 0 to the 
index that the value indicates, for ex. arr{1,3,2,3}, if a pointer 
starts from index 0 i.e. indicating value 1 but then pointer goes 
to index 1 which is 3, then pointer goes to index 3, and it iterates
likewise.

Per loop, tortoise iterates once, and hare iterates twice
When both tortoise and hare reach same position close the loop, and keep hare at the end 
position but reset tortoise to 0. And start iterating tortoise till it reaches 
hare while hare iterates once. When tortoise and hare again reach the same position
the value that it points to is the number that is duplicate in the array.

The Time Complexity is O(n)
The Space Complexity is O(1)

Which is much better than brute force solution.

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
