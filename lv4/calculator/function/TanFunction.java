package mainHomework.lv4.calculator.function;

public class TanFunction implements Function {
    @Override
    public double operate(double number) {
        return Math.tan(number);
    }
}
