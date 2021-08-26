package yio.tro.antiyoy.gameplay.natural_disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;
import yio.tro.antiyoy.gameplay.natural_disasters.disasters.AcidRain;
import yio.tro.antiyoy.gameplay.natural_disasters.disasters.Earthquake;
import yio.tro.antiyoy.gameplay.natural_disasters.disasters.Locusts;
import yio.tro.antiyoy.gameplay.natural_disasters.disasters.SongOfNature;

import java.util.Random;

public class DisasterFactory {
    private static FieldManager fieldManager;

    public static Disaster create(Disasters d){
        Hex hex = null;
        Random random = new Random();
        while(hex == null){
//            int x = fieldManager.gameController.random.nextInt(fieldManager.fWidth),
//                    y = fieldManager.gameController.random.nextInt(fieldManager.fHeight);
            hex = fieldManager.getRandomActivehex();
        }
        switch(d){
            case ACID_RAIN:
                return new AcidRain("Acid Rain", 2, hex);
            case EARTHQUAKE:
                return new Earthquake("Earthquake", 2, hex);
            case LOCUSTS:
                return new Locusts("Locusts", 2, hex);
            case SONG_OF_NATURE:
                return new SongOfNature("Song of Nature", 2, hex);
        }
        return null;
    }

    public static void setFieldManager(FieldManager fieldManager){
        DisasterFactory.fieldManager = fieldManager;
    }
}
