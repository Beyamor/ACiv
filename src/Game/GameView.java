package Game;

import Game.View.WorldPanel;
import Game.View.AbstractActionPanel;
import Game.View.AbstractDescriptionPanel;
import Game.View.AdvancePanel;
import Game.View.HUDPanel;
import GameElements.ImageContainer;
import javax.swing.BoxLayout;
import javax.swing.event.MouseInputListener;
import aciv.*;


public class GameView extends AbstractView{

    public static final int JFRAME_OFFSET = 00; // 38 is magic number

    GameModel gameModel;

    //Action view
    public HUDPanel hudPanel;
    public WorldPanel worldPanel;
    public AdvancePanel advancePanel;

    //Research view

    //Dimensions from JFrame used for drawing WorldPanel
    int width, height;

    public GameView(GameModel gameModel, int w, int h) {

        //Layout is top to bottom
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        //Set model, and worldPanels connection to players
        this.gameModel = gameModel;
        this.worldPanel = new WorldPanel(this.gameModel,this.gameModel.world,new ImageContainer(this.gameModel.playerList.getList()));
        this.worldPanel.setPlayer(this.gameModel.playerList.getList().get(0));


        // Set JFrame height and width to GameView
        this.width = w;
        this.height = h-JFRAME_OFFSET;
        
        //Set Height and width of worldPanel
        worldPanel.setDimensions(width, height - HUDPanel.HUD_HEIGHT);

        //Make new hudPanel
        hudPanel = new HUDPanel( gameModel );
        hudPanel.setDimensions(width, HUDPanel.HUD_HEIGHT);

        // Make new Advance Panel
        advancePanel = new AdvancePanel();

        changeToAction();
    }

    public void addWorldPanelListener(MouseInputListener mouseInputListener)
    {
        worldPanel.addMouseListener(mouseInputListener);
    }

    public void update()
    {
        worldPanel.update();
    }

    public void changeToAction() {
        gameModel.addObserver( worldPanel );
        gameModel.addObserver( hudPanel.ntp );

        this.removeAll();

        this.add(worldPanel);
        this.add(hudPanel);

        this.validate();
        this.repaint();

    }

    public void setDescription(AbstractDescriptionPanel description) {
        hudPanel.setDescription(description);
    }
    
    public void setAction(AbstractActionPanel action) {
        hudPanel.setAction(action);
    }

    public void changeToResearch() {

        /* Fill in research view */
    }

    public void changeToAdvance() {

        gameModel.deleteObservers();

        this.removeAll();

        this.add( advancePanel );

        this.validate();
        this.repaint();
    }


}
