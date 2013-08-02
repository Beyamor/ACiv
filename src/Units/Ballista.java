package Units;

import AbstractMatter.Unit;



public class Ballista extends Unit implements Stats{

    public Ballista(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Ballista_Offset;

        this.Attack =   Ballista_Attack;
        this.Defense =  Ballista_Defense;
        this.Movement = Ballista_Movement;
        this.Health =   Ballista_Health;
        this.Production = Ballista_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     Ballista_Type;
        this.subtype =  Ballista_Subtype;

        return;
    }

}
