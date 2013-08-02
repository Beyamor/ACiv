/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameElements;

import AbstractMatter.Unit;
import AbstractMatter.Terrain;
import AbstractMatter.Road;
import AbstractMatter.River;
import AbstractMatter.Resource;
import AbstractMatter.City;
import AbstractMatter.Extractor;
import java.util.Comparator;

/**
 *
 * @author jmohr
 */
public class AbstractMatterComparator implements Comparator{

    public int compare(Object o1, Object o2) {
        Class<? extends AbstractMatter> a = (Class<? extends AbstractMatter>) o1.getClass();
        Class<? extends AbstractMatter> b = (Class<? extends AbstractMatter>) o2.getClass();

        //Unit is always highest
        if(a == Unit.class)
        {
            return 1;
        }

        //City is only lower than Unit
        if(a == City.class)
        {
            if(b == Unit.class)
            {
                return -1;
            }
            return 1;
        }

        //Extractor is lower than city 
        if(a == Extractor.class)
        {
            if(b == Unit.class || b == City.class)
            {
                return -1;
            }
            return 1;
        }

        //Resources is lower than Extractor
        if(a == Resource.class)
        {
            if(b == Unit.class || b == City.class || b == Extractor.class)
            {
                return -1;
            }
            return 1;
        }

        //Road is lower than Resource
        if(a == Road.class)
        {
            if(b == River.class || b == Terrain.class)
            {
                return 1;
            }
            return -1;
        }

        //River is lower than Road
        if(a == River.class)
        {
            if(b == Terrain.class)
            {
                return 1;
            }
            return -1;
        }

        //otherwise a == terrain and is always lower
        return -1;

    }

}
