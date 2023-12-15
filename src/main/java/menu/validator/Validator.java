package menu.validator;

public abstract class Validator<T> {

    abstract T validate(String input);

}
