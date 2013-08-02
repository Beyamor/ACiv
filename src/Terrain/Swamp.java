package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Swamp extends Terrain implements Stats {

    public Swamp(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE * 5);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Swamp_MovementModifier;
        this.attackModifier = Swamp_AttackModifier;
        this.defenseModifier = Swamp_DefenseModifier;
        this.economy = Swamp_Economy;
        this.food = Swamp_Food;
        this.production = Swamp_Production;


    }

}
