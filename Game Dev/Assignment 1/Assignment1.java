import java.awt.*;
import javax.swing.*;

public class Assignment1 extends JFrame
{
    private static final Dimension WindowSize = new Dimension(600,600);

    public Assignment1()
    {
        this.setTitle("Gaming");
        Dimension screensize= java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 -WindowSize.width/2;
        int y = screensize.height/2 -WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        int x = 15;
        int y = 40;
        int red,green,blue;

        

        while (x < WindowSize.width && y < WindowSize.height)
        {
            red = (int)(Math.random()*256);
            green = (int)(Math.random()*256);
            blue = (int)(Math.random()*256);
            
            g.setColor(new java.awt.Color(red, green , blue));
            g.fillRect(x, y, 50, 50);
            x += 60;

            if (x >= WindowSize.width) 
            {
                x = 15;
                y += 60;
            }
        }
        
    }

    public static void main(String [ ] args) 
    {
        Assignment1 w = new Assignment1();
    }

}