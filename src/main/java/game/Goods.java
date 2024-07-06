package game;

import java.util.HashMap;
import java.util.Map;

public enum Goods {

    POTION( "potion", 10, "Здоровье восстановлено.");

    private final String name;
    private final int cost;
    private final String message;
    private static final Map<String, Goods> goodMap = new HashMap<>();

    Goods(String name, int cost, String message) {
        this.name = name;
        this.cost = cost;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getMessage() {
        return message;
    }

    public static Goods valueOfName(String goodName) {
        return goodMap.get(goodName);
    }

    static {
        for (Goods g: Goods.values()) {
            goodMap.put(g.getName(), g);
        }
    }
}
