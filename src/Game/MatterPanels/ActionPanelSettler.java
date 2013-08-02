/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.MatterPanels;

import AbstractMatter.MatterStateEnum;
import Game.View.AbstractActionPanel;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author tagibson
 */
public class ActionPanelSettler
    extends AbstractActionPanel {
    
    ActionButton buildCity;
    ActionButton fortify;

    public ActionPanelSettler() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.setBackground(backgroundColor);

        buildCity = new ActionButton("Build city", MatterStateEnum.buildCity);
        this.add( buildCity );
        
        fortify = new ActionButton("Fortify", MatterStateEnum.fortify);
        this.add( fortify );
    }
    
    @Override
    public void setListeners(ActionListener listener) {
        buildCity.addActionListener(listener);
        fortify.addActionListener(listener);
    }

}
