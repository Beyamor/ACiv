package Game.View;

import AbstractMatter.Terrain;
import Game.GameModel;
import GameElements.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class WorldPanel extends JPanel implements Observer{
    private final boolean FOG_OF_WAR = true;

    //WorldPanel holds a World and a Player from the Model
    private World world;
    private Player player;

    private GameModel gameModel;

    //For Drawing Terrain, Cities, Roads, etc.
    private ImageContainer imageContainer;
    
    //For drawing unseen, previously seen, and observed (Fog of War)
    private PlayerMask playerMask;
  
    //Height and width of a Tile
    private int GRID_SIZE;

    public WorldPanel(GameModel gameModel, World world,ImageContainer imageContainer) {
        this.gameModel = gameModel;
        this.world = world;
        this.GRID_SIZE = world.GRID_SIZE;
        this.imageContainer = imageContainer;
    }

    //Set the height and width of WorldPanel
    public void setDimensions(int width, int height) {

        this.setMaximumSize(  new Dimension(width,height));
        this.setMinimumSize(  new Dimension(width,height));
        this.setPreferredSize(new Dimension(width,height));
    }

    //Player must be set to change every time you change control
    public void setPlayer(Player player) {
        this.player = player;
    }

    /* Overrides JPanel's paintComponent function for painting our World which depends on
     * who is currently playing and what is in each Tile
     */
    @Override
    public void paintComponent(Graphics g) {
        paintWorld(g,player);
    }

    public void paintWorld(Graphics g,Player p) {
        
        //Set playerMask to currentPlayers and update Player Mask
        this.playerMask = p.getPlayerMask();
        playerMask.update();

        Graphics2D graphics = (Graphics2D)g;

        //Clear screen before redrawing

        //removed, as a refresh error with unit movement caused the screen to print
        //during drawing. As the error does not occur while the camera is moving,
        //there is no tearing/other negative effects

        //graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        //Each Tile has a list of AbstractMatter
        List<AbstractMatter> tileList;

        //Represents top left corner of drawn section of the World
        Point camera = p.getCamera();



        //for every tile that could appear in the panel
        //

        //and x coordinates
        //
        for(int i=(camera.x/GRID_SIZE) - 1  ;  i < ( ((camera.x+this.getWidth()) / GRID_SIZE) + 1)  ;  i++){


            //and y coordinates
            //
            for(int j=(camera.y/GRID_SIZE) - 1  ;  j < (((camera.y + this.getHeight())/GRID_SIZE + 1))  ;  j++){

                //
                tileList = world.getTile((i + world.getWidth())%world.getWidth(),(j+ world.getHeight())%world.getHeight()).getAbstractMatterList();//modded to allow wraparound


                //AbstractMatter is sorted to render in correct order
                for(AbstractMatter a : tileList){

                    //if !(was seen) or (isterrain) then draw else (draw overlay, break)
                    if(a.getClass().getSuperclass() == Terrain.class || playerMask.fogMask[a.getTile().getPoint().x][a.getTile().getPoint().y] == 2)
                    {
                        a.draw(g, imageContainer,
                                new Point((i*GRID_SIZE)-camera.x,(j*GRID_SIZE)-camera.y),
                                new Point(((i+1)*GRID_SIZE - camera.x),((j+1)*GRID_SIZE - camera.y)),
                                new Point(a.getImageOffset().x,a.getImageOffset().y),
                                new Point(a.getImageOffset().x+GRID_SIZE,a.getImageOffset().y+GRID_SIZE));
                    }


                }




                if(FOG_OF_WAR)
                {
                    if(playerMask.fogMask[(i + world.getWidth())%world.getWidth()][(j+ world.getHeight())%world.getHeight()] == 1) {
                        graphics.drawImage(imageContainer.getImage(ImageTag.MASK,null),         //image
                                (i*GRID_SIZE)-camera.x,(j*GRID_SIZE)-camera.y,                  //world start point
                                ((i+1)*GRID_SIZE - camera.x),((j+1)*GRID_SIZE - camera.y),      //world end point
                                0,0,                                                            //source start point
                                GRID_SIZE,GRID_SIZE,                                            //source end point
                                null);
                    }

                    //
                    if(playerMask.fogMask[(i + world.getWidth())%world.getWidth()][(j+ world.getHeight())%world.getHeight()] == 0) {
                        graphics.drawImage(imageContainer.getImage(ImageTag.FOG,null),          //image
                                (i*GRID_SIZE)-camera.x,(j*GRID_SIZE)-camera.y,                  //world start point
                                ((i+1)*GRID_SIZE - camera.x),((j+1)*GRID_SIZE - camera.y),      //world end point
                                0,0,                                                            //source start point
                                GRID_SIZE,GRID_SIZE,                                            //source end point
                                null);
                    }
                }


                    if(gameModel.selected != null && world.getTile((i + world.getWidth())%world.getWidth(),(j+ world.getHeight())%world.getHeight()) == gameModel.selected.getTile())
                    {

                        graphics.drawImage(imageContainer.getImage(ImageTag.FOCUS,null),
                            (i*GRID_SIZE)-camera.x,(j*GRID_SIZE)-camera.y,                  //world start point
                            ((i+1)*GRID_SIZE - camera.x),((j+1)*GRID_SIZE - camera.y),      //world end point
                            0,0,                                                            //source start point
                            GRID_SIZE,GRID_SIZE,                                            //source end point
                            null);
                    }


                
            }//

        }//

    }//

    public void update()
    {
        this.paintComponent(this.getGraphics());
    }

    public void update(Observable o, Object arg) {
        this.update();
    }

}