/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.event.ActionEvent;

/**
 *
 * @author tagibson
 */
public class StateAdvance
    implements GameControllerState {

    GameController controller;
    GameModel model;
    GameView view;

    public StateAdvance(GameController controller, GameModel model, GameView view) {
        this.controller = controller;
        this.model = model;
        this.view = view;
        this.view.advancePanel.addListener(this);
    }

    public void doAdvance() {

        model.resetTurn();
        model.nextTurn();
        view.worldPanel.setPlayer(model.playerList.getCurrentPlayer());
        
    }

    public void changeToAction() {
        this.controller.setState(this.controller.getActionState());
    }

    public void changeToResearch() {
        this.controller.setState(this.controller.getResearchState());
        view.changeToResearch();
    }

    public void changeToAdvance() {
        System.out.println("Already in advance");
    }

    public void actionPerformed(ActionEvent e) {
        changeToAction();
        this.doAdvance();
    }

}
