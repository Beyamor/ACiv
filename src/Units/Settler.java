package Units;

import AbstractMatter.Unit;
import Game.MatterPanels.ActionPanelBlank;
import Game.MatterPanels.ActionPanelSettler;
import Game.View.AbstractActionPanel;


public class Settler extends Unit implements Stats{

    public Settler(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Settler_Offset;

        this.Attack = Settler_Attack;
        this.Defense = Settler_Defense;
        this.Movement = Settler_Movement;
        this.Health = Settler_Health;
        this.Production = Settler_Production;

        this.MP = (float)Movement;
        this.HP = Health;
        
        this.type = Settler_Type;
        this.subtype = Settler_Subtype;

        return;
    }

        // Method for returning action
    @Override
    public AbstractActionPanel getAction() {
        if ( owner.getSelected() ) {
            return new ActionPanelSettler();
        } else {
            return new ActionPanelBlank();
        }
    }

}
