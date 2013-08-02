/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.MatterPanels;

import AbstractMatter.MatterStateEnum;
import Game.View.AbstractActionPanel;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

/**
 *
 * @author tagibson
 */
public class ActionPanelMilitaryUnit 
    extends AbstractActionPanel {
    
    //ActionButton attack;
    ActionButton fortify;

    public ActionPanelMilitaryUnit() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        this.setBackground(backgroundColor);
            
        //attack = new ActionButton("Attack", MatterStateEnum.attack);
        //this.add( attack );

        fortify = new ActionButton("Fortify", MatterStateEnum.fortify);
        this.add( fortify );
    }
    
    @Override
    public void setListeners(ActionListener listener) {
        //attack.addActionListener(listener);
        fortify.addActionListener(listener);
    }

}
