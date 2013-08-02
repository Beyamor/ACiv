/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.MatterPanels;

import AbstractMatter.City;
import Game.View.AbstractDescriptionPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author tagibson
 */
public class DescriptionPanelCityBuild
    extends AbstractDescriptionPanel {

    JButton build;

    public DescriptionPanelCityBuild(City city) {
        this.setBackground(backgroundColor);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        build = new JButton( "Random Unit" );
        Dimension d = new Dimension(800,250);
        build.setPreferredSize(d);
        build.setMinimumSize(d);
        build.setMaximumSize(d);
        build.setFont(new Font("sansserif", Font.BOLD, 30));
        build.setFocusable(false);
        this.add( build );

    }

    @Override
    public void setListeners(ActionListener listener) {
        build.addActionListener(listener);
    }

}