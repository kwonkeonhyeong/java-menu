package menu;

import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.validator.InputValidator;

public class InputView {
    private enum InputMessage {
        INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)."),
        INPUT_HATE_MENU("토미(이)가 못 먹는 메뉴를 입력해 주세요.");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }
    public String readCoachName() {
        try {
            System.out.println(InputMessage.INPUT_COACH_NAME.message);
            String input = readLine().trim();
            return new InputValidator().validate(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readCoachName();
        }
    }
}
