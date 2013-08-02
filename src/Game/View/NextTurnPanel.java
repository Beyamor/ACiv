/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.View;

import Game.GameModel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tagibson
 */
public class NextTurnPanel
    extends JPanel
    implements Observer {

        GameModel model;
    
        public JButton nextTurnButton;
        JLabel playerName;
        JPanel playerNamePanel;


        public NextTurnPanel(GameModel model) {

            this.model = model;

            model.addObserver(this);

            this.setBackground( new Color(180, 100, 210) );

            nextTurnButton = new JButton("End turn");

            playerName = new JLabel( model.getCurrentPlayer().getPlayerName() );

            playerNamePanel = new JPanel();
            playerNamePanel.setBackground( model.getCurrentPlayer().getPlayerColor() );
            playerNamePanel.add( playerName );

            this.add( playerNamePanel );
            this.add(nextTurnButton);


        }

    public void update(Observable o, Object arg) {
        playerName.setText( model.getCurrentPlayer().getPlayerName() );
        playerNamePanel.setBackground( model.getCurrentPlayer().getPlayerColor() );
    }

}
