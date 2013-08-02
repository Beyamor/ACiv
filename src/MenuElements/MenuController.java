/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MenuElements;

import aciv.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author tagibson
 */
public class MenuController extends AbstractController {
    
        GameRunner gameRunner;

        public MenuController(AbstractView view, AbstractModel model, GameRunner gameRunner) {

            this.view = view;
            this.model = model;
            this.gameRunner = gameRunner;

            ((MenuView)view).addListeners( this );
  
        }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( ((JButton)e.getSource()).getText().equals("Add player") ) {
            ((MenuModel)model).addPlayer( ((MenuView)view).getPlayerName(),
                                            ((MenuView)view).getPlayerColor());
            ((MenuView)view).clearPlayerName();
        } else {
            gameRunner.ChangeState( GameRunner.State.gameState );
        }
    }

}
