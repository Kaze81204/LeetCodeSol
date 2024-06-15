/*
14. Longest Common Prefix
Write a function to find the longest common 
prefix string amongst an array of strings.

If there is no common prefix, return an 
empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Concept: After sorting the array, by comparing the first and last
strings and getting the common prefix of both will give
us the longest common prefix in the array, no need 
to compare with the strings in between the first and last
one.

*/



package Java.Easy;
import java.util.Arrays;
public class LC14 {
    public static String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int index = 0;
        while (index< str1.length()) {
            if(str1.charAt(index) == str2.charAt(index)){
                index++;
            }
            else{
                break;
            }            
        }
        return index == 0 ?"": str1.substring(0, index);
    }

    public static void main(String[] args){
        String strs[] = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}

