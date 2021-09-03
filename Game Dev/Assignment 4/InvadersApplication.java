import javax.swing.JFrame; // import java libraries
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class InvadersApplication extends JFrame implements Runnable, KeyListener // Invader application class
{
    private static final Dimension windowSize = new Dimension(800, 600); // Set window size
    private BufferStrategy strategy; // bufferStrategy variable declared here
    private static final int numAliens = 20; //dynamically generated set to whatever you want
    private Alien[] aliensArray = new Alien[numAliens]; //sets number of aliens
    private SpaceShip playerShip; // playership variable declared under here
    private ImageIcon playerShipImageIcon = new ImageIcon("player_ship.png"); // player ship image generated here here
    private Image playerShipImage = playerShipImageIcon.getImage(); // player ship  image stored in here
    private ImageIcon alienImageIcon = new ImageIcon("alien_ship_1.png"); // alien image generated in here
    private Image alienImage = alienImageIcon.getImage(); // alien image stored in here 
    private int frameCount = 0; // frame counter initialised here
    private int randNum; // randNum variable declared here 
    private Alien defaultAlien = new Alien(alienImage, 800, false, 200, 50, 4); // default alien reference 

    public InvadersApplication() 
    {
        this.setTitle("Poggers vs illuminati"); // title set here
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // screen size is stored here
        int x = screensize.width / 2 - windowSize.width / 2; // x is initialised here
        int y = screensize.height / 2 - windowSize.height / 2; // y is initialised here
        setBounds(x, y, windowSize.width, windowSize.height); // bounds are set here 
        setVisible(true); // boolean parameter passed to setVisible method
        addKeyListener(this); // current object is passed to the addKeyListener method
        createBufferStrategy(2); // numBuffers is passed into createBufferStrategy
        strategy = getBufferStrategy(); // bufferStrategy is stored in strategy variable
                                                                     
        randNum = (int)Math.floor(Math.random()*2);                  // The direction in which the alien goes is randomized here  
        if (randNum == 0) defaultAlien.setXspeed(25);                //
        else if (randNum == 1) defaultAlien.setXspeed(-25);          //

        for (int i = 0; i < numAliens; i++)                                         //
        {                                                                           // Alien array is initialized here
            aliensArray[i] = new Alien(alienImage, 800, false, 200, 50, i);         //
            aliensArray[i].setXspeed(defaultAlien.getXspeed());                     //
        }

        playerShip = new SpaceShip(playerShipImage, 800, true); // Player ship is initialized here
        Thread t = new Thread(this); // New thread is started 
        t.start(); // thread is started here
    }

    public void run() // run method starts
    {
        while (true) // renders each frame
        {
            try 
            {
                Thread.sleep(50); // sleeps
            } 
            catch (InterruptedException e) // catches InterruptedException
            {
                e.printStackTrace();
            }
        
            for(int i = 0; i < numAliens; i++)
            {
                aliensArray[i].move(); // Each alien in the arrays move method is called
            }

            if (aliensArray[0].getAlienX() == 0)
            {
                for (int i = 0; i < numAliens; i++)  
                {
                    aliensArray[i].reverseDirection(); // if the alien at the left (start) hits the left edge it will change direction for all of them
                }
            }
            else if (aliensArray[aliensArray.length - 1].getAlienX() == aliensArray[aliensArray.length - 1].getAlienWinWidth() - 50)
            {
                for (int i = 0; i < numAliens; i++)
                {
                    aliensArray[i].reverseDirection(); // if the alien at the right (end) hits the right edge it will change direction for all of them
                }
            }

            if (frameCount % 2 == 0)
            {
                if (playerShip.getXspeed() > 0) playerShip.decrementXspeed(1);
                else if (playerShip.getXspeed() < 0) playerShip.incrementXspeed(1);  // every second frame the space ship deaccelerates
            }
            playerShip.addXspeed(); // xSpeed is added to the xPos and then changing it
            frameCount++; // framecount is iterated
            this.repaint(); // paint function called
        } 

    }

    // Keylisteners declared under here 
    public void keyPressed(KeyEvent e)
    {
        playerShip.move(e.getKeyCode()); // pressed key is passed into move method
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void paint(Graphics g)
    {
        g = strategy.getDrawGraphics(); // 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

        playerShip.paint(g,true);

        for (int i = 0; i < numAliens; i++) 
        {
            aliensArray[i].paint(g,false);
        }

        strategy.show();
    }

    public static void main(String[] args) throws InterruptedException
    {
        InvadersApplication window = new InvadersApplication();
    }
}


/*
⠄⠄⠄⠄⠄⠄⣀⣀⣀⣤⣶⣿⣿⣶⣶⣶⣤⣄⣠⣴⣶⣿⣿⣿⣿⣶⣦⣄⠄⠄                                                                     
⠄⠄⣠⣴⣾⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦
⢠⠾⣋⣭⣄⡀⠄⠄⠈⠙⠻⣿⣿⡿⠛⠋⠉⠉⠉⠙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿
⡎⣾⡟⢻⣿⣷⠄⠄⠄⠄⠄⡼⣡⣾⣿⣿⣦⠄⠄⠄⠄⠄⠈⠛⢿⣿⣿⣿⣿⣿
⡇⢿⣷⣾⣿⠟⠄⠄⠄⠄⢰⠁⣿⣇⣸⣿⣿⠄⠄⠄⠄⠄⠄⠄⣠⣼⣿⣿⣿⣿
⢸⣦⣭⣭⣄⣤⣤⣤⣴⣶⣿⣧⡘⠻⠛⠛⠁⠄⠄⠄⠄⣀⣴⣿⣿⣿⣿⣿⣿⣿
⠄⢉⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⢰⡿⠛⠛⠛⠛⠻⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠸⡇⠄⠄⢀⣀⣀⠄⠄⠄⠄⠄⠉⠉⠛⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠄⠈⣆⠄⠄⢿⣿⣿⣿⣷⣶⣶⣤⣤⣀⣀⡀⠄⠄⠉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠄⠄⣿⡀⠄⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠂⠄⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠄⠄⣿⡇⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠄⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠄⠄⣿⡇⠄⠠⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠄⠄⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
⠄⠄⣿⠁⠄⠐⠛⠛⠛⠛⠉⠉⠉⠉⠄⠄⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿
⠄⠄⠻⣦⣀⣀⣀⣀⣀⣀⣤⣤⣤⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠄

    `-.`'.-'
                                       `-.        .-'.
                                    `-.    -./\.-    .-'
                                        -.  /_|\  .-
                                    `-.   `/____\'   .-'.
                                 `-.    -./.-""-.\.-      '
                                    `-.  /< (()) >\  .-'
                                  -   .`/__`-..-'__\'   .-
                                ,...`-./___|____|___\.-'.,.
                                   ,-'   ,` . . ',   `-,
                                ,-'   ________________  `-,
                                   ,'/____|_____|_____\
                                  / /__|_____|_____|___\
                                 / /|_____|_____|_____|_\
                                ' /____|_____|_____|_____\
                              .' /__|_____|_____|_____|___\
                             ,' /|_____|_____|_____|_____|_\
,,---''--...___...--'''--.. /../____|_____|_____|_____|_____\ ..--```--...___...--``---,,
                           '../__|_____|_____|_____|_____|___\
      \    )              '.:/|_____|_____|_____|_____|_____|_\               (    /
      )\  / )           ,':./____|_____|_____|_____|_____|_____\             ( \  /(
     / / ( (           /:../__|_____|_____|_____|_____|_____|___\             ) ) \ \
    | |   \ \         /.../|_____|_____|_____|_____|_____|_____|_\           / /   | |
 .-.\ \    \ \       '..:/____|_____|_____|_____|_____|_____|_____\         / /    / /.-.
(=  )\ `._.' |       \:./ _  _ ___  ____ ____ _    _ _ _ _ _  _ ___\        | `._.' /(  =)
 \ (_)       )       \./  |\/| |__) |___ |___ |___ _X_ _X_  \/  _|_ \       (       (_) /
  \    `----'         """"""""""""""""""""""""""""""""""""""""""""""""       `----'    /
   \   ____\__                                                              __/____   /
    \ (=\     \                                                             /     /-) /
     \_)_\     \                                                          /     /_(_/
          \     \                                                        /     /
           )     )  _                                                _  (     (
          (     (,-' `-..__                                    __..-' `-,)     )
           \_.-''          ``-..____                  ____..-''          ``-._/
            `-._                    ``--...____...--''                    _.-'
                `-.._                                                _..-'
                     `-..__                       __..-'
                           ``-..____                  ____..-''
                                    ``--...____...--''
*/