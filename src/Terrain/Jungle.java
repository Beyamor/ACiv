package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Jungle extends Terrain implements Stats {

    public Jungle(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE * 3);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Jungle_MovementModifier;
        this.attackModifier = Jungle_AttackModifier;
        this.defenseModifier = Jungle_DefenseModifier;
        this.economy = Jungle_Economy;
        this.food = Jungle_Food;
        this.production = Jungle_Production;


    }

}
