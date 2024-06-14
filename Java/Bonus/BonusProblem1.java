/*
 * A boomerang is a V-shaped sequence that is either upright
 * or upside down. Specifically, a 
 * boomerang can be defined as: sub-array of length 3, 
 * with the first and last digits being the same and the 
 * middle digit being different.

Some boomerang examples:

1
[3, 7, 3], [1, -1, 1], [5, 6, 5]
Create a function that returns the total number of 
boomerangs in an array.

To illustrate:


[3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2]
// 3 boomerangs in this sequence:  [3, 7, 3], [1, 5, 1], [2, -2, 2]
Be aware that boomerangs can overlap, like so:


[1, 7, 1, 7, 1, 7, 1]
// 5 boomerangs (from left to right): [1, 7, 1], [7, 1, 7], 
[1, 7, 1], [7, 1, 7], and [1, 7, 1]

 */
package Java.Bonus;

public class BonusProblem1 {
    public static int NumBoom(int arr[]){
        int count = 0;

        for (int i = 0; i + 2 < arr.length; i++){
            if (arr[i] == arr[i + 2] && arr[i] != arr[i + 1]){
                count++;
            } 
        }
        return count;
    }

    public static void main(String[] args){
        int[] myArray = {1,7,1,7,1,7,1};
        int result = BonusProblem1.NumBoom(myArray);
        System.out.println(result); 
    }
}

