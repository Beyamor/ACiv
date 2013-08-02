/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cities;

import AbstractMatter.City;
import GameElements.*;
import java.awt.Point;

/**
 *
 * @author jmohr
 */
public class SmallCity extends City {
    
    public SmallCity()
    {
        this.imageTag = imageTag.ALIEN_CITIES;
        this.imageOffset = new Point(0,0);

        this.Production = 200;
        this.PP = Production;
    }

}
