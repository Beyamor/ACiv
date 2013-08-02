package Units;

public enum Type {
    
    AIR("Air"),
    WATER("Water"),

    WORKER("Worker"),

    SETTLER("Settler"),


    RANGED("Ranged"),
    MELEE("Melee"),
    MOUNTED("Mounted"),
    SIEGE("Siege");

    private String name;

    Type(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

}
