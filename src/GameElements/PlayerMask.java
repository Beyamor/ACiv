/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameElements;

import AbstractMatter.Unit;
import AbstractMatter.City;
import java.util.List;

/**
 *
 * @author jmohr
 */
public class PlayerMask {
    public Player player;
    public int[][] fogMask;

    public PlayerMask(Player player, int width, int height){
        this.player = player;

    }

    public void buildMask(int width, int height)
    {
        fogMask = new int[width][height];

        for(int i = 0;i <width;i++){
            for(int j = 0; j < height;j++){

                fogMask[i][j] = 0;

                //ADD SOME CONVENTION
                // 0 is unseen
                // 1 is previously seen
                // 2 is observed
            }
        }
    }

    public void update(){

        if(this.player.unitList == null){
            return;
        }

        List units = this.player.unitList.getAbstractMatterList();
        List cities = this.player.cityList.getAbstractMatterList();

        //add a wide radius of previously seen
        for(int k = 0; k < units.size(); k++)
        {
            Unit temp = (Unit)units.get(k);

            for(int i = -3; i < 4; i++)
            {
                for(int j = -3; j < 4; j++)
                {
                        fogMask[((temp.tile.x + i) + fogMask.length)%fogMask.length][((temp.tile.y + j) + fogMask[0].length)%fogMask[0].length] = 1;
                }
            }
        }

        //add a smaller radius of observed for units
        for(int k = 0; k < units.size(); k++)
        {
            Unit temp = (Unit)units.get(k);
            for(int i = -2; i < 3; i++)
            {
                for(int j = -2; j < 3; j++)
                {
                        fogMask[((temp.tile.x + i) + fogMask.length)%fogMask.length][((temp.tile.y + j) + fogMask[0].length)%fogMask[0].length] = 2;
                }
            }
        }

        //and a large radius for cities
        for(int k = 0; k < cities.size(); k++)
        {
            City temp = (City)cities.get(k);

            for(int i = -4; i < 5; i++)
            {
                for(int j = -4; j < 5; j++)
                {
                        fogMask[((temp.tile.x + i) + fogMask.length)%fogMask.length][((temp.tile.y + j) + fogMask[0].length)%fogMask[0].length] = 2;
                }
            }

        }

        return;
    }



}
