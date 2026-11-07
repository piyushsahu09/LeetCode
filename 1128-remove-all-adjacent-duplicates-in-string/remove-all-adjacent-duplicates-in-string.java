import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            // 1. Check if the top element matches the current character
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // It's a duplicate pair! Remove the top element.
            } else {
                stack.push(c); // Not a duplicate. Push it onto the stack.
            }
        }
        
        // 2. Build the final string from the characters left in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // 3. Because a stack is LIFO, popping elements gives them to us in reverse order.
        // We must reverse the string before returning it.
        return result.reverse().toString();
    }
}