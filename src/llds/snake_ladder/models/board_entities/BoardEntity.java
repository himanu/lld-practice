package llds.snake_ladder.models.board_entities;

public abstract class BoardEntity {
    int startPos;
    int endPos;

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public abstract int getNextPos(int position);

}
