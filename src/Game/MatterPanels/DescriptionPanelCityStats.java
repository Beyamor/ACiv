

package Game.MatterPanels;

import AbstractMatter.City;
import Game.View.AbstractDescriptionPanel;
import Game.View.HUDPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DescriptionPanelCityStats
    extends AbstractDescriptionPanel
    implements ActionListener {
  
    JLabel cityName;
    JTextField cityNameField;
    City city;

    public DescriptionPanelCityStats(City city) {

        this.city = city;
        
        this.setBackground(backgroundColor);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        cityNameField = new JTextField();
        cityNameField.setText(city.getName());
        cityNameField.addActionListener(this);
        cityNameField.setMaximumSize(new Dimension(HUDPanel.DESCRIPTION_WIDTH, 20));
        
        cityName = new JLabel( city.owner.getPlayerName());

        this.add( cityName );
        this.add( cityNameField );
    }

    public void actionPerformed(ActionEvent e) {

        cityName.setText( ((JTextField)e.getSource()).getText() );
        city.setName( ((JTextField)e.getSource()).getText() );
        ((JTextField)e.getSource()).setText("");
    }
}