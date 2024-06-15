package Java.Easy;


/* Two Sum
Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

You can return the answer in any order.
 
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Solved using HashMap:
    Using HashMap to save each element if its complement is not
    present in the HashMap. 
    Time Complexity: O(n)
    Space Complexity: O(n)
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 public class LC1 {
    public int[] twoSum(int [] nums, int target ){
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                return new int[] {numMap.get(complement), i};
            }
            numMap.put(nums[i],i);
        }
        return new int[]{};
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        for( int i = 0; i < size; i++){
            System.out.println("Enter the element: ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the target: ");
        int target = scanner.nextInt();
        scanner.close();

        LC1 solution = new LC1();

        int[] result = solution.twoSum(arr, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        

    }
 }
}