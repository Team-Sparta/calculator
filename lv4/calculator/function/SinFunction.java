package mainHomework.lv4.calculator.function;

public class SinFunction implements Function {
    @Override
    public double operate(double number) {
        return Math.sin(number);
    }
}
