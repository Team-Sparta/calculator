package mainHomework.lv4;

import mainHomework.lv4.calculator.Calculator;
import mainHomework.lv4.calculator.exception.BadInputException;
import mainHomework.lv4.calculator.exception.ZeroDivisionException;
import mainHomework.lv4.utils.enums.DataStructureType;
import mainHomework.lv4.calculator.enums.OperatorType;
import mainHomework.lv4.calculator.handler.InputHandler;
import mainHomework.lv4.calculator.handler.PostCalculationHandler;

import java.util.InputMismatchException;

public class App {

    private static Calculator calculator;
    private static final InputHandler inputHandler = new InputHandler();
    private static PostCalculationHandler postCalculationHandler;

    public static void main(String[] args) {
        start();
    }

    public static void start() throws InputMismatchException {
        init();
        while (true) {
            try {
                Double choice = inputHandler.getChoice("1: 수식 한줄 입력, 2: 숫자/연산자 개별 입력 [1/2]: ");
                double result;

                if (choice == 2) {
                    // Prompt for individual number and operator inputs
                    double num1 = inputHandler.getFirstNumber();
                    double num2 = inputHandler.getSecondNumber();
                    OperatorType operator = inputHandler.getOperator();
                    result = calculator.calculate(num1, num2, operator);
                } else {
                    // Default to single expression input
                    String expression = inputHandler.getExpression();
                    result = calculator.calculateWithOneCommand(expression);
                }

                System.out.println("결과: " + result);

                postCalculationHandler.handlePostCalculation();

                if (inputHandler.shouldExit()) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch: " + e.getMessage());
            } catch (BadInputException e) {
                System.out.println("Bad Input: " + e.getMessage());
            } catch (ZeroDivisionException e) {
                System.out.println("Zero Division Error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void init() {
        try {
            System.out.println("결과값들을 저장할 자료구조를 선택하세요.");
            DataStructureType dataStructureType = inputHandler.getDataStructureInput("l: List, S: Set, L: LinkedList, Q: Queue, M Map: ");
            calculator = new Calculator(dataStructureType);
            postCalculationHandler = new PostCalculationHandler(calculator, inputHandler);
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch: " + e.getMessage());
        } catch (BadInputException e) {
            System.out.println("Bad Input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}