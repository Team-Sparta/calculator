package mainHomework.lv4.calculator.operator;

public class AddOperator implements Operator {

    @Override
    public <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() + secondNumber.doubleValue();
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

        // Calculate integer part using bitwise
        long intSum;
        while (intPartB != 0) {
            long carry = intPartA & intPartB; // Calculate carry bits
            intPartA = intPartA ^ intPartB;   // Sum bits without carrying
            intPartB = carry << 1;            // Shift carry bits to add in the next position
        }
        intSum = intPartA; // Final integer sum

        // Calculate fractional part
        double fractionalSum = fractionPartA + fractionPartB;

        // Combine the results
        return intSum + fractionalSum; // Return the final sum
    }
}
