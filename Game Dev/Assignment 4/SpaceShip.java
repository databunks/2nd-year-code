import java.awt.Image;

public class SpaceShip extends Sprite2D 
{

    public SpaceShip(Image i, int windowWidth,boolean isSpaceShip) 
    {
        super(i, windowWidth,isSpaceShip);
        xSpeed = 0;
        x = 300;
        y = 500;
    }

    public void move(int keyCode)
    {
        if (keyCode == 37 && x >= 0) xSpeed -= 1;
        if (keyCode == 39 && x <= winWidth - 50) xSpeed += 1;
    } 

    public void addXspeed()
    {
        x += xSpeed;

        if (x < 0)  
        {
          xSpeed = 0;
          x = 0;
        }  

        if (x > winWidth - 50)
        {
            xSpeed = 0;
            x = winWidth - 50;
        }
    }

}