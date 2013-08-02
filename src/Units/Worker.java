package Units;

import AbstractMatter.Unit;
import Game.MatterPanels.ActionPanelBlank;
import Game.MatterPanels.ActionPanelWorker;
import Game.View.AbstractActionPanel;

public class Worker extends Unit implements Stats{

    public Worker(){
        this.imageTag = imageTag.ALIEN_UNITS;
        
        this.imageOffset = Worker_Offset;

        this.Attack =   Worker_Attack;
        this.Defense =  Worker_Defense;
        this.Movement = Worker_Movement;
        this.Health =   Worker_Health;
        this.Production = Worker_Production;

        this.MP = (float)Movement;
        this.HP = Health;
        
        this.type =     Worker_Type;
        this.subtype =  Worker_Subtype;

        return;
    }

        // Method for returning action
    @Override
    public AbstractActionPanel getAction() {
        if ( owner.getSelected() ) {
            return new ActionPanelWorker();
        } else {
            return new ActionPanelBlank();
        }
    }

}
