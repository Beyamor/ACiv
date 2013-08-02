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
public class StateResearch
    implements GameControllerState {

    GameController controller;
    GameView view;
    GameModel model;

    public StateResearch(GameController controller, GameModel model, GameView view) {
        this.controller = controller;
        this.model = model;
        this.view = view;

    }

    public void changeToAction() {
        this.controller.setState(this.controller.getActionState());
        this.view.changeToAction();
    }

    public void changeToResearch() {
        System.out.println("Already in research");
    }

    public void changeToAdvance() {
        System.out.println("Must go to action");
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
