package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPANESE_FOOD(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_FOOD(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_FOOD(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_FOOD(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_FOOD(5, "양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int categoryCode;
    private final String category;
    private final List<String> menus;

    Category(int categoryCode, String category, List<String> menus) {
        this.categoryCode = categoryCode;
        this.category = category;
        this.menus = menus;
    }


    public static Category from(int categoryCode) {
        return Arrays.stream(Category.values())
                .filter(menu -> menu.categoryCode == categoryCode)
                .findFirst()
                .orElse(null);
    }

    public static Category from(String category) {
        return Arrays.stream(Category.values())
                .filter(menu -> menu.category.equals(category))
                .findFirst()
                .orElse(null);
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getCategory() {
        return category;
    }
}
