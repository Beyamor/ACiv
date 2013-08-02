

package Game;

import java.io.*;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.*;


public class MusicController implements Runnable {

    private String classPath;
    private String battle;
    private String calm;
    private String fade;
    private String fanFare;
    private String gameWin;
    private String fox;
    private String city;
    private String unit;


    final static int battleLen=99000;
    final static int calmLen=63000;
    final static int fadeLen=15000;
    final static int fanFareLen=13000;
    final static int gameWinLen=2000;
    final static int foxLen=12000;
    final static int cityLen=7000;
    final static int unitLen=6000;


    AudioPlayer ap;
    InputStream in;
    AudioStream as;

    boolean interupted;
    boolean stopped;
    String toPlay;

   

    @Override
    public void run() {
        try {
            
            playFade();
            playCalmLoop();
            
        } catch (InterruptedException ex) {
            try {
                //Logger.getLogger(MusicController.class.getName()).log(Level.SEVERE, null, ex);
                interupted=true;

                stop();
                //System.out.println("Hello");
                if(toPlay.equals("toBattle")){
                    playBattle();}
                if(toPlay.equals("toFox")){
                    playFox();}
                if(toPlay.equals("toCity")){
                    playCity();}
                if(toPlay.equals("toUnit")){
                    playUnit();}
                toPlay="";

                run();
            } catch (InterruptedException ex1) {
                //System.out.println("World");
                stop();
                toPlay="";
                run();


                //Logger.getLogger(MusicController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }
    public MusicController(){
        Properties props = System.getProperties();
        classPath = props.getProperty("java.class.path");
        int temp = classPath.indexOf(";");
        if (temp>0){
            classPath =classPath.substring(0, temp);
            }
        classPath=classPath.replace("\\", "/");


        battle=classPath.concat("/game/music/Battle.wav");
        fade=classPath.concat("/game/music/Calm_fade_in.wav");
        calm=classPath.concat("/game/music/Calm_Loop.wav");
        fanFare=classPath.concat("/game/music/FanFare.wav");
        fox=classPath.concat("/game/music/20th_century_fox.au");
        city=classPath.concat("/game/music/Figaro.au");
        unit=classPath.concat("/game/music/CavalryCall.au");

        toPlay="";

        /*
        System.out.println(battle);
        System.out.println(calm);
        System.out.println(fade);
        System.out.println(fanFare);
         *
         */

    }

        public void playCity() throws InterruptedException{
        try
       {
       in = new FileInputStream(city);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }

    Thread.sleep(cityLen);
    }

    public void playUnit() throws InterruptedException{
        try
       {
       in = new FileInputStream(unit);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }

    Thread.sleep(unitLen);
    }

    public void playFox() throws InterruptedException{
        try
       {
       in = new FileInputStream(fox);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }

    Thread.sleep(foxLen);
    }


    public void playFanFare() throws InterruptedException{
        try
       {
       in = new FileInputStream(fanFare);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }

    Thread.sleep(fanFareLen);
    }
    public void playBattle() throws InterruptedException{
        try
       {
       in = new FileInputStream(battle);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }

    Thread.sleep(battleLen);


    }
    public void playBattleLoop() throws InterruptedException{
       while(true){
           try
           {
           in = new FileInputStream(battle);
           as = new AudioStream(in);


           ap.player.start(as);
           }
           catch(Exception e)
           {
           System.out.println("Got an IOException: " + e.getMessage());
           e.printStackTrace();

           }


           Thread.sleep(battleLen);

       }

    }

    public void playFadeLoop() throws InterruptedException{
     try
       {
       in = new FileInputStream(fade);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }
      Thread.sleep(fadeLen);
    }

    public void playFade() throws InterruptedException{
     try
       {
       in = new FileInputStream(fade);
       as = new AudioStream(in);
       ap.player.start(as);

       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }
      Thread.sleep(fadeLen);
    }

    public void playCalmLoop() throws InterruptedException{
    while(true){
    try
       {
       in = new FileInputStream(calm);
       as = new AudioStream(in);
       ap.player.start(as);
       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();
       }
     Thread.sleep(calmLen);

    }

    }

    //plays a singe audio file that is at the location .
    public void playSound(String path)
       {
       try
       {
       in = new FileInputStream(path);
       as = new AudioStream(in);
       ap.player.start(as);

       }
       catch(Exception e)
       {
       System.out.println("Got an IOException: " + e.getMessage());
       e.printStackTrace();

       }
    }


    public void attacked(){

    }

    public void stop(){
    ap.player.stop(as);
    ap.player.stop(in);
    }

    void toBattle() {
        toPlay="toBattle";

    }
    public void toFox() {
        toPlay="toFox";
    }

    public void toCity() {
        toPlay="toCity";
    }

    public void toUnit() {
        toPlay="toUnit";
    }




}

