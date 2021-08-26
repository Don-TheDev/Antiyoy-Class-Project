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

    }
}
