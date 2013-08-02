package aciv;

import Game.*;
import GameElements.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Container;
import NewElements.*;
import MenuElements.*;
import java.awt.event.ActionListener;
import java.util.Properties;

public class GameRunner extends JFrame
    implements ActionListener {

    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 900;

    AbstractModel model;
    AbstractView view;
    AbstractController controller;
    //MusicController music = new MusicController();
    //Thread thread;

    public GameRunner() {
        setFrameSettings();
        ChangeState(State.menuState);
        //music = new MusicController();
        //thread=new Thread(music);
    }

    public void ChangeState(State changeState) {
        switch (changeState) {
            case newState: {
                changetoNewState();
                break;
            }
            case gameState: {
                changetoGameState();
                break;
            }
            case menuState: {
                changeToMenuState();
                break;
            }
        }

    }

    private void changeToMenuState() {

        clearMVC();

        Container cp = this.getContentPane();

        model = new MenuModel();
        view = new MenuView(model);
        controller = new MenuController(view, model, this);

        cp.add(view);

        this.stateChangedRefresh();
    }

    private void changetoNewState() {

        clearMVC();

        Container cp = this.getContentPane();

        model = new NewModel();
        view = new NewView(model);
        controller = new NewController(view,model);

        cp.add(view);

        this.stateChangedRefresh();
    }
            
            
    private void changetoGameState() {

        clearMVC();
        
        PlayerList pl = new PlayerList(true);

        Properties props = System.getProperties();
        String classPath = props.getProperty("java.class.path");
        classPath = classPath.replace("\\", "/");
        String mapName = classPath.concat("/Maps/DefaultWorld.txt");

        MenuModel oldModel = (MenuModel)model;
        
        model = new GameModel(pl,new World(pl, mapName, 
                oldModel.getPlayerNames(),
                oldModel.getPlayerColors()));
        view = new GameView((GameModel)model, this.getWidth(), this.getHeight());
        controller = new GameController((GameView)view, (GameModel)model);

        getContentPane().add(view);

        stateChangedRefresh();
        //thread.start();
    }
    
    private void clearMVC() {
        getContentPane().removeAll();
    }

    private void setFrameSettings() {
        setVisible(true);
        setTitle("aCiv");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void stateChangedRefresh() {
        this.validate();
        this.repaint();
    }

    //What exactly is this for???
    @Override
    public void repaint() {
        super.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass() == MenuView.MenuButton.class) {
            ChangeState( (((MenuView.MenuButton)e.getSource())).getState() );
        }
    }

    public enum State {
        newState, gameState, menuState;
    }




}
