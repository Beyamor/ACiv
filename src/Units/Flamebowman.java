package Units;

import AbstractMatter.Unit;

public class Flamebowman extends Unit implements Stats{

    public Flamebowman(){
        this.imageTag = imageTag.ALIEN_UNITS;

        this.imageOffset = Flamebowman_Offset;

        this.Attack =   Flamebowman_Attack;
        this.Defense =  Flamebowman_Defense;
        this.Movement = Flamebowman_Movement;
        this.Health =   Flamebowman_Health;
        this.Production = Flamebowman_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     Flamebowman_Type;
        this.subtype =  Flamebowman_Subtype;

        return;
    }

}
