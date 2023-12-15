package menu.utils;

public enum ExceptionMessage {
    OUT_OF_NAME_LENGTH("코치 이름은 최소 2글자에서 최대 4글자 까지 입력 가능합니다."),
    OUT_OF_COACH_COUNT("코치는 최소 2명부터 최대 5명까지 입력 가능합니다."),
    OUT_OF_HATE_MENU_COUNT("먹지 못하는 메뉴는 최소 0개부터 최대 2개까지 입력 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
