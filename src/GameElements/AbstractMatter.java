package GameElements;

import AbstractMatter.MatterStateEnum;
import Game.View.AbstractActionPanel;
import Game.View.AbstractDescriptionPanel;
import Game.MatterPanels.ActionPanelBlank;
import Game.MatterPanels.DescriptionPanelBlank;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class AbstractMatter implements Serializable {

    public Player owner;

    public ImageTag imageTag;
    public Point imageOffset;

    public MatterStateEnum state = MatterStateEnum.normal;

    public Tile tile;

    public AbstractMatter() {

    }

    public AbstractMatter(Tile tile) {
        this.tile = tile;
    }

    public ImageTag getImageTag(){
        return this.imageTag;
    }

    public Point getImageOffset(){
        return this.imageOffset;
    }

    public Player getOwner(){
        return this.owner;
    }

    public Tile getTile(){
        return this.tile;
    }

    public void draw(Graphics graphics, ImageContainer ic, Point ws, Point we, Point ss, Point se ){
                            graphics.drawImage(ic.getImage(this.getImageTag(),this.getOwner()),   //image
                            ws.x,ws.y,              //world start point
                            we.x,we.y,              //world end point
                            ss.x,ss.y,              //source start point
                            se.x,se.y,              //source end point
                            null);
    }

    void move(Point point ) {

    }

    void move(int x, int y) {

    }

    

    // Default method for returning action
    public AbstractActionPanel getAction() {
        return new ActionPanelBlank();
    }

    // Default method for returning action
    public AbstractDescriptionPanel getDescription() {
        return new DescriptionPanelBlank();
    }

    public void setState(MatterStateEnum state) {
            this.state = state;
    }

    /*
     *      Note:
     *          At the time of writing, this is called
     *          to switch to the default state when selecting a unit
     *          It is used in the setSelect in the model
     */

    /*
     *      Further note:
     *          Commented out because, well, bad
     *          But Jer in model
     *          Get rid of this when possible
     */


    public void setStateToDefault() {
        //this.state = MatterStateEnum.normal;
    }

}
