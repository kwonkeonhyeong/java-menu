package menu.validator;

public abstract class Validator<T> {

    abstract T validate(String input);

    // trim() 기능 등 공통적으로 쓸 기능 있으면 static으로 구현해서 써도 좋음
}
