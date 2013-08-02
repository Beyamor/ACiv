package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Plains extends Terrain implements Stats {

    public Plains(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE * 4);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Plains_MovementModifier;
        this.attackModifier = Plains_AttackModifier;
        this.defenseModifier = Plains_DefenseModifier;
        this.economy = Plains_Economy;
        this.food = Plains_Food;
        this.production = Plains_Production;

    }

}
