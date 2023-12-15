package menu.validator;

import static menu.convertor.Convertor.COMMA;
import static menu.convertor.Convertor.splitInput;
import static menu.utils.ExceptionMessage.OUT_OF_HATE_MENU_COUNT;

import java.util.List;

public class InputHateMenuValidator extends Validator<String>{

    private static final int HATE_MENU_COUNT_MAX = 2;

    @Override
    public String validate(String input) {
        List<String> menus = splitInput(input,COMMA);
        validateMenusCount(menus);
        return input;
    }


    private void validateMenusCount(List<String> input) {
        int coachCount = input.size();
        if (coachCount <= HATE_MENU_COUNT_MAX) {
            return;
        }
        throw new IllegalArgumentException(OUT_OF_HATE_MENU_COUNT.getMessage());
    }
}
