/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.View;

import Game.GameModel;
import Game.MatterPanels.ActionPanelBlank;
import Game.MatterPanels.DescriptionPanelBlank;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author tagibson
 */
public class HUDPanel 
    extends JPanel {

    public static final int HUD_HEIGHT = 300;
    public static final int DESCRIPTION_WIDTH = 700;
    public static final int NEXT_TURN_WIDTH = 100;

    AbstractActionPanel action;
    AbstractDescriptionPanel description;
    public NextTurnPanel ntp;

    //Width and Height of the HUDPanel.

    int width, height;

    public HUDPanel(GameModel model) {

        //Set Left to right layout
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        //Create Panels
        action = new ActionPanelBlank();
        description = new DescriptionPanelBlank();
        ntp = new NextTurnPanel( model );

        this.setBackground(Color.WHITE);

        this.add(description);
        this.add(action);
        this.add(ntp);
    }

    public void setDimensions(int width, int height) {

        //Get the Height and Width from the GameView
        this.width = width;
        this.height = height;
        
        //Set the HUD Panel to the correct Dimension
        this.setMinimumSize(new Dimension(width, height));
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        
        //Set the Description Panel to the Dimension you want
        description.setMinimumSize(new Dimension(HUDPanel.DESCRIPTION_WIDTH, height));
        description.setPreferredSize(new Dimension(HUDPanel.DESCRIPTION_WIDTH, height));
        description.setMaximumSize(new Dimension(HUDPanel.DESCRIPTION_WIDTH, height));
        
        //Set the Action Panel to the correct Dimension
        action.setMinimumSize(new Dimension(width - HUDPanel.DESCRIPTION_WIDTH - HUDPanel.NEXT_TURN_WIDTH, height));
        action.setMaximumSize(new Dimension(width - HUDPanel.DESCRIPTION_WIDTH - HUDPanel.NEXT_TURN_WIDTH, height));
        action.setPreferredSize(new Dimension(width - HUDPanel.DESCRIPTION_WIDTH - HUDPanel.NEXT_TURN_WIDTH, height));

        //Set the Next Turn Panel to the correct Dimension
        ntp.setMinimumSize(new Dimension(HUDPanel.NEXT_TURN_WIDTH, height));
        ntp.setMaximumSize(new Dimension(HUDPanel.NEXT_TURN_WIDTH, height));
        ntp.setPreferredSize(new Dimension(HUDPanel.NEXT_TURN_WIDTH, height));

        this.validate();
        this.repaint();
    }


    // Sets description by clearing old, repacking, dimensions
    public void setDescription(AbstractDescriptionPanel description) {
        this.description = description;

        this.removeAll();
        this.add(description);
        this.add(action);
        this.add(ntp);
        setDimensions(width, height);
    }

    // Sets description by clearing old, repacking, dimensions
    public void setAction(AbstractActionPanel action) {
        this.action = action;

        this.removeAll();
        this.add(description);
        this.add(action);
        this.add(ntp);
        setDimensions(width, height);
    }
}
