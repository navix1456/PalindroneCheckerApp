/**
 * ================================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 13: Performance Comparison of Palindrome Algorithms
 *
 * Description:
 * Compares execution time of different palindrome algorithms
 * using System.nanoTime().
 *
 * Algorithms Compared:
 * 1. Stack Based
 * 2. Deque Based
 * 3. Two-Pointer Based
 *
 * @author Navin Muthu M
 * @version 13.0
 */

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase13PalindromeCheckerApp {

    /* ===============================
       Stack Approach
       =============================== */
    public static boolean stackPalindrome(String input) {
        String normalized = input.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    /* ===============================
       Deque Approach
       =============================== */
    public static boolean dequePalindrome(String input) {
        String normalized = input.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    /* ===============================
       Two Pointer Approach
       =============================== */
    public static boolean twoPointerPalindrome(String input) {
        String normalized = input.toLowerCase();

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

    /* ===============================
       Main Method
       =============================== */
    public static void main(String[] args) {

        String input = "racecar";

        // Stack Timing
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();

        // Deque Timing
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();

        // Two Pointer Timing
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(input);
        long endTwoPointer = System.nanoTime();

        System.out.println("Input: " + input);
        System.out.println("--------------------------------------");

        System.out.println("Stack Result       : " + stackResult);
        System.out.println("Stack Time (ns)    : " + (endStack - startStack));

        System.out.println("--------------------------------------");

        System.out.println("Deque Result       : " + dequeResult);
        System.out.println("Deque Time (ns)    : " + (endDeque - startDeque));

        System.out.println("--------------------------------------");

        System.out.println("Two Pointer Result : " + twoPointerResult);
        System.out.println("Two Pointer Time(ns): " + (endTwoPointer - startTwoPointer));
    }
}git checkout -b UC13-performance-comparison