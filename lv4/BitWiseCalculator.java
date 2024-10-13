package mainHomework.lv4;

public class BitWiseCalculator extends Calculator {
    @Override
    public <T extends Number> double add(T firstNumber, T secondNumber) {
        double a = firstNumber.doubleValue();
        double b = secondNumber.doubleValue();

        // Split into integer and fractional parts
        long intPartA = (long) a;
        long intPartB = (long) b;
        double fractionPartA = a - intPartA;
        double fractionPartB = b - intPartB;

        // Calculate integer part using bitwise
        long intSum = 0;
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

    @Override
    public <T extends Number> double subtract(T firstNumber, T secondNumber) {
        return add(firstNumber, add(~secondNumber.intValue() + 1, 0)); // a - b is the same as a + (~b + 1)
    }

    @Override
    public <T extends Number> double multiply(T firstNumber, T secondNumber) {
        double a = firstNumber.doubleValue();
        double b = secondNumber.doubleValue();

        // Split into integer and fractional parts
        long intPartA = (long) a;
        long intPartB = (long) b;
        double fractionPartA = a - intPartA;
        double fractionPartB = b - intPartB;

        double result = 0;

        // Integer multiplication using bitwise operations
        while (intPartB != 0) {
            if ((intPartB & 1) != 0) { // If the last bit of b is set
                result = add(result, intPartA); // Add current value of a to result
            }
            intPartA <<= 1; // Shift a left by 1 (multiply by 2)
            intPartB >>= 1; // Shift b right by 1 (divide by 2)
        }

        // Combine integer result with fractional multiplication
        double fractionalResult = fractionPartA * intPartB + fractionPartB * intPartA + fractionPartA * fractionPartB;

        return result + fractionalResult; // Return the final product
    }

    @Override
    public <T extends Number> double divide(T firstNumber, T secondNumber) {
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

        return finalQuotient + fractionalPart; // Return combined result
    }

    @Override
    public <T extends Number> double modulo(T firstNumber, T secondNumber) {
        return subtract(firstNumber, multiply(divide(firstNumber, secondNumber), secondNumber)); // a % b is a - (a / b) * b
    }
}