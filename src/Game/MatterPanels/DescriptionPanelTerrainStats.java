/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.MatterPanels;

import AbstractMatter.Terrain;
import Game.View.AbstractDescriptionPanel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DescriptionPanelTerrainStats
    extends AbstractDescriptionPanel {

    public DescriptionPanelTerrainStats(Terrain terrain) {
        this.setBackground(backgroundColor);
        int fontSize = 26;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JPanel panel;
        JLabel j;

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));;
        j = new JLabel("Attack Modifier: " + Float.toString(terrain.attackModifier)+"x");
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Defense Modifier: " + Float.toString(terrain.defenseModifier)+"x");
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Movement Modifier: " + Float.toString(terrain.movementModifier)+"x");
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Food: " + Integer.toString(terrain.food));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Economy: " + Integer.toString(terrain.economy));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Production: " + Integer.toString(terrain.production));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel(terrain.getClass().toString());
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

    }

}