package mainHomework.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExited = false;

        while (!isExited) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operatorInput = scanner.next().charAt(0);

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = scanner.nextInt();

            double result = 0;
            switch (operatorInput) {
                case '+' -> result = firstNumber + secondNumber;
                case '-' -> result = firstNumber - secondNumber;
                case '*' -> result = firstNumber * secondNumber;
                case '/' -> result = (double) firstNumber / secondNumber;
                case '%' -> result = (double) firstNumber % secondNumber;
            }

            System.out.println("결과: " + result);

            scanner.nextLine();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            isExited = "exit".equals(scanner.nextLine());
        }
    }
}