package GameElements;

import AbstractMatter.Unit;
import Terrain.*;
import Units.*;
import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class World implements Serializable {
    List<Tile> startPositions;
    
    Tile[][] tiles;
    
    private int height;
    private int width;

    public final int GRID_SIZE = 80;

//Temporary for Milestone 2


    public World(List<Player> players) {


        height = 40;
        width = 60;
        tiles = new Tile[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++)
            {
                    tiles[i][j] = new Tile(this,i,j);
            }
        }

        //Temporary
        startPositions = new LinkedList<Tile>();

        startPositions.add(tiles[6][16]);
        startPositions.add(tiles[6][33]);
        startPositions.add(tiles[14][21]);
        startPositions.add(tiles[22][34]);
        startPositions.add(tiles[30][15]);
        startPositions.add(tiles[43][21]);
        startPositions.add(tiles[47][7]);
        startPositions.add(tiles[53][34]);

        //Endtemp


        //give each player their settler
        for(Player p : players)
        {
            Unit settler = new Settler();       //create a settler
            Unit warrior = new Warrior();         //and military unit (make warrior later)
            Unit worker = new Worker();         //and worker

            Tile start = startPositions.get(0);

            Point pos = new Point(start.x*80 - 400,start.y*80 - 400);// REVISE TO PUT IN MIDDLE

            p.addUnit(settler,start);
            p.addUnit(warrior, start.world.getTile(start.x, start.y+1));
            p.addUnit(worker, start.world.getTile(start.x+1,start.y));

            startPositions.remove(0);               //remove that position from list
            p.setCamera(pos);
        }
        //End of Temp
    }

    public World(PlayerList players, String filename, Queue<String> nameQueue, Queue<Color> colorQueue) {

        try {
            BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(
                                        new DataInputStream(
                                        new FileInputStream(filename) )));

                // Tempory data structures created,
                // mostly for easily getting height and width

            List<String> lines = new LinkedList<String>();
            String line = "";

            while ( (line = reader.readLine()) != null) {
                lines.add(line);
            }

            height = lines.size();
            width = lines.get(0).length();

            tiles = new Tile[width][height];

            startPositions = new LinkedList<Tile>();

                // Temporary count variables
            int j = 0, c;

            for (String l : lines) {
                for (int i = 0 ; i < l.length(); i++) {
                    switch (l.toLowerCase().charAt(i)) {
                        case ' ':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.water);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'a':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.ice);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 't':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.ice);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'd':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.desert);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'f':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.grasslands);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'j':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.jungle);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'g':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.jungle);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'm':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.rock);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 's':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.swamp);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'p':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.plains);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case 'h':
                            tiles[i][j] = new Tile(this, i, j, Tile.TerrainEnum.plains);
                            if (l.toLowerCase().charAt(i) != l.charAt(i)) {startPositions.add(tiles[i][j]);}
                            break;
                        case '1':
                            tiles[i][j] = new Tile(this, i, j);
                            startPositions.add(tiles[i][j]);
                            break;
                        default:
                            System.out.println(l.charAt(i));
                            tiles[i][j] = new Tile(this, i, j);
                            break;
                    }

                }
                j++;
            }

            for(int l = 0; l < height; l++)
            {
                for(int k = 0; k < width; k++)
                {
                    int offset = 0;
                    if (l != 0 && tiles[k][l].getTerrain().getClass() != tiles[k][l - 1].getTerrain().getClass())
                    {
                        if( tiles[k][l].getTerrain().getClass() == Water.class && tiles[k][l - 1].getTerrain().getClass() == Ice.class)
                        {
                            //do not offset water compared to ice
                            //we changed the ice type to fade into water instead of
                            //grass so it would look less stupid
                        } else
                        {
                            offset += 1;
                        }

                    }
                    
                    if (tiles[k][l].getTerrain().getClass() != tiles[(k+1)%width][l].getTerrain().getClass())
                    {
                        if( tiles[k][l].getTerrain().getClass() == Water.class && tiles[(k+1)%width][l].getTerrain().getClass() == Ice.class)
                        {
                            //again
                        } else
                        {
                            offset += 2;
                        }
                    }

                    if (l != height-1 && tiles[k][l].getTerrain().getClass() != tiles[k][l + 1].getTerrain().getClass())
                    {
                        if( tiles[k][l].getTerrain().getClass() == Water.class && tiles[k][l+1].getTerrain().getClass() == Ice.class)
                        {
                            //again
                        } else
                        {
                            offset += 4;
                        }
                    }

                    if (tiles[k][l].getTerrain().getClass() != tiles[(k-1 + width)%width][l].getTerrain().getClass())
                    {
                        if( tiles[k][l].getTerrain().getClass() == Water.class && tiles[(k-1+width)%width][l].getTerrain().getClass() == Ice.class)
                        {
                            //again
                        } else
                        {
                            offset += 8;
                        }
                    }
                    tiles[k][l].getTerrain().neighborize(offset*GRID_SIZE);
                }
            }

            /*
            //Temporary
            startPositions = new LinkedList<Tile>();

            startPositions.add(tiles[21][16]);
            startPositions.add(tiles[13][9]);
            startPositions.add(tiles[61][22]);
            startPositions.add(tiles[58][9]);
            startPositions.add(tiles[34][15]);
            startPositions.add(tiles[42][21]);
            startPositions.add(tiles[36][7]);
            startPositions.add(tiles[51][14]);

            //Endtemp
            */

            /*Queue<Color> colorQueue = new LinkedList<Color>();
                colorQueue.add(Color.darkGray);
                colorQueue.add(Color.white);
                colorQueue.add(new Color(136,0,13));
                colorQueue.add(Color.CYAN);
                colorQueue.add(Color.PINK);
                colorQueue.add(Color.BLUE);
                colorQueue.add(Color.ORANGE);
                colorQueue.add(Color.BLACK);

          Queue<String> nameQueue = new LinkedList<String>();
                nameQueue.add("Colton");
                nameQueue.add("Jeremy");
                nameQueue.add("Conti");
                nameQueue.add("Tom");
                nameQueue.add("Pinkie");
                nameQueue.add("Cyanie");
                nameQueue.add("Orangie");
                nameQueue.add("Bill");*/

            for(int i = 0; i < startPositions.size(); i++) {
                if (nameQueue.size() > 0 && colorQueue.size() > 0) {
                    Player newPlayer = new Player(colorQueue.remove(), nameQueue.remove());

                    players.add(newPlayer);

                    if (i == 0) {
                        players.setCurrentPlayer(newPlayer);
                    }

                    newPlayer.playerMask.buildMask(width, height);

                    Unit settler = new Settler();       //create a settler
                    //Unit warrior = new Warrior();         //and military unit (make warrior later)
                    //Unit worker = new Worker();         //and worker

                    Tile start = startPositions.get(i);

                    Point pos = new Point(start.x*80 - 400,start.y*80 - 400);// REVISE TO PUT IN MIDDLE

                    newPlayer.addUnit(settler,start);
                    //newPlayer.addUnit(warrior, start.world.getTile(start.x, start.y+1));
                    //newPlayer.addUnit(worker, start.world.getTile(start.x+1,start.y));

                    newPlayer.setCamera(pos);
                }
            }
        }
        catch (IOException e) {
            //this(players);
            System.out.println("File error");
        }
    }


    public Tile getTile(int x,int y)
    {
      return tiles[x][y];
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWidth()
    {
        return this.width;
    }
}
