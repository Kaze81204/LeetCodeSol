/* Palindrome Number
 * Given an integer x, return true if x is a 
palindrome
, and false otherwise.
 for ex. 121 is a palindrome number but 123 is not
 */

import java.util.Scanner;

public class LC9 {
    public boolean isPalinddrome(int x){
        if( x < 0) {
            return false;
        }
        
        int div = 1;
        while( x / div >= 10){
            div *= 10;
        }
        while ( x != 0){
            int right = x % 10;
            int left = x / div;

            if (right != left){ return false;}
            
            x = (x % div) / 10;
            div = div / 100;
        }   
        return true;
    }

    public static void main(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be checked: ");
        int num = scanner.nextInt();
        LC9 lc9 = new LC9();
        boolean result = lc9.isPalinddrome(num);

        if (result){
            System.out.println(num + " is a palindrome ");
        }
        else{
            System.out.println(num + " is not a palindrome");
        }
        scanner.close();
        
    }
}
