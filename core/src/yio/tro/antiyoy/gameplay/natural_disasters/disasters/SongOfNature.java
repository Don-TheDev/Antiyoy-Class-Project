package yio.tro.antiyoy.gameplay.natural_disasters.disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.Obj;
import yio.tro.antiyoy.gameplay.natural_disasters.Disaster;

public class SongOfNature extends Disaster
{


    public SongOfNature(String name, int radius, Hex hex)
    {
        super(name, radius, hex);
    }


    @Override
    public void execute(FieldManager fieldManager)
    {
        System.out.println("Nature is singing at " + hex.pos);

        spawnTree(fieldManager, hex);

        Hex nextHex; // hex in direction
        for (int direction = 0; direction < 6; direction++)
        {
            nextHex = fieldManager.adjacentHex(hex, direction);

            spawnTree(fieldManager, nextHex);
        }

        fieldManager.sayDisaster(this);

    }


    private void spawnTree(FieldManager fieldManager, Hex hex)
    {
        if (hex.objectInside == Obj.EMPTY)
        {
            int spawnNum = fieldManager.gameController.random.nextInt(2);
            if (spawnNum == 0)
            {
                fieldManager.spawnTree(hex);
            }
        }
    }

    @Override
    public String toString() {
        return "Song Of Nature spawned a tree";
    }
}
