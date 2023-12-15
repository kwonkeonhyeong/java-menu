package menu;

import menu.controller.MainController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MainController MainController = new MainController(inputView, outputView);
        MainController.run();
    }
}
