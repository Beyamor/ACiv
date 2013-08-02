package GameElements;

import AbstractMatter.*;
import Terrain.*;
import java.awt.Point;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Tile implements Serializable {

    //Each Tile contains an AbstractMatterList
    AbstractMatterList abstractMatterList;

    //Position in the World
    int x;
    int y;

    //Each Tile has a reference to the World
    World world;

    public Tile(World world, int x, int y) {
        //Backlink to world
        this.world = world;

        //Set the x and y
        this.x = x;
        this.y = y;

        //Initializes AbstractMatterList
        this.abstractMatterList = new AbstractMatterList();

        //Temporary
        Random gen = new Random();
        if(gen.nextBoolean()){
            this.abstractMatterList.add(new Desert(this));
        } else {
            this.abstractMatterList.add(new Grasslands(this));
        }
        //End of Temporary
    }

    public Tile(World world, int x, int y, TerrainEnum terrain) {
        //Backlink to world
        this.world = world;

        //Set the x and y
        this.x = x;
        this.y = y;

        //Initializes AbstractMatterList
        this.abstractMatterList = new AbstractMatterList();

        switch (terrain) {
            case desert:
                this.abstractMatterList.add(new Desert(this));
                break;
            case grasslands:
                this.abstractMatterList.add(new Grasslands(this));
                break;
            case ice:
                this.abstractMatterList.add(new Ice(this));
                break;
            case jungle:
                this.abstractMatterList.add(new Jungle(this));
                break;
            case plains:
                this.abstractMatterList.add(new Plains(this));
                break;
            case rock:
                this.abstractMatterList.add(new Rock(this));
                break;
            case swamp:
                this.abstractMatterList.add(new Swamp(this));
                break;
            case water:
                this.abstractMatterList.add(new Water(this));
                break;
        }
    }


    public enum TerrainEnum {
        desert, grasslands, ice, jungle, plains,
        rock, swamp, water;
    }

    public List<AbstractMatter> getAbstractMatterList() {
        return this.abstractMatterList.getAbstractMatterList();
    }

    public void addUnit(Unit unit) {
        this.abstractMatterList.add(unit);
    }

    public Unit getUnit() {
        return (Unit)this.abstractMatterList.get(Unit.class);
    }

    public City getCity() {
        return (City)this.abstractMatterList.get(City.class);
    }

    public Terrain getTerrain(){
        return (Terrain)this.abstractMatterList.get(Terrain.class);
    }

    public Point getPoint() { 
        return new Point(this.x,this.y);
    }

    public float getMovement()
    {
        Terrain t = (Terrain)this.abstractMatterList.get(Terrain.class);
        return t.movementModifier;
    }

    //Colton Code starts here
    public Extractor getExtractor() {
        return (Extractor)this.abstractMatterList.get(Extractor.class);
    }

    public void removeUnit() {
        if(containsUnit())//this.abstractMatterList.has(Unit.class))
        {
            this.abstractMatterList.get(Unit.class).owner.cityList.remove(this.abstractMatterList.get(Unit.class));
            this.abstractMatterList.remove(Unit.class);
        }
    }

    public void removeCity() {
        if(this.abstractMatterList.has(City.class))
        {
            this.abstractMatterList.get(City.class).owner.cityList.remove(this.abstractMatterList.get(City.class));
            this.abstractMatterList.remove(City.class);
            this.abstractMatterList.sort();
        }
    }

    //Colton Code ends here
    public boolean containsUnit() {
        if(this.abstractMatterList.has(Unit.class)){
            return true;
        }
        return false;
    }
    


}
