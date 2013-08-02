package Units;

import AbstractMatter.Unit;

public class BearWarrior extends Unit implements Stats{

    public BearWarrior(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = BearWarrior_Offset;

        this.Attack =   BearWarrior_Attack;
        this.Defense =  BearWarrior_Defense;
        this.Movement = BearWarrior_Movement;
        this.Health =   BearWarrior_Health;
        this.Production = BearWarrior_Production;

        this.MP = (float)Movement;
        this.HP = Health;

        this.type =     BearWarrior_Type;
        this.subtype =  BearWarrior_Subtype;

        return;
    }

}
