package AbstractMatter;

import Game.MatterPanels.DescriptionPanelTerrainStats;
import Game.View.AbstractDescriptionPanel;
import GameElements.AbstractMatter;
import java.io.Serializable;

public class Terrain extends AbstractMatter implements Serializable {
    public float movementModifier;
    public float attackModifier;
    public float defenseModifier;

    public int food;
    public int production;
    public int economy;

    public int neighborModifier;

    public boolean passable;
    public boolean water;

    @Override
    public AbstractDescriptionPanel getDescription() {
        return new DescriptionPanelTerrainStats(this);
    }
    
    public void neighborize(int newOffset)
    {
        this.imageOffset.x = newOffset;
        return;
    }

}
