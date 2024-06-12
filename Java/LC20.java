package Java;
/* 20. Valid Parentheses
Given a string s containing just the characters
'(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Input: s = "()[]{}"
Output: true* 
 */

import java.util.Stack;
import java.util.*;
public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the input string.
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if the stack is empty or if the top
                // of the stack does not match the corresponding opening bracket.
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // After processing all characters, the stack should be empty if the input string is valid.
        return stack.isEmpty();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String containing () {} []");
        String s1 = scanner.nextLine();
        LC20 lc20 = new LC20();
        boolean result = lc20.isValid(s1);
        System.out.println(result);
        scanner.close();

    }
    }

