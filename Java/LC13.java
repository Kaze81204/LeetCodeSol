package Java;
/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral,
just two ones added together. 12 is written as XII, 
which is simply X + II. The number 27 is written as XXVII, 
which is XX + V + II.

Roman numerals are usually written largest to smallest
from left to right. However, the numeral for
four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine,
which is written as IX. There are six instances 
where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. */


import java.util.HashMap;
import java.util.Scanner;

public class LC13 {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a Roman numeral
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();  // Convert input to uppercase to handle lowercase input

        // Convert the Roman numeral to an integer
        int result = romanToInt(romanNumeral);

        // Print the result
        if (result != -1) {
            System.out.println("The integer value of the Roman numeral " + romanNumeral + " is: " + result);
        } else {
            System.out.println("Invalid Roman numeral input: " + romanNumeral);
        }

        // Close the scanner
        scanner.close();
    }

    public static int romanToInt(String s) {
        // Create a map to store Roman numerals and their corresponding integer values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Initialize the result integer
        int result = 0;

        // Iterate through the string from left to right
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Check if the current character is a valid Roman numeral
            if (!romanMap.containsKey(currentChar)) {
                return -1;  // Return -1 to indicate invalid input
            }

            int currentValue = romanMap.get(currentChar);

            // Check if the next character exists and if it forms a subtractive combination
            if (i + 1 < s.length() && romanMap.containsKey(s.charAt(i + 1)) && currentValue < romanMap.get(s.charAt(i + 1))) {
                // Subtractive combination: subtract the current value
                result -= currentValue;
            } else {
                // Normal case: add the current value
                result += currentValue;
            }
        }

        return result;
    }
}

