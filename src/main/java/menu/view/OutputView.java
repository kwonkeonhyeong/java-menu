package menu.view;

import java.util.List;

public class OutputView {
    private enum OutputMessage {
        OUTPUT_START("점심 메뉴 추천을 시작합니다."),
        OUTPUT_RECOMMEND_RESULT("메뉴 추천 결과입니다."),
        OUTPUT_END("추천을 완료했습니다.");


        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
    public void printStart() {
        System.out.println(OutputMessage.OUTPUT_START.message);
    }
    public void printRecommendEND() {
        System.out.println(OutputMessage.OUTPUT_RECOMMEND_RESULT.message);
    }
    public void printEND() {
        System.out.println(OutputMessage.OUTPUT_END.message);
    }

    public void printRecommendResult(String header, List<String> result) {
        System.out.print("[ ");
        for (int i = 0; i < result.size() + 1; i++) {
            if (i == 0) {
                System.out.print(header);
            }
            if (i != 0) {
                System.out.print(result.get(i-1));
            }
            if (i < result.size()) {
                System.out.print(" | ");
            }
        }
        System.out.print(" ]");
    }

    public void printBlank() {
        System.out.println();
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
