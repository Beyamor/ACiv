/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MenuElements;

import aciv.*;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tagibson
 */
public class MenuModel extends AbstractModel {

    Queue<String> playerNames;
    Queue<Color> playerColors;

    public MenuModel() {
        playerNames = new LinkedList<String>();
        playerColors = new LinkedList<Color>();
    }

    public void addPlayer(String name, Color color) {
        playerNames.add(name);
        playerColors.add(color);
    }

    public Queue<String> getPlayerNames() {
        return playerNames;
    }

    public Queue<Color> getPlayerColors() {
        return playerColors;
    }

}
