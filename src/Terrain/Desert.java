package Terrain;

import AbstractMatter.Terrain;
import GameElements.Tile;
import java.awt.Point;

public class Desert extends Terrain implements Stats {

    public Desert(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,GRID_SIZE);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Desert_MovementModifier;
        this.attackModifier = Desert_AttackModifier;
        this.defenseModifier = Desert_DefenseModifier;
        this.economy = Desert_Economy;
        this.food = Desert_Food;
        this.production = Desert_Production;


    }

}
