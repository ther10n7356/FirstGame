package game.io;

import game.Goods;

public interface Seller {
    String sell (String goodId, AbstractCharacter hero);

    void printGoods();
}
