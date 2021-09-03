import java.awt.*;

public class Sprite2D
{
    protected double x,y; // x,y coords declared here
    protected double xSpeed; // xSpeed declared here
    protected Image myImage; // image declared here
    protected Image secondImage; // second image declared here
    int winWidth; // shows width of window
    private static int frameCount = 0; // shows frame count
    private static boolean toggleSwitchImage = true; // toggle switch initiated

    public Sprite2D(Image i , int windowWidth, boolean isSpaceShip) // sprite2d constructor
    {
        myImage = i; // image set
        winWidth = windowWidth; // window dith set
    }


    public void paint(Graphics g, boolean isSpaceShip, boolean isLaser)
    {
        frameCount++; // increments frame count
        if (frameCount % 50 == 0)  // every 50th frame
        {
            if (toggleSwitchImage == true) toggleSwitchImage = false;     // sets toggleswitchimage to false if true
            else if (toggleSwitchImage == false) toggleSwitchImage = true; // vice versa
        }
        
        if (isSpaceShip) g.drawImage(myImage, (int)x, (int)y, null); // draws spaceship
        if (toggleSwitchImage == true && isLaser == false && isSpaceShip == false) g.drawImage(myImage, (int)x, (int)y, null); // draws aliens first image depending on toggle
        else if (toggleSwitchImage == false && isLaser == false && isSpaceShip == false) g.drawImage(secondImage, (int)x, (int)y, null); // draws alien second image depending on toggle
        if (isLaser == true) g.drawImage(myImage, (int)x, (int)y, null); // draws laser
    }

    public void incrementXspeed(double xSpeed)
    {
        this.xSpeed += xSpeed; // speed is incremented
    }

    public void decrementXspeed(double xSpeed)
    {
        this.xSpeed -= xSpeed; // speed decremented
    }

    public void setXspeed(double xSpeed)
    {
        this.xSpeed = xSpeed; // set xSpeed here
    }

    public void setX(double x)
    {
        this.x = x; // set x coord here
    }

    public double getXspeed()
    {
        return xSpeed; // returns xSpeed
    }

    public double getX()
    {
        return x; // returns x coord
    }

    public double getY()
    {
        return y; // returns y coord
    }
    
}