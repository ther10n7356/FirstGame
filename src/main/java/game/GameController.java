package game;

import game.io.*;

import java.io.BufferedReader;
import java.io.IOException;

public class GameController {
    private final BufferedReader br;

    private AbstractCharacter player = null;
    private final Seller merchant;

    private final BattleScene battleScene;

    public GameController(BufferedReader br) {
        this.br = br;
        this.battleScene = new BattleScene();
        this.merchant = new Merchant();
    }

    public void run() {
        System.out.println("Введите имя персонажа:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0
            );
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", player.getName()));

            printNavigation();
        }

        switch (string) {
            case "1": {
                merchant.printGoods();
                break;
            }
            case "2": {
                commitFight();
                break;
            }
            case "3": {
                System.exit(1);
                break;
            }
            case "potion": {
                commitDeal(string);
            }
            case "да": {
                command("2");
                break;
            }
            case "нет": {
                printNavigation();
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getXp(), player.getGold(), player.getHealthPoints()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {
                player = null;
            }
        });
    }

    private void commitDeal(String goodName) {
        try {
            String message = merchant.sell(goodName, player);
            if (!message.isEmpty()) {
                System.out.println(message);
            } else {
                System.out.println("Сделка не удалась!");
            }
            System.out.println("Желаете отправиться в поход или остаться в городе? (да/нет)");
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AbstractCharacter createMonster() {
        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }
}
