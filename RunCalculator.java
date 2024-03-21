package ScientificCalculator;

import java.util.Scanner;

public class RunCalculator {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the string: ");

        String infixExpression = "4 * 5 + 2";
        String postFixExpression = ShuntingYard.shuntingYard(infixExpression);
        System.out.println(postFixExpression);

        double evaluate = PostfixEvaluator.evaluatePostfix(infixExpression);
        System.out.println(evaluate);




        // Try shaun algorithm
//        String input = scanner.nextLine();
//        String postFix = ShuntingYard.shuntingYard(input);
//        String example = "3 + 4 * (2 - 1)";
//        System.out.println(ShuntingYard.shuntingYard(example));
//        System.out.println(postFix);
//        System.out.println(PostfixEvaluator.evaluatePrefix(postFix));

        //Get user input for numbers
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        //Get user input for the operation type
        System.out.print("Enter operation type (ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION): ");
        String operation_type = scanner.next().toUpperCase();

        try {
            //convert the input to enum type
            OperationFactory.OperationType operationType = OperationFactory.OperationType.valueOf(operation_type);

            //Get the right operation object using the factory
            Operation operation = OperationFactory.operation(operationType);

            //Perform the calculation and display the result
            double result = operation.calculate(num1,num2);
            System.out.println("Result: " + result);

        } catch (IllegalArgumentException e){
            System.out.println("Invalid operation type");
        }



    }
    }

