package Units;

import AbstractMatter.Unit;

public class Crossbowman extends Unit implements Stats{

    public Crossbowman(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Crossbowman_Offset;

        this.Attack =   Crossbowman_Attack;
        this.Defense =  Crossbowman_Defense;
        this.Movement = Crossbowman_Movement;
        this.Health =   Crossbowman_Health;
        this.Production = Crossbowman_Production;

        this.MP = (float)Movement;
        this.HP = Health;
        
        this.type =     Crossbowman_Type;
        this.subtype =  Crossbowman_Subtype;

        return;
    }

}
