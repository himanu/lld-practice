package llds.snake_ladder.models;


import llds.snake_ladder.models.board_entities.Ladder;
import llds.snake_ladder.models.board_entities.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameBoard {
    int sizeOfBoard;

    List<Snake> snakes;
    List<Ladder> ladders;

    public GameBoard(int size) {
        this.sizeOfBoard = size;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }

    public void addSnake(int id, int startPos, int endPos) {
        // todo: validation logic to avoid duplicates
        snakes.add(new Snake(id, startPos, endPos));
    }

    public void addLadder(int id, int startPos, int endPos) {
        // todo: validation logic to avoid duplicates
        ladders.add(new Ladder(id, startPos, endPos));
    }

    public Integer getFinalPosition(Integer currentPosition, Integer steps) {
        int position = currentPosition + steps;
        if (position > sizeOfBoard)
            return position;

        // check for snake head
        Optional<Snake> snakeOptional = snakes.stream().
                filter((snake) -> snake.getEndPos() == position)
                .findFirst();

        if (snakeOptional.isPresent()) {
            System.out.println("Bit by the snake");
            return snakeOptional.get().getNextPos(position);
        }

        // check for ladder bottom
        Optional<Ladder> ladderOptional = ladders.stream().
                filter((ladder) -> ladder.getLadderStartPos() == position)
                .findFirst();

        if (ladderOptional.isPresent()) {
            System.out.println("Moved up by Ladder");
            return ladderOptional.get().getNextPos(position);
        }

        return  position;
    }

    public Integer getSizeOfBoard() {
        return sizeOfBoard;
    }


}
