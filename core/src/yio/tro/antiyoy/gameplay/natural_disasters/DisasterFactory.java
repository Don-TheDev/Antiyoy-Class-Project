package yio.tro.antiyoy.gameplay.natural_disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.natural_disasters.disasters.Locusts;

import java.util.Random;

public class DisasterFactory {
    private static FieldManager fieldManager;

    public Disaster create(Disasters d){
        Hex hex = null;
        Random random = new Random();
        while(hex == null){
            hex = fieldManager.getHex(random.nextInt(fieldManager.fWidth), random.nextInt(fieldManager.fHeight));
        }
        switch(d){
            case LOCUSTS:
                return new Locusts("Locusts", 2, hex);
            case ACID_RAIN:
        }
        return null;
    }

    public static void setFieldManager(FieldManager fieldManager){
        DisasterFactory.fieldManager = fieldManager;
    }
}

// Disaster = DisasterFactory.create(Disasters.LOCUSTS);