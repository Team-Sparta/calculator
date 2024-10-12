package mainHomework.lv3;

public class ZeroDivisionException extends Exception {
    public ZeroDivisionException() {
        super("Division by zero is not allowed.");
    }
}
