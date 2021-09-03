import java.awt.*;

public class Sprite2D
{
    private double x,y;
    private int directionX,directionY;
    private double xSpeed = 0;

    public Sprite2D(Image i, boolean isAlien)
    {
        if(isAlien == true)
        {
            x = Math.random()*550;
            y = Math.random()*400;
        }
        else
        {
            x = 300;
            y = 500;
        }
    }

    public void moveEnemy()
    {
        directionX = (int)(Math.floor(Math.random()*2));
        directionY = (int)(Math.floor(Math.random()*2));
           if (directionX == 1 && x <= 550) x += 3;
           if (directionX == 0 && x >= 0) x -= 3;
           if (directionY == 0 && y >= 0) y -= 3;
           if (directionY == 1 && y <= 550) y += 3;
        
    }

    public void movePlayer(int keyCode)
    {
        if (keyCode == 37 && x >= 0) x -= 3 + xSpeed;
        if (keyCode == 39 && x <= 550) x += 3 + xSpeed;
    }

    public void paint(Graphics g, Image image, boolean isAlien)
    {
        if (isAlien) g.drawImage(image, (int)x, (int)y, null);
        else g.drawImage(image, (int)x, (int)y, null);
    }

    public void resetSpeed()
    {
        xSpeed = 0;
    }

    public void incrementSpeed()
    {
        xSpeed += 1;
    }
}