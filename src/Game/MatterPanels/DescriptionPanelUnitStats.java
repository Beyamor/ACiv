package Game.MatterPanels;

import AbstractMatter.Unit;
import Game.View.AbstractDescriptionPanel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DescriptionPanelUnitStats
    extends AbstractDescriptionPanel {

    public DescriptionPanelUnitStats(Unit unit) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(backgroundColor);
        int fontSize = 26;

        JPanel panel;
        JLabel j;

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Health: " + Integer.toString(unit.HP) + " / " + Integer.toString(unit.Health));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel( "Movement: " + Float.toString(Math.round((unit.MP * 1000))/1000f) + " / " + Integer.toString(unit.Movement));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Atk: " + Integer.toString(unit.Attack) + "       Dfn: " + Integer.toString(unit.Defense));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel("Production: " + Integer.toString(unit.Production));
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel(unit.subtype.getName() + " " + unit.type.getName());
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);

        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        j = new JLabel(unit.getClass().toString());
        j.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        panel.add(j);
        this.add(panel);
    }

}