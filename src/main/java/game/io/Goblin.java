package game.io;

public class Goblin extends AbstractCharacter {
    public Goblin(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold, 1);
    }
}
