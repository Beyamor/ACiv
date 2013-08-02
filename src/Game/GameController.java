package Game;

import aciv.*;


public class GameController extends AbstractController {

    GameControllerState state;
    GameControllerState stateAction;
    GameControllerState stateAdvance;
    GameControllerState stateResearch;


    public GameController(GameView gameView, GameModel gameModel)
    {
        //Constructer sets view and model
        this.view = gameView;
        this.model = gameModel;

        /* State Machine Initiation */
        stateAction = new StateAction(this, (GameModel)model, (GameView)view);
        stateAdvance = new StateAdvance(this,  (GameModel)model, (GameView)view);
        stateResearch = new StateResearch(this,  (GameModel)model, (GameView)view);
        state = stateAction;

    }

    public void setState(GameControllerState state) {
        this.state = state;
    }

    public GameControllerState getActionState() {
        ((GameView)view).changeToAction();

        return stateAction;
    }
    public GameControllerState getResearchState() {
        return stateResearch;
    }
    public GameControllerState getAdvanceState() {
        
        ((GameView)view).changeToAdvance();
        
        return stateAdvance;
    }
}
