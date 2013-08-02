package AbstractMatter;

import Game.MatterPanels.ActionPanelBlank;
import Game.MatterPanels.ActionPanelCity;
import Game.MatterPanels.DescriptionPanelBlank;
import Game.MatterPanels.DescriptionPanelCityAll;
import Game.MatterPanels.DescriptionPanelCityBuild;
import Game.MatterPanels.DescriptionPanelCityEnemy;
import Game.MatterPanels.DescriptionPanelCityStats;
import Game.View.AbstractActionPanel;
import Game.View.AbstractDescriptionPanel;
import GameElements.AbstractMatter;
import GameElements.Player;
import GameElements.Tile;
import java.io.Serializable;

public class City extends AbstractMatter implements Serializable {

    public int Production;
    public int PP;

    public int stage;

    String name = "City";

    public City() {

    }

    public void place(Player player, Tile tile){
        this.owner = player;
        this.tile = tile;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void produce(int production)
    {
        this.PP -= production;
    }

    // Method for returning action
    @Override
    public AbstractActionPanel getAction() {
        if ( owner.getSelected() ) {
            return new ActionPanelBlank();
        } else {
            return new ActionPanelBlank();
        }
        
    }

    // Method for returning description
    @Override
    public AbstractDescriptionPanel getDescription() {
        if ( owner.getSelected() ) {

            return new DescriptionPanelCityAll( this );
            /*
            switch (state) {
                case normal:
                    return getStatsPanel();
                case build:
                    return getBuildPanel();
            }

            return new DescriptionPanelBlank();*/
        } else {
            return new DescriptionPanelCityEnemy( this );
        }
    }

    // Different descriptions
    private AbstractDescriptionPanel getStatsPanel() {
        return new DescriptionPanelCityStats(this);
    }

    private AbstractDescriptionPanel getBuildPanel() {
        return new DescriptionPanelCityBuild(this);
    }

    public void setStage(int newStage) {
        this.stage = newStage;
    }

    public int getStage() {
        return this.stage;
    }
}
