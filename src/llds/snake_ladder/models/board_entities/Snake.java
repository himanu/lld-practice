package llds.snake_ladder.models.board_entities;

public class Snake extends BoardEntity {
    Integer id;
    public Snake(Integer id, Integer startPos, Integer endPos) {
        this.id = id;
        this.startPos = startPos;
        this.endPos = endPos;
    }




    @Override
    public int getNextPos(int position) {
        if (endPos == position)
            return startPos;
        return position;
    }
}

// 4
// now we moved user by 4
// pos + 4

// if (pos + 4) is head of Snake
//

// if (pos + 4) is bottom of ladder
//


// Game -> instance of GB

// GameBoard
// to return the new Position

//