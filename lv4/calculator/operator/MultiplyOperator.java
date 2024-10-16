package mainHomework.lv4.calculator.operator;

public class MultiplyOperator implements Operator {
    final AddOperator addOperator = new AddOperator();

    @Override
    public <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() * secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber) {
        double a = (double) firstNumber;
        double b = (double) secondNumber;

        // Split into integer and fractional parts
        long intPartA = (long) a;
        long intPartB = (long) b;
        double fractionPartA = a - intPartA;
        double fractionPartB = b - intPartB;

        double result = 0;

        // Integer multiplication using bitwise operations
        while (intPartB != 0) {
            if ((intPartB & 1) != 0) { // If the last bit of b is set
                result = addOperator.bitwiseOperate(result, intPartA); // Add current value of a to result
            }
            intPartA <<= 1; // Shift a left by 1 (multiply by 2)
            intPartB >>= 1; // Shift b right by 1 (divide by 2)
        }

        // Combine integer result with fractional multiplication
        double fractionalResult = fractionPartA * intPartB + fractionPartB * intPartA + fractionPartA * fractionPartB;

        return result + fractionalResult; // Return the final product
    }
}
