package menu.convertor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {

    public static final String COMMA = ",";

    private Convertor() {};

    public static List<String> splitInput(String input, String separator) {
        String[] splitInput = input.split(separator);
        return new ArrayList<>(Arrays.asList(splitInput));
    }
}
