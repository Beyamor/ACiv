package Units;

import AbstractMatter.Unit;

public class Armoredbear extends Unit implements Stats{

    public Armoredbear(){
        this.imageTag = imageTag.ALIEN_UNITS;

        this.imageOffset = Armoredbear_Offset;

        this.Attack =   Armoredbear_Attack;
        this.Defense =  Armoredbear_Defense;
        this.Movement = Armoredbear_Movement;
        this.Health =   Armoredbear_Health;
        this.Production = Armoredbear_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     Armoredbear_Type;
        this.subtype =  Armoredbear_Subtype;

        return;
    }

}
