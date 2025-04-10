package llds.snake_ladder.models;

import llds.snake_ladder.dice_factory.DiceFactoryImpl;
import llds.snake_ladder.enums.DiceType;
import llds.snake_ladder.enums.GameStatus;
import llds.snake_ladder.models.dices.Dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    GameBoard gameBoard;
    GameStatus gameStatus;
    Map<String, Integer> userPositions;
    List<String> users;
    Dice dice;

    public Game(GameBoard gameBoard, DiceType diceType) {
        this.gameBoard = gameBoard;
        gameStatus = GameStatus.NOT_STARTED;
        userPositions = new HashMap<>();
        this.dice = new DiceFactoryImpl().getDice(diceType);
        users = new ArrayList<>();
    }

    public void addUser(String userId) {
        if (gameStatus == GameStatus.NOT_STARTED) {
            userPositions.put(userId, 0);
            users.add(userId);
        }
        else
            System.out.println("Game has finished or in progress");
    }

    public void playTheGame() {
        gameStatus = GameStatus.IN_PROGRESS;
        Integer noOfUsers = users.size();
        Integer currentUserIdx = 0;
        while(gameStatus == GameStatus.IN_PROGRESS) {
            String userId = users.get(currentUserIdx);
            System.out.println("Turn " + userId);
            playYourTurn(userId);

            System.out.println("============");
            currentUserIdx += 1;
            if (currentUserIdx == noOfUsers)
                currentUserIdx = 0;
        }
    }

    public void playYourTurn(String userId) {
        if (!userPositions.containsKey(userId)) {
            System.out.println("Invalid User");
            return;
        }
        if (gameStatus == GameStatus.ENDED) {
            System.out.println("Game has finished");
            return;
        }
        if (gameStatus == GameStatus.NOT_STARTED)
            gameStatus = GameStatus.IN_PROGRESS;

        Integer currentPosition = userPositions.get(userId);
        Integer diceValue = dice.spinTheDice();

        Integer newPosition = gameBoard.getFinalPosition(currentPosition, diceValue);
        System.out.println("dive value " + diceValue + " currentPos " + currentPosition + " finalPosition " + newPosition);
        userPositions.put(userId, newPosition);
        if (isWinningPosition(newPosition)) {
            System.out.println("Hurrah! you won the game");
            gameStatus = GameStatus.ENDED;
            return;
        }

    }


    private Boolean isWinningPosition(Integer position) {
        return  position > gameBoard.getSizeOfBoard();
    }
}
