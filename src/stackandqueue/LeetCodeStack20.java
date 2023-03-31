package stackandqueue;

import java.util.Stack;

public class LeetCodeStack20 {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) {
                    return false;
                }
                char openPeek = myStack.peek();
                if ((c == ')' && openPeek == '(') || (c == ']' && openPeek == '[') || (c == '}' && openPeek == '{')) {
                    myStack.pop();
                } else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        var leetCodeStack20 = new LeetCodeStack20();
        String s = "{[]}";
        System.out.println(leetCodeStack20.isValid(s));
    }
}
