package game.io;

import game.Levels;

public abstract class AbstractCharacter implements Figther {

    private String name;
    private int healthPoints;
    private int strength;
    private int dexterity;
    private int xp;
    private int gold;
    private int level;

    public AbstractCharacter(String name, int healthPoints, int strength, int dexterity, int xp, int gold, int level) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
    }

    @Override
    public int attack() {
        int value = getRandomValue();
        if (dexterity * 3 > value) return ((value%10 == 0) ? 2:1) * strength;
        else return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        Levels currentLevel = Levels.valueOf(getLevel());
        if (currentLevel.getExp() <= xp) {
            setLevel(++level);
            System.out.println(String.format("Вы получили %d уровень!\n Сила: %d\n Ловкоть: %d\n Здоровье: %d", getLevel(), getStrength(), getDexterity(), getHealthPoints()));
        }
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        setCharacteristics(level);
    }

    public void setGoods(String good) {
        switch (good) {
            case "Potion": {
                Levels level = Levels.valueOf(getLevel());
                this.setHealthPoints(level.getHealthPoints());
                System.out.println(String.format("Здоровье восстановлено! Теперь %d", this.getHealthPoints()));
                break;
            }
            default: {}
        }
    }

    private void setCharacteristics(int newLevel) {
        Levels level = Levels.valueOf(newLevel);
        this.setHealthPoints(level.getHealthPoints());
        this.setDexterity(level.getDexterity());
        this.setStrength(level.getStrength());
    }

    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, healthPoints);
    }
}
