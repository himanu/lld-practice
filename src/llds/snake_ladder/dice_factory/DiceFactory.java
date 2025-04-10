package llds.snake_ladder.dice_factory;

import llds.snake_ladder.enums.DiceType;
import llds.snake_ladder.models.dices.Dice;

public interface DiceFactory {

    Dice getDice(DiceType type);
}
