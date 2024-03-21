package ScientificCalculator;

import java.lang.reflect.Type;

public class InputValidation {

    public static boolean isValidType(String type){
        return type.equalsIgnoreCase("ADDITION") ||
                type.equalsIgnoreCase("SUBTRACTION") ||
                type.equalsIgnoreCase("DIVISION") ||
                type.equalsIgnoreCase("MULTIPLICATION") ||
                type.equalsIgnoreCase("MODULO");
    }
}
