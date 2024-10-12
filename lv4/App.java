package mainHomework.lv4;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArithmeticCalculator calculator = new ArithmeticCalculator();

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        while (true) {
            try {
                double num1 = getInput("첫 번째 숫자를 입력하세요: ", input -> {
                    try {
                        return Parser.parseFirstNum(input);
                    } catch (BadInputException e) {
                        throw new RuntimeException(e); // Wrap into RuntimeException to bypass checked exception
                    }
                });
                double num2 = getInput("두 번째 숫자를 입력하세요: ", input -> {
                    try {
                        return Parser.parseSecondNum(input);
                    } catch (BadInputException | ZeroDivisionException e) {
                        throw new RuntimeException(e); // Wrap into RuntimeException to bypass checked exception
                    }
                });
                OperatorType operator = getInput("사칙연산 기호를 입력하세요: ", input -> {
                    try {
                        return Parser.parseOperator(input.charAt(0));
                    } catch (BadInputException e) {
                        throw new RuntimeException(e);
                    }
                });

                Double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

                if (continueCalculation()) {
                    break;
                }

//              deleteLastElementInList(sc, parser);
//              displayAllResult(sc, parser);

                displayResultsGreaterThanThreshold();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static <T> T getInput(String prompt, Function<String, T> parser) throws BadInputException, ZeroDivisionException {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return parser.apply(input);
    }


    private static boolean continueCalculation() {
        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        return !"exit".equalsIgnoreCase(scanner.nextLine());
    }

    private static void displayResultsGreaterThanThreshold() {
        System.out.print("최종 결과값들의 최소 threshold 설정하세요: ");
        double threshold = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println(threshold + " 보다 큰 결과값들 : " + calculator.getResultsGreaterThan(threshold));
    }

    private static void displayAllResult(Scanner sc, Parser parser) {
        List<Double> resultList = calculator.getResult();
        System.out.println("결과값들: " + resultList);
    }

    private static void deleteLastElementInList(Scanner sc, Parser parser) {
        System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
        if ("remove".equals(sc.nextLine())) calculator.removeResult();
    }


}
