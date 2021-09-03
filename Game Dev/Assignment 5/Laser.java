import java.awt.Image;

public class Laser extends Sprite2D
{
    private double ySpeed;
    public Laser(Image i, int windowWidth, boolean isSpaceShip,double x, double y) // laser constructor
    {
        super(i, windowWidth, isSpaceShip); // calls super
        this.x = x; // sets x coord
        this.y = y; // sets y coord
        ySpeed = 10; // sets xSpeed
    }

    public void move()
    {
        y -= ySpeed; // decrements ySpeed making laser go up
    }

}
