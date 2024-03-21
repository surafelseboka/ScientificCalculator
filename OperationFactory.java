package ScientificCalculator;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    public enum OperationType{
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        MODULO
    }

    private static final Map<OperationType, Operation> operationMap = new HashMap<>();

    public static Operation operation(OperationType operationType){
        if (!operationMap.containsKey(operationType)) {
            synchronized (OperationFactory.class) {
                if (!operationMap.containsKey(operationType)) {
                    switch (operationType){
                        case ADDITION:
                            operationMap.put(operationType, new Addition());
                            break;
                        case SUBTRACTION:
                            operationMap.put(operationType, new Subtraction());
                            break;
                        case MULTIPLICATION:
                            operationMap.put(operationType, new Multiplication());
                            break;
                        case DIVISION:
                            operationMap.put(operationType, new Division());
                            break;
                        case MODULO:
                            operationMap.put(operationType, new Modulo());
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operation type");
                    }
                }
            }
        }
        return operationMap.get(operationType);
    }

//    public static OperationFactory operation(OperationType operationType){
//        switch (operationType){
//            case ADDITION: return new Addition();
//            case SUBTRACTION: return new Subtraction();
//            case MULTIPLICATION: return new Multiplication();
//            case DIVISION: return new Division();
//            case MODULO:return new Modulo();
//            default: throw new IllegalArgumentException("Invalid operation type");
//        }
//    }

}
