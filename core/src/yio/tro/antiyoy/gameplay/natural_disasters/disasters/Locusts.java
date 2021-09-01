package yio.tro.antiyoy.gameplay.natural_disasters.disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.natural_disasters.Disaster;

public class Locusts extends Disaster {


    public Locusts(String name, int radius, Hex hex) {
        super(name, radius, hex);
    }

    @Override
    public void execute(FieldManager fieldManager) {
        System.out.println("Locusts are attacking at " + hex.pos);
        destroyFarm(fieldManager, hex);

        Hex nextHex; // hex in direction
        for(int direction = 0; direction < 6; direction++){
            nextHex = fieldManager.adjacentHex(hex,direction);

            destroyFarm(fieldManager, nextHex);
        }

        //fieldManager.sayDisaster(this);

    }

    private void destroyFarm(FieldManager fieldManager, Hex hex) {
        if (hex.containsFarm()) {
            fieldManager.cleanOutHex(hex);
        }
    }

    @Override
    public String toString() {
        return "Locusts attacked a farm";
    }
}
