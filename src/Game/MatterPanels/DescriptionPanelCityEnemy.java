

package Game.MatterPanels;

import AbstractMatter.City;
import Game.View.AbstractDescriptionPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class DescriptionPanelCityEnemy
    extends AbstractDescriptionPanel {

    JLabel cityNameField;
    City city;

    public DescriptionPanelCityEnemy(City city) {

        this.city = city;

        this.setBackground(backgroundColor);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        cityNameField = new JLabel( city.getName() );

        this.add( new JLabel( city.owner.getPlayerName()) );
        this.add( cityNameField );
    }
}