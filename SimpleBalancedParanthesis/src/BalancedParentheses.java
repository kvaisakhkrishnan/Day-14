import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // Closing parenthesis without a matching opening parenthesis
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // If the stack is empty, the expression is balanced
    }

    public static void main(String[] args) {
        String arithmeticExpression = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";

        boolean result = isBalanced(arithmeticExpression);

        System.out.println("Arithmetic Expression is balanced: " + result);
    }
}