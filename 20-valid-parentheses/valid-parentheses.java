import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            // FIX 1: Use || (OR) instead of && (AND)
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            else { // Opening of the else block
                if (st.isEmpty()) {
                    return false;
                }
                
                // FIX 2: This pop() and comparison must stay INSIDE the else block
                char top = st.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            } // Closing of the else block
        }
        
        return st.isEmpty();
    } 
}