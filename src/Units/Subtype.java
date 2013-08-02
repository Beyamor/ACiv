package Units;

public enum Subtype {
    
    HEAVY("Heavy"),
    ARMORED("Armored"),
    LIGHT("Light"),
    TRANSPORT("Transport");

    private String name;

    Subtype(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
