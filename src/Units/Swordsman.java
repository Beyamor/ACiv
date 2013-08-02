package Units;

import AbstractMatter.Unit;

public class Swordsman extends Unit implements Stats{

    public Swordsman(){
        this.imageTag = imageTag.ALIEN_UNITS;

        this.imageOffset = Swordsman_Offset;

        this.Attack =   Swordsman_Attack;
        this.Defense =  Swordsman_Defense;
        this.Movement = Swordsman_Movement;
        this.Health =   Swordsman_Health;
        this.Production = Swordsman_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     Swordsman_Type;
        this.subtype =  Swordsman_Subtype;

        return;
    }

}
