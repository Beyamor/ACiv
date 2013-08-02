package Units;

import AbstractMatter.Unit;


public class Warrior extends Unit implements Stats{

    public Warrior(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Warrior_Offset;

        this.Attack =   Warrior_Attack;
        this.Defense =  Warrior_Defense;
        this.Movement = Warrior_Movement;
        this.Health =   Warrior_Health;
        this.Production = Warrior_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     Warrior_Type;
        this.subtype =  Warrior_Subtype;

        return;
    }

}
