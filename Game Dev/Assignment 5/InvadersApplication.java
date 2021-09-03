import javax.swing.JFrame; // import java libraries
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class InvadersApplication extends JFrame implements Runnable, KeyListener // Invader application class
{
    private static final Dimension windowSize = new Dimension(800, 600); // Set window size
    private BufferStrategy strategy; // bufferStrategy variable declared here
    private static final int numAliens = 20; //dynamically generated set to whatever you want
    private Alien[] aliensArray = new Alien[numAliens]; //sets number of aliens
    private SpaceShip playerShip; // playership variable declared under here
    private ImageIcon playerShipImageIcon = new ImageIcon("player_ship.png"); // player ship image icon generated here here
    private Image playerShipImage = playerShipImageIcon.getImage(); // player ship  image stored in here
    private ImageIcon alienImageIcon = new ImageIcon("alien_ship_1.png"); // alien image icon generated in here
    private Image alienImage = alienImageIcon.getImage(); // alien image stored in here 
    private ImageIcon alienImageIcon2 = new ImageIcon("alien_ship_2.png"); // second alien image icon generated here
    private Image alienImage2 = alienImageIcon2.getImage(); // second alien image stored here
    private ImageIcon laserImageIcon = new ImageIcon("lasah.png"); // laser image icon generated here
    private Image laserImage = laserImageIcon.getImage(); // laser image icon stored here
    private static int frameCount,laserCooldownCount = 0; // frame counter initialised here
    private int randNum, alienX,laserX,alienY,laserY,alienWidth,alienHeight,playerShipY,playerShipHeight,lastAlien,playerScore,bestScore,laserDestroyedIndex = 0; // integers declared here
    private Alien defaultAlien = new Alien(alienImage, alienImage2, 800, false, 200, 50, 4); // default alien reference 
    private ArrayList<Laser> lasers = new ArrayList<Laser>(); // alien arraylist declared here
    private ArrayList<Integer> keys = new ArrayList<Integer>(); // keys arraylist declared here
    private boolean allDestroyed,loopCheck,isInitialised,laserCooldown; // boolean variables declared here
    private int waveCount = 1; // wavecount declared here
    
    public InvadersApplication() 
    {
        this.setTitle("Space invaders"); // title set here
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // screen size is stored here
        int x = screensize.width / 2 - windowSize.width / 2; // x is initialised here
        int y = screensize.height / 2 - windowSize.height / 2; // y is initialised here
        setBounds(x, y, windowSize.width, windowSize.height); // bounds are set here 
        setVisible(true); // boolean parameter passed to setVisible method

        alienWidth = alienImage.getWidth(null); // alien image width stored here
        alienHeight = alienImage.getHeight(null); // alien image height stored here
        playerShipHeight = playerShipImage.getHeight(null); // player ship image height stored here

                                                                     
        randNum = (int)Math.floor(Math.random()*2);                  // The direction in which the alien goes is randomized here  
        if (randNum == 0) defaultAlien.setXspeed(10);                //
        else if (randNum == 1) defaultAlien.setXspeed(-10);          //

        for (int i = 0; i < numAliens; i++)                                             // 
        {                                                                               // Alien array initialised here
            aliensArray[i] = new Alien(alienImage,alienImage2, 800, false, 200, 50, i); //          
            aliensArray[i].setXspeed(defaultAlien.getXspeed());                         //
        }

        playerShip = new SpaceShip(playerShipImage, 800, true,300,550); // Player ship is initialized here
        playerShipY = (int)playerShip.getY(); // playership y value stored here
        Thread t = new Thread(this); // New thread is started 
        t.start(); // thread is started here

        addKeyListener(this); // current object is passed to the addKeyListener method

        createBufferStrategy(2); // numBuffers is passed into createBufferStrategy
        strategy = getBufferStrategy(); // bufferStrategy is stored in strategy variable
        isInitialised = true; // initialised check set here
    }

    public void run() // run method starts
    {
        while (!playerShip.getDestroyed()) // renders each frame if playership is not destroyed
        {
            try 
            {
                Thread.sleep(50); // sleeps for 50 ms
            } 
            catch (InterruptedException e) // catches InterruptedException
            {
                e.printStackTrace();
            }

            allDestroyed = true; // all destroyed check set to true

            for (int i = 0; i < numAliens;i++)                                     // this section checks for if all the aliens have been destroyed
            {                                                                      //
                if (aliensArray[i].getDestroyed() == false) allDestroyed = false;  //
            }                                                                      //

            if (allDestroyed == true)                                                            // if all the aliens are destroyed
            {
                for (int i = 0; i < numAliens; i++)                                              // aliens are reset
                {                                                                                //
                  aliensArray[i] = new Alien(alienImage,alienImage2, 800, false, 200, 50, i) ;   //    
                  aliensArray[i].setXspeed(defaultAlien.getXspeed() + 10);                       //
                }
                waveCount++;                                                                    // wave count incremented
            }
            
        
            for(int i = 0; i < numAliens; i++)
            {
                aliensArray[i].move(); // Each alien in the arrays move method is called
            }

            if (aliensArray[0].getX() <= 160)
            {
                for (int i = 0; i < numAliens; i++)  
                {
                    aliensArray[i].reverseDirection(); // if the alien at the left (start) hits the left edge it will change direction for all of them
                }
            }
            else if (aliensArray[aliensArray.length - 1].getX() >= aliensArray[aliensArray.length - 1].getAlienWinWidth() - 50)
            {
                for (int i = 0; i < numAliens; i++)
                {
                    aliensArray[i].reverseDirection(); // if the alien at the right (end) hits the right edge it will change direction for all of them
                }
            }

            lastAlien = 0; // last alien index initialised

            for (int i = 0; i < aliensArray.length; i++)
            {
                if (!aliensArray[i].getDestroyed()) lastAlien = i; // checks for last alien alive
            }

            alienY = (int)aliensArray[lastAlien].getY(); // sets the y for the last alien alive to be checked later for collision
            
            if (playerShipY <= alienY + (playerShipHeight / 2)) // checks for collision with the space ship with the bottom most alien in the array
            {
                playerShip.setDestroyed(true); // sets the alien to destroyed if collision is  checked
            }

            loopCheck = true; // loop check set to true
            if (!allDestroyed) // if they arent destroyed
              {
                for (int i = 0; i < lasers.size(); i++) // goes through alien array list 
                {
                    lasers.get(i).move(); // moves each alien
                    for (int j = 0; j < aliensArray.length;j++)
                    {
                        alienX = (int)aliensArray[j].getX(); // sets the x value for current alien in the array 
                        alienY = (int)aliensArray[j].getY(); // sets the y value for the current alien in the array
                        laserX = (int)lasers.get(i).getX(); // sets the x value for the current laser in the array
                        laserY = (int)lasers.get(i).getY(); // sets the y value for the current laser in the array
                        
                        if (alienX >= laserX - (alienWidth / 2) && alienX <= laserX + (alienWidth / 2) && alienY >= laserY - (alienHeight / 2) && alienY <= laserY + (alienHeight / 2) && !aliensArray[j].getDestroyed()) // checks for collison with laser and alien does not check if alien is already destroyed 
                        {
                            aliensArray[j].setDestroyed(); // sets the alien to destroyed if collision found
                            laserDestroyedIndex = i; // stores the index at which the alien was destroyed
                            loopCheck = false; // loopcheck is set to false
                            playerScore += 10; // player score implemented
                        }
                    }
                    if (lasers.get(i).getY() <= 0) lasers.remove(i); // removes laser if it goes out of screen
                    if (loopCheck == false) lasers.remove(laserDestroyedIndex); // removes laser once it hits an alien
               }
            } 
              
            for (int i = 0; i < keys.size();i++)
            {
                playerShip.move(keys.get(i)); // moves current key into playership.move method

                if ((keys.get(i) == 32) && laserCooldown == false) // if lasercooldown is false and spacebar is hit then
                   {      
                     lasers.add(new Laser(laserImage, 0, false, playerShip.getX(), playerShip.getY())); // make a new laser if if statement is triggered
                     laserCooldown = true; // cooldown is set
                   } 
            }
            
            if (frameCount % 2 == 0) // every second frame
            {
                if (playerShip.getXspeed() > 0) playerShip.decrementXspeed(1); // space ship deaccelerates if going right
                else if (playerShip.getXspeed() < 0) playerShip.incrementXspeed(1);  // space ship deaccelerates if going left
            }
            playerShip.addXspeed(); // xSpeed is added to the xPos and then changing it
            frameCount++; // framecount is iterated
            laserCooldownCount++; // cooldown count is set

            if (laserCooldownCount > 10) // every 10 frames
            {
                laserCooldownCount = 0; // cooldown reset
                laserCooldown = false; // cooldown set to false
            }
            if (playerScore > bestScore) bestScore = playerScore; // best score is set to current score if it is greater
            while (playerShip.getDestroyed()) // if the spaceShip is destroyed : 
            {
    
                for (int i = 0; i < numAliens; i++) // goes through whole alien array                                        
                {                                                                         
                    aliensArray[i] = new Alien(alienImage,alienImage2, 800, false, 200, 50, i); // aliens are reset         
                    aliensArray[i].setXspeed(defaultAlien.getXspeed());                         //
                }
                playerShip.setX(300); // playership position reset 
                this.repaint(); // repaint function is called
            }
         
            this.repaint(); // repaint function called
        } 

    }

    // Keylisteners declared under here 

    public void keyPressed(KeyEvent e) // if key is pressed
    {
        if (!keys.contains(e.getKeyCode()) && !playerShip.getDestroyed()) //
        {
            if(e.getKeyCode() != 32) keys.add(e.getKeyCode()); // pressed key is passed into move method
            if (e.getKeyCode() == 32 && laserCooldown == false) keys.add(e.getKeyCode()); // if the spacebar is hit and the cooldown is false add it into the keyCode array
        }

        if (playerShip.getDestroyed()) // if the playership is destroyed
        {
            playerShip.setDestroyed(false); // its set to false
            playerScore = 0; // playerscore reset
        }
    }

    public void keyReleased(KeyEvent e) // if key is released
    {
        if (!playerShip.getDestroyed()) // if playership isnt destroyed
        {
           for (int i = 0; i < keys.size();i++)
           {
             if(e.getKeyCode() == keys.get(i)) keys.remove(i); // get rid of all the keys similar to the keycode removed
           }
        }
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void paint(Graphics g)
    {
        if (!isInitialised) // if it is not initialised
        return; // return

        g = strategy.getDrawGraphics(); // buffer strategy set here
        g.setColor(Color.BLACK); // colour set to black
        g.fillRect(0, 0, 800, 600); // draws over whole screen black box
        g.setColor(Color.WHITE); // colour set to white

        if (playerShip.getDestroyed()) // if playership is destroyed
        {
            g.setFont(new Font("Game over",Font.BOLD,75)); // game over font set
            g.setColor(Color.RED); // colour set to red
            g.drawString("Game Over", 200, 300); // game over display
            g.setColor(Color.WHITE); // colour set to white
            g.setFont(new Font("Game over",Font.BOLD,25)); // new font size
            g.drawString("You survived " + (waveCount - 1) + " waves", 250, 400); // shows waves survived
            g.drawString("You scored " + playerScore + " points this game", 250, 435); // shows score for game
            g.drawString("Your best score is : " + bestScore, 250, 470); // shows best score
            g.drawString("Press any key to start game", 250, 505); // instrunctions on how to start game
        }

        if (!playerShip.getDestroyed()) // if playership isnt destroyed
        {
            g.drawString("Current score : " + playerScore, 50, 50); // shows current score
            g.drawString("Best score : " + bestScore, 50, 75); // shows best score
            g.drawString("Wave : " + waveCount, 700, 50); // shows wave
            playerShip.paint(g,true,false); // paints playership

            for (int i = 0; i < lasers.size(); i++)
            {
                lasers.get(i).paint(g,false,true); // paints lasers
            }

            for (int i = 0; i < numAliens; i++) 
            {
                if(!aliensArray[i].getDestroyed()) aliensArray[i].paint(g,false,false); // paints aliens
            }
        }
        strategy.show(); // shows buffer strategy
    }

    

    public static void main(String[] args) throws InterruptedException
    {
        InvadersApplication window = new InvadersApplication(); // application started
    }
}

