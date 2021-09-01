package yio.tro.antiyoy.menu.behaviors.menu_creation;

import yio.tro.antiyoy.YioGdxGame;
import yio.tro.antiyoy.gameplay.SelectionTipType;
import yio.tro.antiyoy.menu.ButtonYio;
import yio.tro.antiyoy.menu.behaviors.Reaction;

public class RbDisasters extends Reaction {

    int chain[];


    public RbDisasters() {
        chain = new int[]{
                SelectionTipType.EARTHQUAKE,
                SelectionTipType.LOCUSTS,
                SelectionTipType.ACID_RAIN,
                SelectionTipType.SONG_OF_NATURE
        };
    }


    @Override
    public void perform(ButtonYio buttonYio) {
        if (!getGameController(buttonYio).selectionManager.isSomethingSelected()) {
            YioGdxGame.say("detected strange bug in RbDisasters");
            return;
        }

        int tipType = getGameController(buttonYio).selectionManager.getTipType();
        int newTipType = -1;

        for (int i = 0; i < chain.length; i++) {
            if (tipType == chain[i]) {
                if (i == chain.length - 1) {
                    newTipType = chain[0];
                } else {
                    newTipType = chain[i + 1];
                }
            }
        }

        if (newTipType == -1) {
            newTipType = chain[0]; // default
        }

        tipType = newTipType;

        getGameController(buttonYio).selectionManager.awakeTip(tipType);
        getGameController(buttonYio).detectAndShowMoveZoneForDisasters(5);
    }
}
