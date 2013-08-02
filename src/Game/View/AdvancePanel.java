/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tagibson
 */
public class AdvancePanel
    extends JPanel {
    
    JButton finishAdvance;

    public AdvancePanel() {
        this.add(new JPanel());
        finishAdvance = new JButton("Finish Advancing");

        this.add(finishAdvance);

        this.setBackground(new Color(180, 100, 210));
    }

    public void addListener(ActionListener l) {
        finishAdvance.addActionListener(l);
    }

}
