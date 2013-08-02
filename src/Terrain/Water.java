package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Water extends Terrain implements Stats {

    public Water(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = false;
        this.water = true;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE * 8);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Water_MovementModifier;
        this.attackModifier = Water_AttackModifier;
        this.defenseModifier = Water_DefenseModifier;
        this.economy = Water_Economy;
        this.food = Water_Food;
        this.production = Water_Production;


    }

}
