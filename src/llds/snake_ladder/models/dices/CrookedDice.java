package llds.snake_ladder.models.dices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrookedDice implements Dice {
    List<Integer> faceValues;

    public CrookedDice() {
        faceValues = new ArrayList<>();
        faceValues.add(1);
        faceValues.add(3);
        faceValues.add(5);
    }
    public Integer spinTheDice() {
        // get a random number
        Random random = new Random();
        int minValue = 0, maxValue = faceValues.size() - 1;
        Integer rinteger =  random.nextInt(maxValue - minValue) + minValue;
        return faceValues.get(rinteger);
    }
}
