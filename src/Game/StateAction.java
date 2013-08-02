/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import Game.View.AbstractActionPanel;
import Game.MatterPanels.ActionPanelBlank;
import Game.MatterPanels.DescriptionPanelBlank;
import AbstractMatter.MatterStateEnum;
import Game.View.AbstractDescriptionPanel;
import GameElements.Player;
import GameElements.Tile;
import Units.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author tagibson
 */
public class StateAction
    implements GameControllerState {

    GameController controller;
    GameModel model;
    GameView view;

    ActionPanelListener apl;
    DescriptionPanelListener dpl;


    public StateAction(GameController controller, GameModel model, GameView view) {
        this.controller = controller;
        this.model = model;
        this.view = view;

        model.addObserver(this.view.worldPanel);

        apl = new ActionPanelListener();
        dpl = new DescriptionPanelListener();

        //Add Listeners
        this.view.addWorldPanelListener(new WorldPanelListener(this));
        this.view.hudPanel.ntp.nextTurnButton.addActionListener(new NextTurnPanelListener(this));
    }

    public void changeToAction() {
        System.out.println("already in action");
    }

    public void changeToResearch() {
        this.controller.setState(this.controller.getResearchState());
        view.changeToResearch();
    }

    public void changeToAdvance() {
        this.controller.setState(this.controller.getAdvanceState());
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


     private class WorldPanelListener implements MouseInputListener  {
         private static final int MOUSE_LEFT = 1;
         private static final int MOUSE_MIDDLE = 2;
         private static final int MOUSE_RIGHT = 3;

         private StateAction controller;
         
         public WorldPanelListener(StateAction controller) {
             this.controller = controller;
         }

        public void mouseClicked(MouseEvent e) {
            return;
        }

        public void mousePressed(MouseEvent e) {

            //get the current player
            Player p = model.playerList.getCurrentPlayer();

            //get the coordinate that the mouse is clicked on
            int x = screenToTile(e.getX() + p.getCamera().x, model.world.getWidth());
            int y = screenToTile(e.getY() + p.getCamera().y, model.world.getHeight());

            Tile tile = model.world.getTile(x,y);

            //Unit Creation
            if(e.getButton() == MOUSE_LEFT)
            {
                model.leftClick(model.world.getTile(x,y), e.isShiftDown());
            }

            if(e.getButton() == MOUSE_RIGHT)
            {
                model.rightClick(tile, e.isShiftDown(), new Point(e.getX() + p.getCamera().x,e.getY() + p.getCamera().y),new Point(view.worldPanel.getWidth(), view.worldPanel.getHeight()));
            }

            if(e.getButton() == MOUSE_RIGHT)
            {

            }

            updateHUD();

            /*
                    NOTE:
                        Switching to next player still done in controller
                        FIX THIS SICK FILTH
             *
             *      This cannot be done, the renderer is relative to the current player, which is stored in
             *      the view. Eventually the advancement will be done with a button, and that button will
             *      just have to be modeled in the controller.
             *
             */

            if(e.getButton() == MOUSE_MIDDLE){
                // Old switch turns method commented out

               /*
                    // Check if current player is NOT last player
                if (model.playerList.getList().indexOf(
                    model.playerList.getCurrentPlayer()) <
                    model.playerList.getList().size() - 1) {
                        model.playerList.advancePlayer();
                        view.worldPanel.setPlayer(model.playerList.getCurrentPlayer());
                        view.update();
                } else {
                    // Currently calling controller's changeState directly
                    // make listener?
                        this.controller.changeToAdvance();
                }*/
            }


            return;
        }
        
        public void mouseReleased(MouseEvent e) {
            return;
        }

        public void mouseEntered(MouseEvent e) {
            return;
        }

        public void mouseExited(MouseEvent e) {
            return;
        }

        public void mouseDragged(MouseEvent e) {
            return;
        }

        public void mouseMoved(MouseEvent e) {
            return;
        }
    }

     /*
      *     Listener for action panel
      */

     private class ActionPanelListener
             implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Get description enumeration from button
            MatterStateEnum state =
                        ((AbstractActionPanel.ActionButton)e.getSource()).getEnum();

            model.selected.setState(state);

            switch (state) {
                case buildCity: {
                    // If selected is settler
                    if (model.selected.getClass() == Settler.class) {
                        model.buildCity();
                    }
                }
                case fortify: {
                    model.fortify();
                }
                case improveCity: {
                    model.improveCity();
                }
            }
                        
            updateHUD();

        }
     }

     private class DescriptionPanelListener
             implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //      Note:
            //          FRAGILE CODE!!!
            //          Hooking up JBUTTON in DESCRIPTIONPANELCITYBULD
            //          By TEXT
            //          MAKE BETTER
            
            if (e.getSource().getClass() == JButton.class) {
                if ( ((JButton)e.getSource()).getText().startsWith("Random Unit")) {
                    model.createUnit(model.selected.getTile());
                    updateHUD();
                } 
            }
        }
     }

     private class NextTurnPanelListener
             implements ActionListener {

         StateAction controller;

         public NextTurnPanelListener(StateAction controller) {
             this.controller = controller;
         }

        public void actionPerformed(ActionEvent e) {

            view.setAction(new ActionPanelBlank());
            view.setDescription(new DescriptionPanelBlank());
            
                // Check if current player is NOT last player
            if (model.playerList.getList().indexOf(
                model.playerList.getCurrentPlayer()) <
                model.playerList.getList().size() - 1) {
                    model.nextTurn();
                    view.worldPanel.setPlayer(model.playerList.getCurrentPlayer());
                    view.update();
            } else {
                // Currently calling controller's changeState directly
                // make listener?
                    this.controller.changeToAdvance();
            }
        }
     }

    public void updateHUD() {
        // If something selected, get panels, set listeners
        if (model.selected != null) {
            AbstractDescriptionPanel description = model.selected.getDescription();
            description.setListeners(dpl);
            view.setDescription(description);

            AbstractActionPanel action = model.selected.getAction();
            action.setListeners(apl);
            view.setAction(action);
        }
         // Otherwise set panels to blanks
        else {
            view.setAction(new ActionPanelBlank());
            view.setDescription(new DescriptionPanelBlank());
        }
        view.update();
    }

    private int screenToTile(int x, int bound) {
        //convert x/y coordinate into a tile coordinate

        //if x is negative, make them one tile's width lower
        //this is because the next step uses integer division, which
        //rounds down to lowest ABSOLUTE value and not lowest ACTUAL value
        if(x < 0)
        {
            x-= model.world.GRID_SIZE;
        }

        //convert from xy on screen to tile xy
        return ((x/model.world.GRID_SIZE)+bound)%bound;
    }

}
