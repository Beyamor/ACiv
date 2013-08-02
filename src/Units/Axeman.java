package Units;

import AbstractMatter.Unit;


public class Axeman extends Unit implements Stats{

    public Axeman(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Axeman_Offset;

        this.Attack =   Axeman_Attack;
        this.Defense =  Axeman_Defense;
        this.Movement = Axeman_Movement;
        this.Health =   Axeman_Health;
        this.Production = Axeman_Production;
        
        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     Axeman_Type;
        this.subtype =  Axeman_Subtype;

        return;
    }

}
