package menu.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPANESE_FOOD(1, "일식"),
    KOREAN_FOOD(2, "한식"),
    CHINESE_FOOD(3, "중식"),
    ASIAN_FOOD(4, "아시안"),
    WESTERN_FOOD(5, "양식");

    private final int categoryCode;
    private final String category;
    private final List<String> menus;

    Category(int categoryCode, String category) {
        this.categoryCode = categoryCode;
        this.category = category;
        this.menus = new ArrayList<>();
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

    public void initializeMenus(List<String> menuList) {
        menus.addAll(menuList);
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getCategory() {
        return category;
    }
}
