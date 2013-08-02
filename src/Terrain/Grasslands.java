package Terrain;

import AbstractMatter.Terrain;
import GameElements.*;
import java.awt.Point;


public class Grasslands extends Terrain implements Stats{

    public Grasslands(Tile tile){
        this.owner = null;
        this.tile = tile;

        this.passable = true;
        this.water = false;

        neighborModifier = 0;       //this value is to allow worldeditor to make
                                    //the maps look pretty
        this.imageOffset = new Point(neighborModifier,0);
        this.imageTag = imageTag.TERRAIN;

        this.movementModifier = Grasslands_MovementModifier;
        this.attackModifier = Grasslands_AttackModifier;
        this.defenseModifier = Grasslands_DefenseModifier;
        this.economy = Grasslands_Economy;
        this.food = Grasslands_Food;
        this.production = Grasslands_Production;


    }

}
