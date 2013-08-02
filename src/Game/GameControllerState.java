/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.event.ActionListener;

/**
 *
 * @author tagibson
 */
public interface GameControllerState extends ActionListener {

    public void changeToAction();

    public void changeToResearch();

    public void changeToAdvance();

}
