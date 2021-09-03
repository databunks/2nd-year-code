import java.awt.*;

public class Sprite2D
{
    protected double x,y;
    protected double xSpeed;
    protected Image myImage;
    int winWidth;

    public Sprite2D(Image i , int windowWidth, boolean isSpaceShip)
    {
        myImage = i;
        winWidth = windowWidth;
    }


    public void paint(Graphics g, boolean isSpaceShip)
    {
        if (isSpaceShip)
        {
            g.drawImage(myImage, (int)x, (int)y, null);
        }
        else
        {
            g.drawImage(myImage, (int)x, (int)y, null);
        }
    }

    public void incrementXspeed(double xSpeed)
    {
        this.xSpeed += xSpeed;
    }

    public void decrementXspeed(double xSpeed)
    {
        this.xSpeed -= xSpeed;
    }

    public void setXspeed(double xSpeed)
    {
        this.xSpeed = xSpeed;
    }

    public double getXspeed()
    {
        return xSpeed;
    }
    
}