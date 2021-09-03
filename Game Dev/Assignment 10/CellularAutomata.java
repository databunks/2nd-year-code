import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

public class CellularAutomata extends JFrame implements Runnable
{
    private static final Dimension WindowSize = new Dimension(800,800); // window dimension object created and size ise set
    private boolean[][][] gameState = new boolean[200][200][2]; // game state variable
    private int xPos, yPos; // int variables deckared
    private Random r = new Random(); // random boolean generator object created

    public CellularAutomata() // constructor for application dimensions, initialisation check and threads handled here
    {
        this.setTitle("Cellular automata"); // set title
        Dimension screensize= java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // set dimensions
        int x = screensize.width/2 -WindowSize.width/2; // set screen width
        int y = screensize.height/2 -WindowSize.height/2; // set screen height
        setBounds(x, y, WindowSize.width, WindowSize.height); // set bounds
        setVisible(true); // set visible
        Thread t = new Thread(this); // creating thread
        t.start(); // starting thread
    }

    public void run()
    {
    
        for (int i = 0; i < 200; i++)
        {
            for (int j = 0; j < 200; j++)
            {
                int res = r.nextInt(101); // generates random number between 0 and 100 inclusive
                if (res >= 60) gameState[i][j][0] = false; // 40% chance wall
                else gameState[i][j][0] = true; // 60% chance floor
            }
        }

        for (int k = 0; k < 4; k++) // loops through 4 generations
        {
            try 
            {
                Thread.sleep(500); // sleep for 500ms
            } 
            catch (InterruptedException e) // catches interrupted exception 
            {
                e.printStackTrace();
            }

            for (int x = 0; x < 200; x++)
            {
                for (int y = 0; y < 200; y++)
                {
                    int wallCount = 0;
                    for (int xx = -1; xx <= 1; xx++)
                    {
                        for (int yy = -1; yy <= 1; yy++) // checks neighbours
                        {
                            xPos = xx + x; // xpos of neighbour 
                            yPos = yy + y; //ypos of neighbour
    
                            if ((xPos != -1 && yPos != -1 && xPos != 200 && yPos != 200) && (xx != 0 || yy != 0)) // checks if neighbours arent outside of array and also if current is not neighbour   
                            {
                                if (gameState[xPos][yPos][0])  // if its a wall
                                {
                                    wallCount++; // increment wall count
                                }
                            }
                        }
                    }
                    if (wallCount >= 5) gameState[x][y][0] = true; // if there are 5 walls or more make it wall
                    else gameState[x][y][0] = false; // make it floor
                }
            }

            for (int i = 0; i < 200; i++)
            {
                for (int j = 0; j < 200; j++)
                {
                    gameState[i][j][1] = gameState[i][j][0]; // transfer buffer
                }
            }
            this.repaint();
        }
    }

    public void paint(Graphics g)
    {
        for (int i = 0; i < 200; i++)  
        {
            for (int j = 0; j < 200; j++)
            {
                if (gameState[i][j][1]) // if current cell is alive in display buffer
                {
                    g.setColor(Color.WHITE); // sets colour to white
                    g.fillRect(i + i*3 , j + j*3 ,4,4); // scaling each cell in array to screen
                }
                else 
                {
                    g.setColor(Color.BLACK); // sets colour to black
                    g.fillRect(i + i*3 , j + j*3 ,4,4); // scaling each cell in array to screen
                }
            }
        }
    }

    public static void main(String [ ] args) 
    {
        CellularAutomata w = new CellularAutomata(); // game runs here
    }
}