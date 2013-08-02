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
public class ActionPanelCity
    extends AbstractActionPanel {

    ActionButton about;
    ActionButton build;

    public ActionPanelCity() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.setBackground(backgroundColor);

        about = new ActionButton("About", MatterStateEnum.normal);
        this.add( about );

        build = new ActionButton("Build", MatterStateEnum.build);
        this.add( build );
    }

    @Override
    public void setListeners(ActionListener listener) {
        about.addActionListener(listener);
        build.addActionListener(listener);
    }

}
