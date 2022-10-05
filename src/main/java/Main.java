import components.*;

public class Main {

    public static void run() {
        int exitCode = 1;
        Game game;
        while(exitCode == 1) {
            game = new Game();
            exitCode = game.run();
        }
    }

    public static void main(String[] args) {
        run();
    }

}
