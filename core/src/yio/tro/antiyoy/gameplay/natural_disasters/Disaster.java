package yio.tro.antiyoy.gameplay.natural_disasters;

import yio.tro.antiyoy.gameplay.FieldManager;
import yio.tro.antiyoy.gameplay.Hex;

public abstract class Disaster {
    protected final String name;
    protected final int radius;
    protected final Hex hex;

    public String getName() {
        return name;
    }

    public Disaster(String name, int radius, Hex hex){
        this.name = name;
        this.radius = radius;
        this.hex = hex;
    }

    public abstract void execute(FieldManager fieldManager);
}