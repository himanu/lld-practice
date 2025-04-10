package llds.snake_ladder;

import llds.snake_ladder.enums.DiceType;
import llds.snake_ladder.models.Game;
import llds.snake_ladder.models.GameBoard;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SnakeLadderGame {
    public static void startGame() {
        // ladder and snake

        GameBoard gameBoard = new GameBoard(100);
        gameBoard.addLadder(0, 5, 25);
        gameBoard.addLadder(1, 30, 99);
        gameBoard.addSnake(0, 15, 30);
        gameBoard.addSnake(1, 7, 55);


        Game game = new Game(gameBoard, DiceType.NORMAL);

        game.addUser("1");
        game.addUser("2");

        game.playTheGame();




    }
}
