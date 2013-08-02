/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.MatterPanels;

import AbstractMatter.MatterStateEnum;
import Game.View.AbstractActionPanel;
import Game.View.AbstractActionPanel.ActionButton;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

/**
 *
 * @author tagibson
 */
public class ActionPanelWorker
    extends AbstractActionPanel {

    ActionButton imroveCity;
    ActionButton fortify;

    public ActionPanelWorker() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.setBackground(backgroundColor);

        imroveCity = new ActionButton("Improve", MatterStateEnum.improveCity);
        this.add( imroveCity );

        fortify = new ActionButton("Fortify", MatterStateEnum.fortify);
        this.add( fortify );
    }

    @Override
    public void setListeners(ActionListener listener) {
        imroveCity.addActionListener(listener);
        fortify.addActionListener(listener);
    }

}
