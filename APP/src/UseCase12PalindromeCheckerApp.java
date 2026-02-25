/**
 * ================================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ================================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * Demonstrates dynamic selection of palindrome checking
 * algorithm using Strategy Design Pattern.
 *
 * OOPS Concepts Used:
 * - Interface
 * - Polymorphism
 * - Strategy Pattern
 *
 * @author Navin Muthu M
 * @version 12.0
 */

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

/* ===========================
   Strategy Interface
   =========================== */
interface PalindromeStrategy {
    boolean check(String input);
}

/* ===========================
   Stack Strategy (LIFO)
   =========================== */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
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
}

/* ===========================
   Deque Strategy (Optimized)
   =========================== */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
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
}

/* ===========================
   Context Class
   =========================== */
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

/* ===========================
   Main Application
   =========================== */
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "RaceCar";

        PalindromeContext context = new PalindromeContext();

        // Using Stack Strategy
        context.setStrategy(new StackStrategy());
        System.out.println("Using Stack Strategy:");
        System.out.println("Is Palindrome? " + context.execute(input));

        // Using Deque Strategy
        context.setStrategy(new DequeStrategy());
        System.out.println("\nUsing Deque Strategy:");
        System.out.println("Is Palindrome? " + context.execute(input));
    }
}