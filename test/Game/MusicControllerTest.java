/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoshi
 */
public class MusicControllerTest {

    public MusicControllerTest() {
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
     * Test of attacked method, of class MusicController.
     */
    //@Test
    public void testAttacked() {
        System.out.println("attacked");
        MusicController instance =  new MusicController();
        instance.attacked();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playBattleLoop method, of class MusicController.
     */
    //@Test
    public void testPlayBattleLoop() throws Exception {
        System.out.println("playBattleLoop");
        MusicController instance = new MusicController();
        instance.playBattleLoop();
        
    }

    /**
     * Test of playFadeLoop method, of class MusicController.
     */
    //@Test
    public void testPlayFadeLoop() throws Exception {
        System.out.println("playFadeLoop");
        MusicController instance = new MusicController();
        instance.playFadeLoop();
        
        
    }

    /**
     * Test of playCalmLoop method, of class MusicController.
     */
    //@Test
    public void testPlayCalmLoop() throws Exception {
        System.out.println("playCalmLoop");
        MusicController instance = new MusicController();
        instance.playCalmLoop();
        for(int i=0;i<30;i++){
            System.out.print(i+" Seconds passed");
            Thread.sleep(1000);
        }
        
    }



/**
     * Test of playSound method, of class MusicController.
     */
    //@Test
    public void testPlaySound() throws Exception {
        System.out.println("playSound");
        String path = "H:/seng271/pro1/aCiv/src/Game/music/20th_century_fox.au";
        MusicController instance = new MusicController();
        instance.playSound(path);
        //path = "H:/seng271/pro1/aCiv/src/Game/music/Battle.wav";
        //instance.playSound(path);
        for(int i=0;i<5;i++){
            System.out.print(i+" Seconds passed ");
            Thread.sleep(1000);
            
        }

    }

    //@Test
    public void testSoundStop() throws Exception {
        System.out.println("playSoundStop");
        MusicController mc = new MusicController();
        Thread instance=new Thread (mc);
        instance.start();
        for(int i=0;i<30;i++){
            System.out.println(i+" Seconds passed ");
            Thread.sleep(1000);
            if (i ==5){
            System.out.println("stopped");
            mc.stop();
            }


            if (i ==15){
            System.out.println("interupted");
            instance.interrupt();


            }

        }
        mc.stop();
    }

    @Test
    public void testSoundInterrupt() throws Exception {
        System.out.println("playSoundInterrupt");
        MusicController mc = new MusicController();
        Thread instance=new Thread (mc);
        instance.start();
        for(int i=0;i<150;i++){
            System.out.println(i+" Seconds passed ");
            Thread.sleep(1000);
            if (i ==5){
            System.out.println(" Interupted ");
            instance.interrupt();
            }

             if (i ==30){
            System.out.println(" Interupted ");
            instance.interrupt();
            }
    
    
            }
            mc.stop();
    }

    //@Test
    public void testSoundThread() throws Exception {
        System.out.println("playSoundThread");
        MusicController mc = new MusicController();
        Thread instance=new Thread (mc);
    //    instance.start();
        for(int i=0;i<150;i++){
            System.out.println(i+" Seconds passed ");
            Thread.sleep(1000);

    
    
            }

    }

    /**
     * Test of run method, of class MusicController.
     */
    //@Test
    public void testRun() {
        System.out.println("run");
        MusicController instance = new MusicController();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playFanFare method, of class MusicController.
     */
    //@Test
    public void testPlayFanFare() throws Exception {
        System.out.println("playFanFare");
        MusicController instance = new MusicController();
        instance.playFanFare();
        
    }

    /**
     * Test of playBattle method, of class MusicController.
     */
    //@Test
    public void testPlayBattle() throws Exception {
        System.out.println("playBattle");
        MusicController instance = new MusicController();
        instance.playBattle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playFade method, of class MusicController.
     */
    //@Test
    public void testPlayFade() throws Exception {
        System.out.println("playFade");
        MusicController instance = new MusicController();
        instance.playFade();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   

    /**
     * Test of playCity method, of class MusicController.
     */
    @Test
    public void testPlayCity() throws Exception {
        System.out.println("playCity");
        MusicController instance = new MusicController();
        instance.playCity();
       
        
    }

    /**
     * Test of playUnit method, of class MusicController.
     */
    @Test
    public void testPlayUnit() throws Exception {
        System.out.println("playUnit");
        MusicController instance = new MusicController();
        instance.playUnit();
        
    }

    /**
     * Test of playFox method, of class MusicController.
     */
    @Test
    public void testPlayFox() throws Exception {
        System.out.println("playFox");
        MusicController instance = new MusicController();
        instance.playFox();
        
    }
}
