import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovingSquaresApplication extends JFrame implements Runnable
{
    private static final Dimension WindowSize = new Dimension(600,600);
    private static final int NUMGAMEOBJECTS = 30;
    private GameObject[] gameObjectsArray = new GameObject[NUMGAMEOBJECTS];

    public MovingSquaresApplication() throws InterruptedException
    {
        this.setTitle("Le animation xd");
        Dimension screensize= java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 -WindowSize.width/2;
        int y = screensize.height/2 -WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        for (int i = 0; i < NUMGAMEOBJECTS; i++)
        {
            gameObjectsArray[i] = new GameObject();
        }
        Thread t = new Thread(this);
        t.start();

        while(true)
        {
            Thread.sleep(20);
            for(int i = 0; i < NUMGAMEOBJECTS; i++)
            {
                gameObjectsArray[i].move();
            }
            this.repaint();
        }
    }

    public void run()
    {
        
    }

    public void paint(Graphics g) 
    {
       g.fillRect(0, 0, 600, 600);
       for (int i = 0; i < NUMGAMEOBJECTS; i++)
       {
           gameObjectsArray[i].paint(g);
       }
    }
     public static void main(String [] args) throws InterruptedException
    {
        MovingSquaresApplication w = new MovingSquaresApplication();
        ImageIcon poggers = new ImageIcon("pog.jpg");
    }
    
}