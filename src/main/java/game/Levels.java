package game;

import java.util.HashMap;
import java.util.Map;

public enum Levels {
    FIRST(1, 150, 100, 20, 20),
    SECOND(2, 300, 200, 25, 25),
    THIRD(3, 450, 250, 30, 30),
    FOURTH(4, 600, 300, 35, 35),
    FIFTH(5, 999, 350, 40, 40);

    private final int level;
    private final int exp;
    private final int healthPoints;
    private final int strength;
    private final int dexterity;
    private static final Map<Integer, Levels> lvls = new HashMap<>();

    Levels(int level, int exp, int healthPoints, int strength, int dexterity) {
        this.level = level;
        this.exp = exp;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.dexterity = dexterity;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public static Levels valueOf(int level) {
        return lvls.get(level);
    }

    static {
        for (Levels l: Levels.values()) {
            lvls.put(l.getLevel(), l);
        }
    }
}
