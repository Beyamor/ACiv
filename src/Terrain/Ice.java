package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Ice extends Terrain implements Stats {

    public Ice(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE * 2);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Ice_MovementModifier;
        this.attackModifier = Ice_AttackModifier;
        this.defenseModifier = Ice_DefenseModifier;
        this.economy = Ice_Economy;
        this.food = Ice_Food;
        this.production = Ice_Production;


    }

}
