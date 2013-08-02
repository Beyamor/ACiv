/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.MatterPanels;

import AbstractMatter.City;
import Game.View.AbstractDescriptionPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Game.View.HUDPanel;

/**
 *
 * @author tagibson
 */
public class DescriptionPanelCityAll
    extends AbstractDescriptionPanel
    implements ActionListener {

    JButton build;
    City city;
    JLabel cityName;

    public DescriptionPanelCityAll(City city) {
        this.setBackground(backgroundColor);

        JTextField cityNameField;
        
        this.city = city;

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        cityNameField = new JTextField();
        cityNameField.setText("");
        cityNameField.addActionListener(this);
        cityNameField.setMaximumSize(new Dimension(HUDPanel.DESCRIPTION_WIDTH, 30));

        // Spacer
        this.add( new JLabel(" "));

        int fontSize = 26;

        cityName = new JLabel("City name: " + city.getName() );
        cityName.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        this.add ( cityName );

        cityNameField.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        this.add( cityNameField );
        
        // Spacer
        this.add( new JLabel(" "));
        this.add( new JLabel(" "));

        JLabel jl = new JLabel( "Production: " + city.PP + "/" +  city.Production);
        jl.setFont(new Font("sansserif", Font.PLAIN, fontSize));
        this.add ( jl );

        this.add( new JLabel(" "));

        build = new JButton( "Random Unit" );
        Dimension d = new Dimension(HUDPanel.DESCRIPTION_WIDTH,100);
        build.setPreferredSize(d);
        build.setMinimumSize(d);
        build.setMaximumSize(d);
        build.setFont(new Font("sansserif", Font.BOLD, 30));
        build.setFocusable(false);
        this.add( build );
    }

    public void actionPerformed(ActionEvent e) {

        cityName.setText( "City name: " +  ((JTextField)e.getSource()).getText());
        city.setName( ((JTextField)e.getSource()).getText() );
        ((JTextField)e.getSource()).setText("");
    }


    @Override
    public void setListeners(ActionListener listener) {
        build.addActionListener(listener);
    }

}