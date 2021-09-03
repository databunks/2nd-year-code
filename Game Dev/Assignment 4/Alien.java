import java.awt.Image;

public class Alien extends Sprite2D
{
    public Alien(Image i, int windowWidth,boolean isSpaceShip, int xStartPos, int yStartPos, int index)
    {
        super(i, windowWidth,isSpaceShip);
        x = xStartPos + (xStartPos + (index * 50)) % (xStartPos + 50);
        y = yStartPos + (Math.floor(index / 5) * 60);

    }

    public void move()
    {
      x += xSpeed;
    }

    public void reverseDirection()
    {
        xSpeed = xSpeed * (-1);
        if (y < 550) y += 5;
    }

    public int getAlienX()
    {
        return (int)x;
    }

    public int getAlienWinWidth()
    {
        return winWidth;
    }

}