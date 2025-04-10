package llds.snake_ladder.models.board_entities;

public class Ladder extends BoardEntity {

    public Ladder(Integer id, Integer startPos, Integer endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }
    public Integer getLadderStartPos() {
        return startPos;
    }

    @Override
    public int getNextPos(int position) {
        if (this.startPos == position)
            return endPos;
        else
            return position;
    }
}
