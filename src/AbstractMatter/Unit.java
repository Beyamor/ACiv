package AbstractMatter;

import Game.MatterPanels.ActionPanelBlank;
import Game.View.AbstractActionPanel;
import Game.View.AbstractDescriptionPanel;
import Game.MatterPanels.ActionPanelMilitaryUnit;
import Game.MatterPanels.DescriptionPanelUnitStats;
import Units.*;
import java.io.Serializable;
import GameElements.AbstractMatter;
import GameElements.ImageContainer;
import GameElements.ImageTag;
import GameElements.Player;
import GameElements.Tile;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Unit extends AbstractMatter implements Serializable {

    public int Production;

    public int Movement;
    public float MP;
    public int Health;
    public int HP;

    public int Attack;
    public int Defense;
    
    public Type type;
    public Subtype subtype;

    private boolean fortify;

    public void place(Player player, Tile tile){
        this.owner = player;
        this.tile = tile;
    }

    public void move(Tile dest){
        this.tile.removeUnit();     //remove reference from tile to self
        this.tile = dest;           //change move to tile
        this.tile.addUnit(this);    //add reference from new tile to self
        this.MP -= this.tile.getMovement();
    }

    //removes a unit
    public void remove(){
        this.tile.removeUnit();
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void draw(Graphics graphics, ImageContainer ic, Point ws, Point we, Point ss, Point se ){
                            graphics.drawImage(ic.getImage(this.getImageTag(),this.getOwner()),   //image
                            ws.x,ws.y,              //world start point
                            we.x,we.y,              //world end point
                            ss.x,ss.y,              //source start point
                            se.x,se.y,              //source end point
                            null);

                            int hpOffset = 0;

                            hpOffset = (int)((float)this.HP * 100/(float)this.Health);

                            Image healthBar =ic.getImage(ImageTag.HEALTH_BAR,this.getOwner());

                            healthBar = ic.colorHealth(healthBar,hpOffset);

                            graphics.drawImage(healthBar,   //image
                            ws.x + 10,ws.y,              //world start point
                            ws.x + 10 + (hpOffset * 80)/100,we.y,              //world end point
                            0,0,              //source start point
                            80,80,              //source end point
                            null);

                            if(this.fortify)
                            {
                                graphics.drawImage(ic.getImage(ImageTag.SHIELD,this.getOwner()),   //image
                                ws.x + 35,ws.y + 35,              //world start point
                                we.x - 5 ,we.y - 5,              //world end point
                                0,0,              //source start point
                                30,30,              //source end point
                            null);
                            }
                            
                            
    }

    // Method for returning action
    @Override
    public AbstractActionPanel getAction() {
        if ( owner.getSelected() ) {
            return new ActionPanelMilitaryUnit();
        } else {
            return new ActionPanelBlank();
        }
    }

    // Method for returning description
    @Override
    public AbstractDescriptionPanel getDescription() {
        return getStatsPanel();
    }

    // Different descriptions
    private AbstractDescriptionPanel getStatsPanel() {
        return new DescriptionPanelUnitStats(this);
    }

    public void setFortify(boolean fortify) {
        this.fortify = fortify;
    }

    public boolean getFortify() {
        return this.fortify;
    }

}
