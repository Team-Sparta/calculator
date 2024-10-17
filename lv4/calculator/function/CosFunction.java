package mainHomework.lv4.calculator.function;

public class CosFunction implements Function {
    @Override
    public double operate(double number) {
        return Math.cos(number);
    }
}
