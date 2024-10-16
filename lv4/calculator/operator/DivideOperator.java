package mainHomework.lv4.calculator.operator;

import mainHomework.lv4.calculator.exception.ZeroDivisionException;

public class DivideOperator implements Operator {

    @Override
    public <T extends Number> double arithmeticOperate(T firstNumber, T secondNumber) throws ZeroDivisionException {
        if (secondNumber.doubleValue() == 0) {
            throw new ZeroDivisionException();
        }
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }

    @Override
    public <T extends Number> double bitwiseOperate(T firstNumber, T secondNumber) {
        double dividend = (double) firstNumber;
        double divisor = (double) secondNumber;

        if (divisor == 0.0) {
            throw new ArithmeticException("Division by zero"); // Handle division by zero
        }

        // Determine the sign of the quotient
        boolean negativeResult = (dividend < 0) ^ (divisor < 0); // XOR to determine the sign of the result
        dividend = Math.abs(dividend); // Work with absolute values
        divisor = Math.abs(divisor);

        // Calculate the integer part of the quotient
        int quotient = 0;
        while (dividend >= divisor) {
            dividend -= divisor; // Subtract divisor from dividend
            quotient++; // Increase quotient
        }

        // Convert the quotient to a double
        double finalQuotient = negativeResult ? -quotient : quotient;

        // Calculate the fractional part using a more precise method
        double fractionalPart = getFractionalPart(dividend, divisor);

        return finalQuotient + fractionalPart; // Return combined result
    }

    private static double getFractionalPart(double dividend, double divisor) {
        double fractionalPart = 0.0;
        double fractionNumerator = dividend; // Start with the remaining dividend

        // Here, we can add a precision variable
        double precision = 0.1; // This controls the precision of the fractional part
        for (int i = 0; i < 10; i++) { // Up to 10 decimal places for precision
            fractionNumerator *= 10; // Shift decimal point for the next digit
            int fractionalDigit = 0; // Initialize fractional digit

            while (fractionNumerator >= divisor) {
                fractionNumerator -= divisor; // Subtract divisor from the numerator
                fractionalDigit++; // Count how many times we can subtract
            }

            fractionalPart += fractionalDigit * precision; // Add to the fractional part
            precision /= 10; // Decrease precision for next decimal place
        }
        return fractionalPart;
    }
}
