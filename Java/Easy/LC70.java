package Java.Easy;

import java.util.*;

public class LC70 {
    /* Recursion: Time complexity O(2^n)
    public int climbStairs(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    } */


    /* Memoization: We use unordered map (memo) to store the already 
    computed results for each step n. Before making a recursive call,
    we check if the result for the given n exists in the memo.
    If it does, we return the stored value; otherwise, we compute
    the result recursively and store it in the memom for future
    reference.
     */
    /*public static int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }
    private static int climbStairs(int n, Map<Integer, Integer> memo) {
        if ( n== 0 || n == 1){
            return 1;
        }
        if (!memo.containsKey(n)){
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
            }
        return memo.get(n);
        } */

    /* Tabulation: The tabulation solution eliminates recursion 
    and uses a bottom-up approach to solve the problem iteratively. 
    It creates a DP table (dp) of size n+1 to store the number of 
    ways to reach each step. The base cases (0 and 1 steps) are 
    initialized to 1 since there is only one way to reach them. 
    Then, it iterates from 2 to n, filling in the DP table by 
    summing up the values for the previous two steps. 
    Finally, it returns the value in the last cell of the DP table, 
    which represents the total number of ways to reach the top.
     */
    
    /*public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    } */

    /* Space Optimization: The space-optimized solution further 
    reduces the space complexity by using only two variables 
    (prev and curr) instead of an entire DP table. 
    It initializes prev and curr to 1 since there is only 
    one way to reach the base cases (0 and 1 steps). 
    Then, in each iteration, it updates prev and curr by 
    shifting their values. curr becomes the sum of the previous 
    two values, and prev stores the previous value of curr.*/

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    } 

    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of stairs: ");
        int Stairs = scanner.nextInt();
        System.out.println("The number of ways to climb the stairs is: " + climbStairs(Stairs));
        scanner.close();
    }
}