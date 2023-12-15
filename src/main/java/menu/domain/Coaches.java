package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coaches {
    private final Map<String, List<String>> coaches;

    private Coaches() {
        this.coaches = new LinkedHashMap<>();
    }


    public static Coaches create() {
        return new Coaches();
    }

    public void addCoachInformation(String coach, List<String> hateMenu) {
        coaches.put(coach, hateMenu);
    }

    public Set<String> getCoachesName() {
        return coaches.keySet();
    }

    public List<String> getHateMenus(String name) {
        return coaches.get(name);
    }
}
