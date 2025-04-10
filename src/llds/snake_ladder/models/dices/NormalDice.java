package llds.snake_ladder.models.dices;

import java.util.Random;

public class NormalDice implements Dice {
    int maxSize;
    public  NormalDice(int size) {
        this.maxSize = size;
    }

    public Integer spinTheDice() {
        Random random = new Random();
        return random.nextInt(maxSize - 1) + 1;
    }
}
