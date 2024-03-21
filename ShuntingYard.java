package ScientificCalculator;

import java.util.*;

public class ShuntingYard {
    public static final Map<Character, Integer> precedence = new HashMap<>();

    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }

    public static String shuntingYard(String infixExpression) {
        StringBuilder output = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char token : infixExpression.toCharArray()) {
            if (Character.isDigit(token)) {
                output.append(token);
            } else if (precedence.containsKey(token)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                        precedence.get(token) <= precedence.get(operatorStack.peek())) {
                    output.append(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                while (operatorStack.peek() != '(') {
                    output.append(operatorStack.pop());
                }
                operatorStack.pop(); // Remove the '('
            }
        }

        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop());
        }

        return output.toString();
    }
}
