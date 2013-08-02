package MenuElements;

import Game.*;
import aciv.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MenuView extends AbstractView
        implements ActionListener {

    MenuButton newGame;
    JTextArea controls;
    MusicController music;
    Thread thread;

    JTextField playerName;
    JColorChooser colorChooser;
    JButton addPlayer;
    
    public MenuView(AbstractModel model) {
        this.setBackground(Color.black);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.model = model;
        /*
        music = new MusicController();
        
       
        thread=new Thread(music);

        thread.start();
        music.toFox();
        thread.interrupt();
         *
         */
        
        


        JButton startGame = new JButton("Start");
        this.add(startGame);
        startGame.addActionListener(this);
        
            // Note:
            //  newGame button set to gameState to jump right into game
            // Change this when actualy new game state implemented
        newGame = new MenuButton("New Game", GameRunner.State.gameState);

        playerName = new JTextField(32);
        playerName.setMaximumSize( new Dimension(500, 30));

        colorChooser = new JColorChooser();
        colorChooser.setMaximumSize( new Dimension(500, 400));

        addPlayer = new JButton("Add player");

        add( new JLabel(""));

        String s =
        "TEAM AWESOME:\n\n" +
        "Seng Nerds:\n" +
        "Daniel Conti\n" +
        "Tom Gibson\n" +
        "Jeremy Mohr\n" +
        "Colton Phillips\n\n" +
        "Concept Art:\n" +
        "Chris 'Gensexy' Gensey\n\n" +
        "Art and Sound:\n" +
        "Lee Daniel Gauthier\n\n" +
        "Controls\n" +
        "========\n\n" +
        "Nothing Selected:\n" +
        " -Left Click to select something\n" +
        " -Right Click to move camera\n\n" +
        "Unit Selected:\n" +
        " -Right click to move/attack\n\n" +
        "Build Units by selecting a city and clicking build\n" +
        "Take cities by placing units into enemy cities\n\n";

        controls = new JTextArea(s,4,4);
        controls.setEditable(false);
        controls.setFont(new Font("sansserif", Font.PLAIN, 20));
        controls.setForeground(Color.white);
        controls.setBackground(Color.black);

        this.add(controls);
        //music.playFox();

    }

    public String getPlayerName() {
        return playerName.getText();
    }

    public void clearPlayerName() {
        playerName.setText("");
    }

    public Color getPlayerColor() {
        return colorChooser.getColor();
    }

    public void gotoNewGame() {
        this.removeAll();


        this.add(newGame);

        this.add( new JLabel(" ") );
        this.add( new JLabel(" ") );
        this.add( new JLabel(" ") );

        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp,BoxLayout.X_AXIS));
        jp.add(playerName);
        jp.add(colorChooser);
        this.add(jp);

        this.add( new JLabel(" ") );

        this.add(addPlayer);

        this.validate();
        this.repaint();
    }


    public void addListeners(ActionListener listener) {
        newGame.addActionListener(listener);
        addPlayer.addActionListener(listener);
    }

    public void actionPerformed(ActionEvent e) {
        gotoNewGame();
    }

    public class MenuButton
        extends JButton {

        private GameRunner.State state;

        public MenuButton(String text, GameRunner.State state) {
            this.setText(text);
            this.state = state;

        }

        public GameRunner.State getState() {
            //music.stop();
            return this.state;
        }
    }
}
