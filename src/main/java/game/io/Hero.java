package game.io;

public class Hero extends AbstractCharacter{

    public Hero(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold, 1);
    }
}
