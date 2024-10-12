package mainHomework.lv3;

public class ZeroDivisionError extends Exception {
    public ZeroDivisionError() {
        super("Division by zero is not allowed.");
    }
}
