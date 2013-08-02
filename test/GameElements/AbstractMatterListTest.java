/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameElements;

import AbstractMatter.Unit;
import AbstractMatter.Road;
import AbstractMatter.River;
import AbstractMatter.Resource;
import AbstractMatter.City;
import AbstractMatter.Extractor;
import Terrain.Grasslands;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hoshi
 */
public class AbstractMatterListTest {

    public AbstractMatterListTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class AbstractMatterList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        AbstractMatterList instance = new AbstractMatterList();

        instance.add(new Resource());

        instance.add(new Road());

        instance.add(new City());

        instance.add(new Unit());
        
        instance.add(new Grasslands(new Tile(new World(new LinkedList<Player>()),0,0)));

        instance.add(new Extractor());

        instance.add(new River());


        List list = instance.getAbstractMatterList();
        System.out.println(list);
    }

    
    /**
     * Test of updateIndex method, of class AbstractMatterList.
     */
    @Test
    public void testUpdateIndex() {
        System.out.println("updateIndex");
        int ind = 0;
        AbstractMatterList instance = new AbstractMatterList();
 /*       instance.updateIndex(0);
        assertEquals(instance.index[0],0);
        assertEquals(instance.index[1],1);
        assertEquals(instance.index[2],1);
        instance.updateIndex(1);
        assertEquals(instance.index[0],0);
        assertEquals(instance.index[1],1);
        assertEquals(instance.index[2],2);
        assertEquals(instance.index[3],2);
*/
        
    }

}