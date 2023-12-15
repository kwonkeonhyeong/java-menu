package menu;

import static menu.convertor.Convertor.COMMA;
import static menu.convertor.Convertor.splitInput;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        // *** 카테고리 별 메뉴 ***
        List<String> japaneseFood = new ArrayList<>(
                Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        List<String> koreanFood = new ArrayList<>(
                Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        List<String> chineseFood = new ArrayList<>(
                Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        List<String> asianFood = new ArrayList<>(
                Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        List<String> westernFood = new ArrayList<>(
                Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

        HashMap<String, List<String>> menus = new HashMap<>();
        menus.put("일식", japaneseFood);
        menus.put("한식", koreanFood);
        menus.put("중식", chineseFood);
        menus.put("아시안", asianFood);
        menus.put("양식", westernFood);
        // *** 카테고리 별 메뉴 ***

        List<String> recommendCategories = recommendCategory();

        Map<String, List<String>> recommendResult = makeRecommendResult(coaches,menus,recommendCategories);

        outputView.printRecommendEND();
        displayRecommend("구분",Arrays.asList("월요일","화요일","수요일","목요일","금요일"));
        displayRecommend("카테고리", recommendCategories);
        for (String coach : recommendResult.keySet()) {
            displayRecommend(coach,recommendResult.get(coach));
        }
        outputView.printEND();
    }

    public List<String> recommendCategory() {
        HashMap<Integer, String> categories = new HashMap<>();
        categories.put(1, "일식");
        categories.put(2, "한식");
        categories.put(3, "중식");
        categories.put(4, "아시안");
        categories.put(5, "양식");

        List<String> recommends = new ArrayList<>();

        while (recommends.size() < 5) {
            String category = categories.get(Randoms.pickNumberInRange(1, 5));
            long count = recommends.stream()
                    .filter(str -> str.equals(category))
                    .count();
            if (count < 2) {
                recommends.add(category);
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

    public Map<String, List<String>> makeRecommendResult(Map<String, List<String>> coaches, HashMap<String, List<String>> menus, List<String> recommendCategories) {
        Map<String, List<String>> recommendResult = new LinkedHashMap<>();
        for (String coach : coaches.keySet()) {
            recommendResult.put(coach,new ArrayList<>());
        }

        for (String category : recommendCategories) {
            for (String coach : coaches.keySet()) {
                String menu = recommendMenu(menus.get(category),coaches.get(coach),recommendResult.get(coach));
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
