package menu.validator;


import static menu.convertor.Convertor.COMMA;
import static menu.convertor.Convertor.splitInput;
import static menu.utils.ExceptionMessage.OUT_OF_COACH_COUNT;
import static menu.utils.ExceptionMessage.OUT_OF_NAME_LENGTH;

import java.util.List;

public class InputValidator extends Validator<String> {

    private static final int NAME_LENGTH_MIN = 2;
    private static final int NAME_LENGTH_MAX = 4;

    private static final int COACH_COUNT_MIN = 2;
    private static final int COACH_COUNT_MAX = 5;

    @Override
    public String validate(String input) {
        List<String> coaches = splitInput(input,COMMA);
        System.out.println(coaches);
        validateCoachCount(coaches);
        for (String coach : coaches) {
            System.out.println(coach);
            validateNameLength(coach);
        }
        return input;
    }


    private void validateNameLength(String input) {
        int nameLength = input.length();
        if (nameLength >= NAME_LENGTH_MIN && nameLength <= NAME_LENGTH_MAX) {
            return;
        }
        System.out.println("이름길이");
        throw new IllegalArgumentException(OUT_OF_NAME_LENGTH.getMessage());
    }

    private void validateCoachCount(List<String> input) {
        int coachCount = input.size();
        if (coachCount >= COACH_COUNT_MIN && coachCount <= COACH_COUNT_MAX) {
            return;
        }
        System.out.println("코치명수");
        throw new IllegalArgumentException(OUT_OF_COACH_COUNT.getMessage());
    }
}
