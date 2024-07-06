package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameMain {

    public static void main(String[] args) {
        GameController controller = new GameController(new BufferedReader(new InputStreamReader(System.in)));
        controller.run();
    }
}
