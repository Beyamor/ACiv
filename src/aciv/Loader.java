
//Oh man. I don't know if we need this stupid class anymore.
//Tom, this is your call!


package aciv;

import Game.GameModel;
import GameElements.PlayerList;
import GameElements.World;
import java.util.Observable;

public class Loader extends Observable {

    GameModel gameModel;
    World world;
    PlayerList playerList;

    public Loader() {

    }

    //Loading a saved game
    public Loader(GameModel gameModel) {

        this.gameModel = gameModel;
        addGameModelImageObservers();
        loadGameModel();
        notifyObservers();

    }
    //Loading a new game from a pre-made world
    public Loader( PlayerList playerList) {
        this.playerList = playerList;
        notifyObservers();
        loadWorld();

    }

    private void addGameModelImageObservers() {

    }

    private void addWorldImageObservers() {

    }

    private void addPlayerListImageObservers() {

    }

    public GameModel getGameModel() {

        //if Loads properly
        return this.gameModel;
    }

    private void loadGameModel() {

    }

    private void loadWorld() {
        
    }


}
