package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Rock extends Terrain implements Stats {

    public Rock(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE * 6);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Rock_MovementModifier;
        this.attackModifier = Rock_AttackModifier;
        this.defenseModifier = Rock_DefenseModifier;
        this.economy = Rock_Economy;
        this.food = Rock_Food;
        this.production = Rock_Production;


    }

}
