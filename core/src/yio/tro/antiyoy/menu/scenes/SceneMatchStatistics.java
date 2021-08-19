package yio.tro.antiyoy.menu.scenes;

import yio.tro.antiyoy.SettingsManager;
import yio.tro.antiyoy.gameplay.MatchStatistics;
import yio.tro.antiyoy.menu.Animation;
import yio.tro.antiyoy.menu.ButtonYio;
import yio.tro.antiyoy.menu.MenuControllerYio;
import yio.tro.antiyoy.menu.behaviors.Reaction;
import yio.tro.antiyoy.stuff.GraphicsYio;

public class SceneMatchStatistics extends AbstractScene{


    private ButtonYio replayButton;
    private Reaction backReaction;


    public SceneMatchStatistics(MenuControllerYio menuControllerYio) {
        super(menuControllerYio);

        backReaction = new Reaction() {
            @Override
            public void perform(ButtonYio buttonYio) {
                Scenes.sceneAfterGameMenu.create();
            }
        };
    }


    public void create(MatchStatistics matchStatistics) {
        menuControllerYio.beginMenuCreation();

        menuControllerYio.getYioGdxGame().beginBackgroundChange(0, false, true);

        menuControllerYio.spawnBackButton(111, backReaction);

        ButtonYio textPanel = buttonFactory.getButton(generateRectangle(0.05, 0.1, 0.9, 0.7), 112, null);
        textPanel.cleatText();
        textPanel.addTextLine(getString("statistics"));
        textPanel.addTextLine(getString("turns_made") + ": " + matchStatistics.turnsMade);
        textPanel.addTextLine(getString("units_died") + ": " + matchStatistics.unitsDied);
        textPanel.addTextLine(getString("units_produced") + ": " + matchStatistics.unitsProduced);
        textPanel.addTextLine(getString("money_spent") + ": " + matchStatistics.moneySpent);
        textPanel.addTextLine(getString("time") + ": " + matchStatistics.getTimeString());
        for (int i = 0; i < 10; i++) {
            textPanel.addTextLine("");
        }
        menuControllerYio.getButtonRenderer().renderButton(textPanel);
        textPanel.setTouchable(false);
        textPanel.setAnimation(Animation.from_center);

        createReplayButton();

        menuControllerYio.endMenuCreation();
    }


    private void createReplayButton() {
        if (!SettingsManager.replaysEnabled) return;

        replayButton = buttonFactory.getButton(generateRectangle(0.55, 0.9, 0.4, 0.07), 113, getString("replay"));
        replayButton.setReaction(Reaction.rbStartInstantReplay);
        replayButton.setAnimation(Animation.up);
        replayButton.setTouchOffset(0.05f * GraphicsYio.width);
    }


    @Override
    public void create() {

    }
}