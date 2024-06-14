/*26. Remove Duplicates from Sorted Array
Given an integer array nums sorted in 
non-decreasing order, remove the duplicates 
in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same. 
Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get 
accepted, you need to do the following things:

Change the array nums such that the first k elements of nums 
contain the unique elements in the order they were present in nums 
initially. The remaining elements of nums are not important as 
well as the size of nums.
Return k.


Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first 
two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k 
(hence they are underscores).




Approach:

    1. Brute Force :
        Using two for loops to find the indexes of duplicate numbers
        and then using removeElement method to remove the duplicate numbers

    2. Using HashMap :
        Using HashMap / HashSet to iterate through the array and
        store the unique values and if duplicate numbers are incountered
        store the indexes of the duplicate numbers.

    3. Maybe Fast Slow Pointer :
        afslfaskfjsaogrnsfdnrgf
 */


package Java;

public class LC26 {
    public static int[] removeElement(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        
        int[] newArray = new int[array.length - 1];
        
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        
        return newArray;
    }



}
