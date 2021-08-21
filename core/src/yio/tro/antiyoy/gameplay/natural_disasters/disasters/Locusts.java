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
        if (hex.objectInside == 6) {
            hex.objectInside = 0;
        }
        for(int i = 0; i < 6; i++){
            if(fieldManager.adjacentHex(hex, i).objectInside == 6){
                fieldManager.adjacentHex(hex, i).objectInside = 0;
            }
        }
    }
}
