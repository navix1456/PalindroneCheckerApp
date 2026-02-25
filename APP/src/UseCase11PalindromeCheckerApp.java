/**
 * ================================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * Demonstrates encapsulation by separating palindrome logic
 * into a dedicated PalindromeChecker service class.
 *
 * OOPS Concepts Used:
 * - Encapsulation
 * - Single Responsibility Principle
 *
 * Data Structure Used:
 * Character Array (internal comparison)
 *
 * @author Navin Muthu M
 * @version 11.0
 */

class PalindromeChecker {

    // Encapsulated method
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize string (ignore spaces & case)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] chars = normalized.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        PalindromeChecker checker = new PalindromeChecker();

        String input = "Madam In Eden Im Adam";

        boolean result = checker.checkPalindrome(input);

        System.out.println("Input String   : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}