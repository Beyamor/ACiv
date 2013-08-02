package GameElements;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PlayerList implements Serializable {
    private List<Player> list;
    private Player currentPlayer;
    private int playerNum;


    // Old constructor
    public PlayerList(){
        list = new LinkedList();

        //Temporary for Milestone 2
        currentPlayer = new Player(Color.CYAN, "Cyan");
        list.add(currentPlayer);
        
        list.add(new Player(Color.ORANGE, "Orange"));
        list.add(new Player(Color.BLUE, "Blue"));
        list.add(new Player(Color.RED, "Red"));
        list.add(new Player(Color.DARK_GRAY, "Dark Gray"));
        list.add(new Player(Color.WHITE, "White"));
        list.add(new Player(Color.GREEN, "Green"));
        list.add(new Player(Color.YELLOW, "Yellow"));

        //End of Temporary
    }

    // New constructor.
    //  Passing boolean to diffentiate
    // If time, make this take a lsit
    public PlayerList(boolean altConstructor) {
        list = new LinkedList();   
    }
    
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        currentPlayer.setSelected(true);
    }

    public void add(Player player)
    {
        //add a player to the list
        list.add(player);
    }

    public List<Player> getList()
    {
        //return the playerlist
        return list;
    }

    public Player getCurrentPlayer(){
        //return the current player
        return this.currentPlayer;
    }

    public void advancePlayer(){

        this.currentPlayer.setSelected(false);

        //if the list is at the end, reset
        if(list.lastIndexOf(currentPlayer) == list.size() - 1){
            this.currentPlayer = list.get(0);

        //otherwise, go forward
        } else {
            this.currentPlayer = list.get(list.lastIndexOf(currentPlayer) + 1);
        }

        this.currentPlayer.setSelected(true);
    }

}
