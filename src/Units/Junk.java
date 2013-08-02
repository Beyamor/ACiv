package Units;

import AbstractMatter.Unit;


public class Junk extends Unit implements Stats{

    public Junk(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Junk_Offset;

        this.Attack =   Junk_Attack;
        this.Defense =  Junk_Defense;
        this.Movement = Junk_Movement;
        this.Health =   Junk_Health;
        this.Production = Junk_Production;

        this.MP = (float)Movement;
        this.HP = Health;
        
        this.type =     Junk_Type;
        this.subtype =  Junk_Subtype;

        return;
    }

}
