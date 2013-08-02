package Units;

import AbstractMatter.Unit;

public class Bearman extends Unit implements Stats{

    public Bearman(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Bearman_Offset;

        this.Attack =   Bearman_Attack;
        this.Defense =  Bearman_Defense;
        this.Movement = Bearman_Movement;
        this.Health =   Bearman_Health;
        this.Production = Bearman_Production;

        this.MP = (float)Movement;
        this.HP = Health;
        
        this.type =     Bearman_Type;
        this.subtype =  Bearman_Subtype;

        return;
    }

}
