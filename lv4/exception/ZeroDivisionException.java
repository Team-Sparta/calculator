package mainHomework.lv4.exception;

public class ZeroDivisionException extends Exception {
    public ZeroDivisionException() {
        super("Division by zero is not allowed.");
    }
}
