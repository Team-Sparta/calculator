package mainHomework.lv4.calculator.function;

public class LogFunction implements Function {

    @Override
    public double operate(double number) {
        return (int) (Math.log(number) / Math.log(2));
    }
}
