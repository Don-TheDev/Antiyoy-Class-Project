package yio.tro.antiyoy.gameplay.natural_disasters.disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.natural_disasters.Disaster;

public class Earthquake extends Disaster
{
    public Earthquake(String name, int radius, Hex hex)
    {
        super(name, radius, hex);
    }

    @Override
    public void execute(FieldManager fieldManager)
    {
        System.out.println("The earth is dancing at " + hex.pos);
        destroyTower(fieldManager, hex);


        Hex nextHex; // hex in direction
        for(int direction = 0; direction < 6; direction++){
            nextHex = fieldManager.adjacentHex(hex,direction);

            destroyTower(fieldManager, nextHex);
        }

  //      fieldManager.sayDisaster(this);

    }

    private void destroyTower(FieldManager fieldManager, Hex hex) {
        if (hex.containsTower()) {
            fieldManager.cleanOutHex(hex);
        }
    }

    @Override
    public String toString() {
        return "An earthquake occurred";
    }
}
