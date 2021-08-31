package yio.tro.antiyoy.gameplay.natural_disasters.disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.natural_disasters.Disaster;

public class AcidRain extends Disaster
{
    public AcidRain(String name, int radius, Hex hex)
    {
        super(name, radius, hex);
    }

    @Override
    public void execute(FieldManager fieldManager)
    {
        System.out.println("Lemons are falling at " + hex.pos);
        destroyUnitOrTree(fieldManager, hex);


        Hex nextHex; // hex in direction
        for(int direction = 0; direction < 6; direction++){

            nextHex = fieldManager.adjacentHex(hex,direction);

            destroyUnitOrTree(fieldManager, nextHex);
        }

        fieldManager.sayDisaster(this);

    }

    private void destroyUnitOrTree(FieldManager fieldManager, Hex hex) {
        if (hex.hasUnit()) {
            fieldManager.killUnitByStarvation(hex);
        }
        else if (hex.containsTree()) {
            fieldManager.cleanOutHex(hex);
        }
    }

    @Override
    public String toString() {
        return "Acid Rain hits";
    }
}

