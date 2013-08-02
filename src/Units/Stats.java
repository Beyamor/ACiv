package Units;

import java.awt.Point;

public interface Stats {

    //Worker
    public final int        Worker_Health       = 100;
    public final int        Worker_Attack       = 75;
    public final int        Worker_Defense      = 50;
    public final int        Worker_Movement     = 5;
    public final Point      Worker_Offset       = new Point(0,0);
    public final Type       Worker_Type         = Type.WORKER;
    public final Subtype    Worker_Subtype      = Subtype.LIGHT;
    public final int        Worker_Production   = 200;

    //Settler
    public final int        Settler_Health      = 100;
    public final int        Settler_Attack      = 50;
    public final int        Settler_Defense     = 50;
    public final int        Settler_Movement    = 5;
    public final Point      Settler_Offset      = new Point(80,0);
    public final Type       Settler_Type        = Type.SETTLER;
    public final Subtype    Settler_Subtype     = Subtype.LIGHT;
    public final int        Settler_Production   = 300;

    //Warrior
    public final int        Warrior_Health       = 200;
    public final int        Warrior_Attack       = 100;
    public final int        Warrior_Defense      = 50;
    public final int        Warrior_Movement     = 3;
    public final Point      Warrior_Offset       = new Point(160,0);
    public final Type       Warrior_Type         = Type.MELEE;
    public final Subtype    Warrior_Subtype      = Subtype.LIGHT;
    public final int        Warrior_Production   = 100;

    //Spearman
    public final int        Spearman_Health       = 150;
    public final int        Spearman_Attack       = 100;
    public final int        Spearman_Defense      = 50;
    public final int        Spearman_Movement     = 3;
    public final Point      Spearman_Offset       = new Point(240,0);
    public final Type       Spearman_Type         = Type.MELEE;
    public final Subtype    Spearman_Subtype      = Subtype.LIGHT;
    public final int        Spearman_Production   = 100;

    //Archer
    public final int        Archer_Health       = 150;
    public final int        Archer_Attack       = 100;
    public final int        Archer_Defense      = 50;
    public final int        Archer_Movement     = 4;
    public final Point      Archer_Offset       = new Point(320,0);
    public final Type       Archer_Type         = Type.RANGED;
    public final Subtype    Archer_Subtype      = Subtype.LIGHT;
    public final int        Archer_Production   = 100;

    //Bearman (bear sidecar)
    public final int        Bearman_Health       = 300;
    public final int        Bearman_Attack       = 150;
    public final int        Bearman_Defense      = 100;
    public final int        Bearman_Movement     = 5;
    public final Point      Bearman_Offset       = new Point(400,0);
    public final Type       Bearman_Type         = Type.MOUNTED;
    public final Subtype    Bearman_Subtype      = Subtype.LIGHT;
    public final int        Bearman_Production   = 200;

    //Junk (Cheap boat)
    public final int        Junk_Health       = 100;
    public final int        Junk_Attack       = 50;
    public final int        Junk_Defense      = 50;
    public final int        Junk_Movement     = 5;
    public final Point      Junk_Offset       = new Point(480,0);
    public final Type       Junk_Type         = Type.WATER;
    public final Subtype    Junk_Subtype      = Subtype.LIGHT;
    public final int        Junk_Production   = 200;


    //Crossbowman
    public final int        Crossbowman_Health       = 300;
    public final int        Crossbowman_Attack       = 150;
    public final int        Crossbowman_Defense      = 100;
    public final int        Crossbowman_Movement     = 4;
    public final Point      Crossbowman_Offset       = new Point(560,0);
    public final Type       Crossbowman_Type         = Type.RANGED;
    public final Subtype    Crossbowman_Subtype      = Subtype.HEAVY;
    public final int        Crossbowman_Production   = 300;


    //Bear warrior
    public final int        BearWarrior_Health       = 500;
    public final int        BearWarrior_Attack       = 200;
    public final int        BearWarrior_Defense      = 100;
    public final int        BearWarrior_Movement     = 4;
    public final Point      BearWarrior_Offset       = new Point(640,0);
    public final Type       BearWarrior_Type         = Type.MOUNTED;
    public final Subtype    BearWarrior_Subtype      = Subtype.HEAVY;
    public final int        BearWarrior_Production   = 300;


    //Ballista
    public final int        Ballista_Health       = 150;
    public final int        Ballista_Attack       = 300;
    public final int        Ballista_Defense      = 0;
    public final int        Ballista_Movement     = 5;
    public final Point      Ballista_Offset       = new Point(720,0);
    public final Type       Ballista_Type         = Type.SIEGE;
    public final Subtype    Ballista_Subtype      = Subtype.LIGHT;
    public final int        Ballista_Production   = 300;


    //Axeman
    public final int        Axeman_Health       = 350;
    public final int        Axeman_Attack       = 300;
    public final int        Axeman_Defense      = 100;
    public final int        Axeman_Movement     = 5;
    public final Point      Axeman_Offset       = new Point(800,0);
    public final Type       Axeman_Type         = Type.MELEE;
    public final Subtype    Axeman_Subtype      = Subtype.HEAVY;
    public final int        Axeman_Production   = 400;

    //Flamebowma
    public final int        Flamebowman_Health       = 300;
    public final int        Flamebowman_Attack       = 250;
    public final int        Flamebowman_Defense      = 100;
    public final int        Flamebowman_Movement     = 5;
    public final Point      Flamebowman_Offset       = new Point(880,0);
    public final Type       Flamebowman_Type         = Type.RANGED;
    public final Subtype    Flamebowman_Subtype      = Subtype.HEAVY;
    public final int        Flamebowman_Production   = 400;

    //Swordsman
    public final int        Swordsman_Health       = 200;
    public final int        Swordsman_Attack       = 250;
    public final int        Swordsman_Defense      = 50;
    public final int        Swordsman_Movement     = 4;
    public final Point      Swordsman_Offset       = new Point(960,0);
    public final Type       Swordsman_Type         = Type.MELEE;
    public final Subtype    Swordsman_Subtype      = Subtype.LIGHT;
    public final int        Swordsman_Production   = 300;

    //Armoredbear
    public final int        Armoredbear_Health       = 600;
    public final int        Armoredbear_Attack       = 300;
    public final int        Armoredbear_Defense      = 100;
    public final int        Armoredbear_Movement     = 5;
    public final Point      Armoredbear_Offset       = new Point(1040,0);
    public final Type       Armoredbear_Type         = Type.MOUNTED;
    public final Subtype    Armoredbear_Subtype      = Subtype.ARMORED;
    public final int        Armoredbear_Production   = 400;

}
