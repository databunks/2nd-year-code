import java.awt.Image;

public class Alien extends Sprite2D
{
    private boolean isDestroyed = false; // isDestroyed initiliased here
    public Alien(Image i, Image i2, int windowWidth,boolean isSpaceShip, int xStartPos, int yStartPos, int index) // constructor for alien
    {
        super(i, windowWidth,isSpaceShip); // calls super for alien
        x = xStartPos + (xStartPos + (index * 50)) % (xStartPos + 50); // x position for alien set here (dynamically generated)
        y = yStartPos + (Math.floor(index / 5) * 60); // y position for alien set here (dynamically generated)
        secondImage = i2; // second image set here
    }

    public void move()
    {
      x += xSpeed; // moves according to xSpeed
    }

    public void reverseDirection()
    {
        xSpeed = xSpeed * (-1); // reverses direction
        if (y < 550) y += 15; // if it hits the bottom stops moving down so it doesent go out of screen
    }

    public int getAlienWinWidth()
    {
        return winWidth; // returns width of screen for alien
    }

    public void setDestroyed()
    {
        isDestroyed = true; // sets alien to destroyed
    }

    public boolean getDestroyed()
    {
        return isDestroyed; // gets destroyed status
    }

}