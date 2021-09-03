import java.awt.Image;

public class SpaceShip extends Sprite2D 
{
    private boolean isDestroyed; // destroyed status declared here
    public SpaceShip(Image i, int windowWidth,boolean isSpaceShip,double x, double y)  // spaceShip constructor
    {
        super(i, windowWidth,isSpaceShip); // calls super class
        xSpeed = 0; // initialises speed
        isDestroyed = false; // initialises destroyed status
        this.x = x; // xPos set
        this.y = y; // yPos set
    }

    public void move(int keyCode) // move method for 
    {
        if (keyCode == 37 && x >= 0) xSpeed -= 1; // depending on the arrow key speed is decremented
        if (keyCode == 39 && x <= winWidth - 50) xSpeed += 1; // depending on the arrow key speed is incremented
    } 

    public void addXspeed() // xSpeed add method
    {
        x += xSpeed; // xSpeed is added

        if (x < 0)  // prevents spaceship from going out of bounds to the left
        {
          xSpeed = 0;
          x = 0;
        }  

        if (x > winWidth - 50) // prevents spaceship from going out of bounds to the right
        {
            xSpeed = 0;
            x = winWidth - 50;
        }
    }

    public void setDestroyed(boolean isDestroyed) // sets spaceship to destroyed
    {
        this.isDestroyed = isDestroyed;
    }

    public boolean getDestroyed() // returns destroyed status
    {
        return isDestroyed;
    }

}