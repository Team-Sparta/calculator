package mainHomework.lv2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */

        boolean isExited = false;
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        do {

            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            Double result = calculator.calculate(num1, num2, operator);
            System.out.println("결과: " + result);

            sc.nextLine();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            isExited = "exit".equals(sc.nextLine());

            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if ("remove".equals(sc.nextLine())) calculator.removeResult();

            List<Double> resultList = calculator.getResult();
            System.out.println("결과값들: " + resultList);
        }
        while (!isExited);
        /* 반복문 종료 */
    }
}
