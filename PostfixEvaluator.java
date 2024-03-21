package ScientificCalculator;

import java.util.Stack;

public class PostfixEvaluator {

    public static double evaluatePostfix(String postFixExpression){
        Stack<Double> operandStack = new Stack<>();

        // Split the postfix expression into tokens
        String[] tokens = postFixExpression.split(" ");
        for (String token : tokens){
            try{
                //If it's a number, push it back onto the stack
                double operand = Double.parseDouble(token);
                operandStack.push(operand);

            } catch (NumberFormatException e) {
                //It's an operator
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(token, operand1,
                        operand2);
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    public static double performOperation(String operator, double operand1, double operand2) {
        switch (operator){
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 ==0){
                    throw new IllegalArgumentException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator" + operator);
        }
    }
}
