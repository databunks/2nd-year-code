import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.image.*;
import java.util.Random;

public class GameOfLifeApplication extends JFrame implements Runnable, MouseInputListener
{
    private static final Dimension WindowSize = new Dimension(800,800); // window dimension object created and size ise set
    private BufferStrategy strategy; // buffer strategy variable
    private boolean[][][] gameState = new boolean[40][40][2]; // game state variable
    private int xPos, yPos, alive; // int variables deckared
    private boolean isInitialised,isPlaying; // boolean varibales declared
    private Random randomBool = new Random(); // random boolean generator object created

    public GameOfLifeApplication() // constructor for application dimensions,buffer strategy, initialisation check and threads handled here
    {
        this.setTitle("Conways Game of Life"); // set title
        Dimension screensize= java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // set dimensions
        int x = screensize.width/2 -WindowSize.width/2; // set screen width
        int y = screensize.height/2 -WindowSize.height/2; // set screen height
        setBounds(x, y, WindowSize.width, WindowSize.height); // set bounds
        setVisible(true); // set visible
        createBufferStrategy(2); // pass in buffer strategy
        strategy = getBufferStrategy(); // set it to strategy variable
        isInitialised = true; // set initialisation check
        addMouseListener(this); // adding mouse listener
        Thread t = new Thread(this); // creating thread
        t.start(); // starting thread
    }

    public void run()  // run method
    {
        isPlaying = false; // isPlaying initiliased 
        for (int i = 0; i < 40; i++)
        {
            for (int j = 0; j < 40; j++)
            {
                gameState[i][j][0] = false; // initializing gameState
            }
        }

        while (true) // loop infinitely
        {
            try 
            {
                Thread.sleep(50); // sleep for 50ms
            } 
            catch (InterruptedException e) // catches interrupted exception 
            {
                e.printStackTrace();
            }

            if (isPlaying) // checks if game is in isPlaying mode
            {          
                for (int x = 0; x < 40; x++) // iterates through x dimension 
                {
                    for (int y = 0; y < 40; y++) // iterates through y dimension
                    {
                        alive = 0; // live neighbours initiliased here
                        if (gameState[x][y][0]) // for a cell that is alive
                        {
                            for (int xx = -1; xx <= 1; xx++)     // 
                            {                                    // starts at left diagnol in terms of position to center alive cell and iterates through 3x3 box
                                for (int yy = -1; yy <= 1; yy++) // 
                                {
                                    xPos = xx + x; // xPos of neighbouring cell set
                                    yPos = yy + y; // yPos of neighbouring cell set
                                    if ((xPos != -1 && yPos != -1 && xPos != 40 && yPos != 40) && (xx != 0 || yy != 0) && (gameState[xPos][yPos][0])) alive++; // if neighbouring cell is not outside the screen and it is alive then increment alive counter
                                }
                            }
                            if (alive < 2) gameState[x][y][0] = false; // if there are less than 2 alive dies by underpopulation
                            if (alive > 3) gameState[x][y][0] = false; // if there are more than 3 alive dies by overpopulation
                        }
                        else // if the cell is dead
                        {
                            for (int xx = -1; xx <= 1; xx++)     //
                            {                                    // starts at left diagnol in terms of position to center alive cell and iterates through 3x3 box
                                for (int yy = -1; yy <= 1; yy++) //
                                {
                                    xPos = xx + x; // xPos of neighbouring cell set
                                    yPos = yy + y; // yPos of neighbouring cell set
                                    if ((xPos != -1 && yPos != -1 && xPos != 40 && yPos != 40) && (xx != 0 || yy != 0) && (gameState[xPos][yPos][0])) alive++; // if neighbouring cell is not outside the screen and it is dead then increment alive counter
                                }
                            }
                            if (alive == 3) gameState[x][y][0] = true; // if 3 cells are alive neighbouring the dead cell it becomes live
                        }
                    }
                }
            }

            for (int i = 0; i < 40; i++)
            {
                for (int j = 0; j < 40; j++)
                {
                    gameState[i][j][1] = gameState[i][j][0]; // after rules are set buffer is equal to display buffer
                }
            }

            this.repaint();
        }
        
    }

    public void paint(Graphics g)
    {
        if (!isInitialised) // if it is not initialised
        return; // return

        g = strategy.getDrawGraphics(); // double buffering step done here

        for (int i = 0; i < 40; i++)  
        {
            for (int j = 0; j < 40; j++)
            {
                if (gameState[i][j][1]) // if current cell is alive in display buffer
                {
                    g.setColor(Color.WHITE); // sets colour to white
                    g.fillRect(i + (i*19),j + (j*19),20,20); // scaling each cell in array to screen
                }
                else 
                {
                    g.setColor(Color.BLACK); // sets colour to black
                    g.fillRect(i + (i*19),j + (j*19),20,20); // scaling each cell in array to screen
                }
            }
        }

        if (!isPlaying) // if game is not running
        {
            g.setColor(Color.green);      //
            g.fillRect(50, 35, 150, 50);  // green boxes drawn
            g.fillRect(230, 35, 150, 50); //
            g.setColor(Color.WHITE);
            g.setFont(new Font("isNotPlaying",Font.BOLD,25)); // font set
            g.drawString("Start", 95, 60); // start text box drawn
            g.drawString("Randomize", 240, 60); // randomize text box drawn
        }
        else
        {
            g.setColor(Color.red);        //
            g.fillRect(50, 35, 150, 50);  // red boxes drawn
            g.setFont(new Font("isPlaying",Font.BOLD,25)); // font set
            g.setColor(Color.white);
            g.drawString("Stop", 95, 60); // stop text drawn on red box
        }

        strategy.show(); // double buffering implementation
    }

    public static void main(String [ ] args) 
    {
        GameOfLifeApplication w = new GameOfLifeApplication(); // game runs here
    }

    // MOUSE EVENT LISTENERS

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) 
    {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) 
    {
        xPos = e.getX(); // xPos set to mouse x position
        yPos = e.getY(); // yPos set to mouse y position
        
        if (!isPlaying && (e.getButton() == 1 || e.getButton() == 3)) // checks if is playing is set to true and either left or right mouse button clicked
        {
          xPos = e.getX() / 20; // xPos scaled to each element in gameState array
          yPos = e.getY() / 20; // yPos scaled to each element in gameState array
          if(e.getY() > 85) gameState[xPos][yPos][0] ^=  true; // if not above y = 85 clicked cell set to opposite boolean value

          xPos = e.getX(); // xPos set to mouse x position
          yPos = e.getY(); // yPos set to mouse y position

          if (xPos <= 200 && xPos >= 50 && yPos >= 35 && yPos <= 85) isPlaying = true; // if start box is clicked isPlaying is set to true

          if (xPos <= 380 && xPos >= 200 && yPos >= 35 && yPos <= 85) // if randomize box is clicked 
            {
                for (int i = 0; i < 40; i++)
                {
                    for (int j = 0; j < 40; j++)
                    {
                        gameState[i][j][0] = randomBool.nextBoolean(); // randomizes each box
                    }
                }
            }
          this.repaint(); // repaints
        }
        else if (xPos <= 200 && xPos >= 50 && yPos >= 35 && yPos <= 85 && (e.getButton() == 1 || e.getButton() == 3))  // if stop box is clicked isPlaying is set to false and repaint called
        {
            isPlaying = false;
            this.repaint();
        }

        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        
        
    }

}