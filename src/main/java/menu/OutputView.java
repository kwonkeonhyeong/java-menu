package menu;

public class OutputView {
    private enum OutputMessage {
        OUTPUT_START("점심 메뉴 추천을 시작합니다.");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
    public void printStart() {
        System.out.println(OutputMessage.OUTPUT_START.message);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
