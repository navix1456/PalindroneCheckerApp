/**
 * ================================================================
 * MAIN CLASS - UseCase9PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates whether a given string is a palindrome
 * using recursion.
 *
 * Steps:
 * 1. Compare first and last characters.
 * 2. If equal, recursively check substring.
 * 3. Stop when start index >= end index.
 *
 * Data Structure Used:
 * Call Stack (Recursion)
 *
 * @author Navin Muthu M
 * @version 9.0
 */

public class UseCase9PalindromeCheckerApp {

    // Recursive method
    public static boolean isPalindrome(String input, int start, int end) {

        // Base Condition
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "level";

        boolean result = isPalindrome(input, 0, input.length() - 1);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}