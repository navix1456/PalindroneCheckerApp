/**
 * ================================================================
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome Checker
 *
 * Description:
 * This class validates whether a given string is a palindrome
 * while ignoring:
 * 1. Spaces
 * 2. Special characters
 * 3. Case differences
 *
 * Steps:
 * 1. Normalize the string (remove spaces & special characters).
 * 2. Convert to lowercase.
 * 3. Apply two-pointer comparison logic.
 *
 * Data Structure Used:
 * String / Character Array
 *
 * @author Navin Muthu M
 * @version 10.0
 */

public class UseCase10PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Two-pointer approach
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        boolean result = isPalindrome(input);

        System.out.println("Original Input : " + input);
        System.out.println("Normalized     : " + input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
        System.out.println("Is Palindrome? : " + result);
    }
}