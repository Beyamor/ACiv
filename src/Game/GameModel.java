package Game;

import GameElements.*;
import Units.*;
import AbstractMatter.*;
import Cities.*;
import GameElements.PlayerList;
import GameElements.World;
import java.io.Serializable;
import aciv.*;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameModel extends AbstractModel implements Serializable, NewInterface {

    private static final int MINIMUM_MP_TO_FORTIFY = 3;
    private static final int IMPROVE_CITY_PRODUCTION = 100;

    PlayerList playerList;
    World world;
    int currentTurn;
    public AbstractMatter selected;
    MusicController music = new MusicController();
    Thread thread;
    boolean turnNotInterupted;

    public GameModel() {

    }

    //New Game
    public GameModel(PlayerList playerList, World world) {
        this.playerList = playerList;
        this.world = world;
        music = new MusicController();
        thread=new Thread(music);
        thread.start();
        turnNotInterupted=true;
    }
    
    public void leftClick(Tile tile, boolean shift){
        if(shift)
        {
            
        }
        else
        {
            select(tile);
        }


    }

    //Points 'target' and 'worldbound' are extra data included to allow camera movement
    public void rightClick(Tile tile, boolean shift, Point target, Point worldBound){
        if(shift)
        {
            setCamera(target,worldBound);
        }
        else
        {
            if(selected == null || selected.getClass().getSuperclass() == Terrain.class)
            {
                setCamera(target,worldBound);
            }
            else if (selected != null)
            {
                AbstractMatterAction(tile);
            }
        }
        
    }

    private void WGIHWUGO() {

        int test;

        System.out.println("blork");
    }

    private void AbstractMatterAction(Tile tile) {
        if (selected.getClass().getSuperclass() == City.class) {
            if (selected.tile == tile) {
                createUnit(tile);
            }
        }
        if (selected.getClass().getSuperclass() == Unit.class) {
            move(tile);
        }
    }
    
    public void middleClick(Tile tile, boolean shift){
        
    }

    public AbstractMatter select(Tile tile) {
        //check if selected is in the tile, if it is, take the index before
        //else take the last index

        List<AbstractMatter> ab = tile.getAbstractMatterList();

        int index = ab.size() - 1;
        
        for(int i = ab.size() - 1; i >= 0; i--)
        {
            if(ab.get(i) == selected && i != 0)
            {
                index = i-1;
            }
        }

        selected = ab.get(index);

        return selected;
    }

    public void buildCity() {
        Player p = playerList.getCurrentPlayer();

        if(selected.owner == p && selected.getTile().getCity() == null)
        {
            music.toCity();
            thread.interrupt();//playing battle button
          
            City city = new SmallCity();

            p.addCity(city, selected.getTile());
            p.removeUnit((Unit)selected);
            selected = city;
        }

    }


    public AbstractMatter createUnit(Tile tile) {
           //get the current player
            Player p = playerList.getCurrentPlayer();

            //if you click on a city thant doesn't contain a unit, add a unit there
            
                Unit temp = null;
                City c = selected.getTile().getCity();

                while(c.PP >= 100 && !c.getTile().containsUnit())
                {

                if(temp != null && c.PP >= temp.Production)
                {
                    music.toUnit();
                    thread.interrupt();//playing battle button
                  
                    p.addUnit(temp, tile);   //add it to playerlist

                    c.produce(temp.Production);

                    selected = temp;
                }
                else
                {
                    if(!tile.containsUnit())
                        {


                        Random gen = new Random();

                            switch(gen.nextInt(13)){
                                case 0:
                                    temp = new Archer();
                                    break;
                                case 1:
                                    temp = new Armoredbear();
                                    break;
                                case 2:
                                    temp = new Axeman();
                                    break;
                                case 3:
                                    temp = new Ballista();
                                    break;
                                case 4:
                                    temp = new BearWarrior();
                                    break;
                                case 5:
                                    temp = new Bearman();
                                    break;
                                case 6:
                                    temp = new Crossbowman();
                                    break;
                                case 7:
                                    temp = new Flamebowman();
                                    break;
                                case 8:
                                    temp = new Settler();
                                    break;
                                case 9:
                                    temp = new Spearman();
                                    break;
                                case 10:
                                    temp = new Swordsman();
                                    break;
                                case 11:
                                    temp = new Worker();
                                    break;
                                case 12:
                                    temp = new Worker();
                                    break;
                                default:
                                    temp = new Warrior();
                                    break;
                            }

                        }
                }
                }

            return selected;
    }

    public void move(Tile dest)
    {
        if(selected.getClass().getSuperclass() == Unit.class)
        {
            Unit selectedUnit = (Unit)selected;

            //get the current player
            Player p =  playerList.getCurrentPlayer();
            Point dp = dest.getPoint();

            Point up = selectedUnit.tile.getPoint();
            Tile np;

            while(dp != selectedUnit.tile.getPoint())
            {
                up = selectedUnit.tile.getPoint();

                int a = 0;
                int b = 0;

                if (dp.x == up.x)
                {
                    a = 0;
                } else if(
                        (up.x < (dp.x + world.getWidth()/2)
                        && up.x > dp.x)

                        ||up.x < (dp.x + world.getWidth()/2)%world.getWidth()
                        && up.x < (dp.x - world.getWidth()/2)
                        )
                {
                    a = -1;
                } else {
                    a = 1;
                }

                if(dp.y > up.y)
                {
                    b = 1;

                } else if (dp.y < up.y){
                    b = -1;
                }
                
                np = world.getTile((up.x + a + world.getWidth())%world.getWidth(),(up.y + b)%world.getHeight());

                if(!np.containsUnit() && selected.owner == p && selectedUnit.MP >= (float)np.getMovement() && !np.getTerrain().water)
                {
                    selectedUnit.move(np);

                    try {
                        Thread.sleep(275);
                        setChanged();
                        notifyObservers();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if(np == dest && np.containsUnit() && np.getUnit().owner != p && selectedUnit.owner == p){
                    if (turnNotInterupted){
                        music.toBattle();
                        thread.interrupt();//playing battle button
                        turnNotInterupted=false;
                    }
                    Unit attacker = selectedUnit;
                    Unit defender = np.getUnit();

                    int defense = defender.Defense;


                    if(defender.getFortify())
                    {
                        defense *= 2;
                    }

                    int damage = (int)
                            (
                            attacker.Attack * attacker.tile.getTerrain().attackModifier
                            - (defense) * defender.tile.getTerrain().defenseModifier
                            );

                    if(damage >= 0)
                    {
                        if(attacker.MP >= 0.2)
                        {
                            attacker.MP -= 0.2f;
                            defender.HP -= damage;
                        }
                        else
                        {
                            break;
                        }

                    } else
                    {
                        if(attacker.MP >= 0.2)
                        {
                            attacker.MP -= 0.6;
                            attacker.HP += damage;
                        }
                        else
                        {
                            break;
                        }

                    }



                    if(attacker.HP <= 0)
                    {
                        selected = null;

                        for(int i = -1; i < 2; i++)
                        {
                            for(int j = -1; j < 2; j++)
                            {
                                    attacker.owner.getPlayerMask().fogMask[((attacker.tile.getPoint().x + i) + attacker.owner.getPlayerMask().fogMask.length)%attacker.owner.getPlayerMask().fogMask.length][((attacker.tile.getPoint().y + j) + attacker.owner.getPlayerMask().fogMask[0].length)%attacker.owner.getPlayerMask().fogMask[0].length] = 2;
                            }
                        }               //hey ouhey ouhey ouhey ouhey ouhey ouhey ouhey ouhey ouhey ouhey ouhey ouhey ou maybe it keeps a dead unit?

                        attacker.remove();

                    }
                    if(defender.HP <= 0)
                    {

                        for(int i = -1; i < 2; i++)
                        {
                            for(int j = -1; j < 2; j++)
                            {
                                    defender.owner.getPlayerMask().fogMask[((defender.tile.getPoint().x + i) + defender.owner.getPlayerMask().fogMask.length)%defender.owner.getPlayerMask().fogMask.length][((defender.tile.getPoint().y + j) + defender.owner.getPlayerMask().fogMask[0].length)%defender.owner.getPlayerMask().fogMask[0].length] = 2;
                            }
                        }
                        
                        defender.owner.removeUnit(defender);
                        
                        attacker.move(np);
                        attacker.MP = 0;
                    }
                    checkPlayers();
                    break;


                } else {
                    break;
                }

            }

            if(dest == selectedUnit.tile && selectedUnit.tile.getCity() != null && selectedUnit.tile.getCity().owner != p)
            {
                    City nc = selectedUnit.tile.getCity();
                    selectedUnit.tile.getCity().owner.removeCity(nc);

                    nc.owner = p;
                    p.addCity(nc, selectedUnit.tile);

                    selectedUnit.move(dest);
                    selectedUnit.MP = 0;
                    checkPlayers();
                    
            }



        }
    }

    public void win(Player p)
    {
        this.setChanged();
        this.notifyObservers();
        
        for(;;){}

    }

    public void checkPlayers()
    {
        List<Player> deathlist = new LinkedList<Player>();
        
        
        for(Player p : playerList.getList())
        {
            List<AbstractMatter> units = p.getUnitList().getAbstractMatterList();
            List<AbstractMatter> cities = p.getCityList().getAbstractMatterList();          

            if(units.size() + cities.size() == 0)
            {
                deathlist.add(p);
            }
        }

        for(Player aboutToDie : deathlist)
        {
            playerList.getList().remove(aboutToDie);
        }

        if(playerList.getList().size() == 1)
        {
            win(playerList.getList().get(0));
        }
    }


    public void resetTurn()
    {


        for(Player p : playerList.getList())
        {


            List<AbstractMatter> units = p.getUnitList().getAbstractMatterList();
            List<AbstractMatter> cities = p.getCityList().getAbstractMatterList();

            for(int i = 0; i < units.size(); i++)
            {
                Unit temp = (Unit)units.get(i);
                temp.MP = (float)temp.Movement;
                temp.HP = clamp((int)(temp.HP + (10 * ((float)temp.HP/(float)temp.Health))),0,temp.Health);
            }

            for(int j = 0; j < cities.size(); j++)
            {
                City temp = (City)cities.get(j);
                temp.PP = temp.Production;
            }

        }


    }

    public void setCamera(Point cam, Point worldBound) {
        //clamp the camera in the world boundaries (offset by panelsize/2 to center it)

        //the x is clamped with one screen's width allowed to overhang on either side of the map
        int x = clamp(cam.x - worldBound.x/2,  - worldBound.x, world.getWidth() * world.GRID_SIZE);
        //the y is clamped inside the map
        int y = clamp(cam.y - worldBound.y/2, 0, world.getHeight() * world.GRID_SIZE - worldBound.y);


        //if the screen overhangs more than 3/4s on the left or right of the map, move it "around the
        //world" so that it's back inside
        if(x > world.getWidth() * world.GRID_SIZE -(worldBound.x/4)){
            x -= world.getWidth() * world.GRID_SIZE;
        }
        if(x < (-3*worldBound.x)/4){
            x += world.getWidth() * world.GRID_SIZE;
        }

        Point n = new Point(x,y);
        playerList.getCurrentPlayer().setCamera(n);
    }
    
    public int clamp(int num, int min, int max){
         if(num <= min)
         {
             return min;
         }
         if(num >= max)
         {
             return max;
         }
         return num;
     }

    public void nextTurn() {
        music.stop();
        
        thread.interrupt();
        turnNotInterupted=true;
        playerList.advancePlayer();
        selected = null;
        this.setChanged();
        this.notifyObservers();

        endFortify();
    }

    public Player getCurrentPlayer() {
        return playerList.getCurrentPlayer();
    }

    public void fortify() {
        if ( selected.getClass().getSuperclass() == Unit.class) {
            if ( ((Unit)selected).MP >= MINIMUM_MP_TO_FORTIFY) {
                ((Unit)selected).setFortify(true);
                ((Unit)selected).MP = 0;
            }
        }
    }

    public void endFortify() {
        for (AbstractMatter u : playerList.getCurrentPlayer().getUnitList().getAbstractMatterList()) {
            ((Unit)u).setFortify(false);
        }
    }

    public void improveCity() {
        if ( selected.getClass() == Worker.class ) {
            Tile tile = selected.getTile();

            if ( tile.getCity() != null ) {

                ((Unit)selected).owner.removeUnit( (Unit)selected );
                tile.getCity().Production += IMPROVE_CITY_PRODUCTION;
                tile.getCity().PP += IMPROVE_CITY_PRODUCTION;
                selected = tile.getCity();
            }
        }
    }
}
