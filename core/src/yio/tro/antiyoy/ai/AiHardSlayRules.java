package yio.tro.antiyoy.ai;

import yio.tro.antiyoy.gameplay.GameController;


public class AiHardSlayRules extends ArtificialIntelligence {

    public AiHardSlayRules(GameController gameController, int fraction) {
        super(gameController, fraction);
    }


    @Override
    public void makeMove() {
        moveUnits();
        spendMoneyAndMergeUnits();
        moveAfkUnits();
    }
}
