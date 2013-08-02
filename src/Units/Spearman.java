package Units;

import AbstractMatter.Unit;

public class Spearman extends Unit implements Stats{

    public Spearman(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Spearman_Offset;

        this.Attack =   Spearman_Attack;
        this.Defense =  Spearman_Defense;
        this.Movement = Spearman_Movement;
        this.Health =   Spearman_Health;
        this.Production = Spearman_Production;

        this.MP = (float)Movement;
        this.HP = Health;
        
        this.type =     Spearman_Type;
        this.subtype =  Spearman_Subtype;

        return;
    }

}
