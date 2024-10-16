package mainHomework.lv4.calculator.exception;

public class ZeroDivisionException extends Exception {
    public ZeroDivisionException() {
        super("Division by zero is not allowed.");
    }
}
