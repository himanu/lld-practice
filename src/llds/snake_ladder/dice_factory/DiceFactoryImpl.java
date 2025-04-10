package llds.snake_ladder.dice_factory;


import llds.snake_ladder.enums.DiceType;
import llds.snake_ladder.models.dices.CrookedDice;
import llds.snake_ladder.models.dices.Dice;
import llds.snake_ladder.models.dices.NormalDice;

public class DiceFactoryImpl implements DiceFactory {

    @Override
    public Dice getDice(DiceType type) {
        if (type == DiceType.CROOKED)
            return new CrookedDice();
        else
            return new NormalDice(6);

    }
}
