package Units;

import AbstractMatter.Unit;


public class Archer extends Unit implements Stats{

    public Archer(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Archer_Offset;

        this.Attack = Archer_Attack;
        this.Defense = Archer_Defense;
        this.Movement = Archer_Movement;
        this.Health = Archer_Health;
        this.Production = Archer_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type = Archer_Type;
        this.subtype = Archer_Subtype;

        return;
    }

}
