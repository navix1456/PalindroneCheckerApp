import java.util.Deque;
import java.util.LinkedList;

/**
 * ================================================================
 * MAIN CLASS - UseCase7PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 7: Deque-Based Optimized Palindrome Checker
 *
 * Description:
 * This class validates whether a given string is a palindrome
 * using a Deque (Double Ended Queue).
 *
 * The deque allows insertion and deletion from both front and rear.
 * Characters are inserted into the deque and then compared by
 * removing from both ends until empty.
 *
 * If all characters match, the string is confirmed as a palindrome.
 *
 * Data Structure Used:
 * Deque (FIFO + LIFO capability)
 *
 * @author Navin Muthu M
 * @version 7.0
 */

public class UseCase7PalindromeCheckerApp {

    /**
     * Application entry point for UC7.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Define input string
        String input = "madam";

        // Create Deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}