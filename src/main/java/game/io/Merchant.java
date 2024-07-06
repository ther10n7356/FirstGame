package game.io;

import game.Goods;

public class Merchant implements Seller{

    @Override
    public String sell(String goodName, AbstractCharacter hero) {
        Goods goods = Goods.valueOfName(goodName);

        String result = "";
        if (goods != null) {
            if (hero.getGold() >= goods.getCost()) {
                result = goods.getMessage();
                hero.setGold(hero.getGold() - goods.getCost());
                System.out.println(String.format("Вы приобрели %s.", result));
            } else {
                System.out.println("Недостаточно золота!");
            }
        }

        return result;
    }

    @Override
    public void printGoods() {
        System.out.println("У торговца можно купить:");
        for (Goods goods: Goods.values()) {
            System.out.println(String.format("%s стоимость %s", goods.getName(), goods.getCost()));
        }
    }
}
