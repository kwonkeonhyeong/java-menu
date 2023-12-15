package menu.utils;

public enum ExceptionMessage {
    OUT_OF_RANGE("입력 범위를 초과했습니다."),
    OUT_OF_NAME_LENGTH("코치 이름은 최소 2글자에서 최대 4글자 까지 입력 가능합니다."),
    OUT_OF_COACH_COUNT("코치는 최소 2명부터 최대 5명까지 입력 가능합니다."),
    INVALID_NOT_NUMERIC("숫자만 입력 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
