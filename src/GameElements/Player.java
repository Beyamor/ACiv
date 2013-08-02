package GameElements;

import AbstractMatter.Unit;
import AbstractMatter.City;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class Player implements Serializable {

    Color playerColor;
    String playerName;
    Point camera;
    
    PlayerImage playerImage;
    PlayerMask playerMask;

    AbstractMatterList unitList;
    AbstractMatterList cityList;
    AbstractMatterList extractorList;

    boolean selected;

    //temporary for milestone 2
    public Player(Color pc, String civName) {
        this.camera = new Point(0,0);

        this.playerColor = pc;

        //set up the filtered image
        this.playerImage = new PlayerImage();

        //MODIFY TO ACCEPT WORLD VALUES LATER
        this.playerMask = new PlayerMask(this,60,40);

        this.unitList = new AbstractMatterList();
        this.cityList = new AbstractMatterList();
        this.extractorList = new AbstractMatterList();

        this.playerName = civName;
    }
    //end of temp


    public Point getCamera(){
        return camera;
    }

    public void setCamera(Point p){
        this.camera = p;
    }

    public PlayerImage getPlayerImage(){
        //return the playerimage
        return this.playerImage;
    }

    public PlayerMask getPlayerMask(){
        //return the playerMask
        return this.playerMask;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void addUnit(Unit unit,Tile tile){
        //add a unit to player and world
        this.unitList.add(unit);
        tile.abstractMatterList.add(unit);    

        //add world/player to unit
        unit.place(this,tile);
        
    }

    public void removeUnit(Unit unit)
    {
        unit.getTile().removeUnit();
        this.unitList.remove(unit);
    }

    public void removeCity(City city)
    {
        city.getTile().removeCity();
        this.cityList.remove(city);
    }


    public void addCity(City city, Tile tile){
        this.cityList.add(city);
        tile.abstractMatterList.add(city);

        city.place(this,tile);
    }

    public AbstractMatterList getCityList()
    {
        return this.cityList;
    }

    public AbstractMatterList getUnitList()
    {
        return this.unitList;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public Color getPlayerColor() {
        return this.playerColor;
    }


}
