package mainHomework.lv4.handler;

import mainHomework.lv4.calculator.ArithmeticCalculator;
import mainHomework.lv4.enums.SortedType;
import mainHomework.lv4.enums.SortingAlgorithmType;
import mainHomework.lv4.exception.BadInputException;

public class PostCalculationHandler {
    private final ArithmeticCalculator calculator;
    private final InputHandler inputHandler;

    public PostCalculationHandler(ArithmeticCalculator calculator, InputHandler inputHandler) {
        this.calculator = calculator;
        this.inputHandler = inputHandler;
    }

    public void handlePostCalculation() throws BadInputException {
        handleSearchResults();
        handleThreshold();
        displayAllResults();

        if (calculator.dataStructure.size() > 1) {
            handleSortResults();
        }
    }

    private void handleSearchResults() throws BadInputException {
        double target = inputHandler.getDoubleInput("결과값안에서 어떤값을 찾나요? ");
        String response = calculator.dataStructure.contains(target)
                ? target + " 이 결과값안에 있습니다."
                : target + " 을 찾을수 없습니다.";
        System.out.println(response);
    }

    private void handleThreshold() throws BadInputException {
        double threshold = inputHandler.getDoubleInput("최종 결과값들의 최소 threshold를 설정하세요: ");
        System.out.println(threshold + "보다 큰 결과값들: " + calculator.dataStructure.getResultsGreaterThan(threshold));
    }

    private void handleSortResults() throws BadInputException {
        System.out.println("결과값들을 정렬하시겠습니까?");
        SortedType sortedType = inputHandler.getSortedTypeInput("S: 스킵, A: 작은 숫자부터 정렬, D: 큰 숫자 부터 정렬: ");
        if (sortedType != SortedType.SKIP) {
            SortingAlgorithmType sortingAlgorithmType = inputHandler.getSortingAlgorithmInput("M: Merge Sort, Q: Quick Sort: ");
            calculator.dataStructure.sort(sortedType, sortingAlgorithmType);
        }
        displayAllResults();
    }

    private void displayAllResults() {
        System.out.print("최종값들: ");
        calculator.dataStructure.print();
    }
}