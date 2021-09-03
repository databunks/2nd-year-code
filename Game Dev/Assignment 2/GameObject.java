import java.awt.*;

public class GameObject
{
    private double x,y;
    private Color c;
    private int red, green, blue;
    private int dirX, dirY;

    public GameObject()
    {
        x = (int)(Math.random()*600);
        y = (int)(Math.random()*600);
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);
        
    }

    public void move()
    {
        dirX = (int)Math.floor(Math.random()*2);
        dirY = (int)Math.floor(Math.random()*2);

        if (dirX == 0) x += 3;
        if (dirY == 0) y += 3;
        if (dirX == 1) x -= 3;
        if (dirY == 1) y -= 3;
    }

    public void paint(Graphics g)
    {
        g.setColor(new java.awt.Color(red, green , blue));
        g.fillRect((int)x, (int)y, 50, 50);
    }
}