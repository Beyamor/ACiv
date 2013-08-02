/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.View;

import AbstractMatter.MatterStateEnum;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author tagibson
 */
public abstract class AbstractActionPanel
    extends JPanel {

    public static final Color backgroundColor = new Color(200, 100, 210);

    public void setListeners(ActionListener listener) {
    }

    // Actionbutton class used in panel to change myEnum
    public class ActionButton
        extends JButton {

        // Enumeration for myEnum panel to create
        MatterStateEnum myEnum;

        public ActionButton(String label, MatterStateEnum newEnum) {
            this.setLabel(label);
            this.myEnum = newEnum;

            Dimension d = new Dimension(495,60);
            this.setPreferredSize(d);
            this.setMinimumSize(d);
            this.setMaximumSize(d);

            this.setFont(new Font("sansserif", Font.BOLD, 32));
        }

        public MatterStateEnum getEnum() {
            return this.myEnum;
        }
    }
}
