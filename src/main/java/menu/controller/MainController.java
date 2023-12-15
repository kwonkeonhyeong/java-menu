package menu.controller;

import static menu.convertor.Convertor.COMMA;
import static menu.convertor.Convertor.splitInput;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.menu.Category;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        String inputCoachNames = inputView.readCoachName();
        List<String> inputCoaches = splitInput(inputCoachNames,COMMA);

        Map<String, List<String>> coaches = new LinkedHashMap<>();
        for (String inputCoach : inputCoaches) {
            String inputHateMenus= inputView.readHateMenu(inputCoach);
            coaches.put(inputCoach, splitInput(inputHateMenus,COMMA));
        }

        List<String> recommendCategories = recommendCategory();

        Map<String, List<String>> recommendResult = makeRecommendResult(coaches,recommendCategories);

        outputView.printRecommendEND();
        displayRecommend("구분",Arrays.asList("월요일","화요일","수요일","목요일","금요일"));
        displayRecommend("카테고리", recommendCategories);
        for (String coach : recommendResult.keySet()) {
            displayRecommend(coach,recommendResult.get(coach));
        }
        outputView.printEND();
    }

    public List<String> recommendCategory() {
        List<String> recommends = new ArrayList<>();

        while (recommends.size() < 5) {
            Category category = Category.from(Randoms.pickNumberInRange(1, 5));
            long count = recommends.stream()
                    .filter(str -> str.equals(category.getCategory()))
                    .count();
            if (count < 2) {
                recommends.add(category.getCategory());
            }
        }
        return recommends;
    }

    public String recommendMenu(List<String> menus, List<String> hateMenu, List<String> recommendMenus) {
        List<String> copyMenus = new ArrayList<>(menus);
        boolean isRecommend = false;
        String menu;
        do {
            menu = Randoms.shuffle(copyMenus).get(0);
            if (recommendMenus.contains(menu) || hateMenu.contains(menu)) {
                continue;
            }
            isRecommend = true;
        } while (!isRecommend);
        return menu;
    }

    public Map<String, List<String>> makeRecommendResult(Map<String, List<String>> coaches, List<String> recommendCategories) {
        Map<String, List<String>> recommendResult = new LinkedHashMap<>();
        for (String coach : coaches.keySet()) {
            recommendResult.put(coach,new ArrayList<>());
        }

        for (String category : recommendCategories) {
            for (String coach : coaches.keySet()) {
                String menu = recommendMenu(Category.from(category).getMenus(),coaches.get(coach),recommendResult.get(coach));
                recommendResult.get(coach).add(menu);
            }
        }
        return recommendResult;
    }

    public void displayRecommend(String header,  List<String> result) {
        outputView.printRecommendResult(header, result);
        outputView.printBlank();
    }
}
