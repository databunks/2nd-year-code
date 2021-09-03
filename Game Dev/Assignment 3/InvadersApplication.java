import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    private static final Dimension windowSize = new Dimension(600, 600);
    private static final int numberOfIlluminatis = 30;
    private Sprite2D[] illuminatiArray = new Sprite2D[numberOfIlluminatis];
    private ImageIcon illuminatiIcon = new ImageIcon("illuminati.png");
    private Image illuminatiImage = illuminatiIcon.getImage();
    private ImageIcon poggersIcon = new ImageIcon("poggers.png");
    private Image poggersImage = poggersIcon.getImage();
    private Sprite2D poggers;

    public InvadersApplication() throws InterruptedException 
    {
        this.setTitle("Poggers vs illuminati");
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - windowSize.width / 2;
        int y = screensize.height / 2 - windowSize.height / 2;
        setBounds(x, y, windowSize.width, windowSize.height);
        setVisible(true);
        addKeyListener(this);

        for (int i = 0; i < numberOfIlluminatis; i++) 
        {
            illuminatiArray[i] = new Sprite2D(illuminatiImage, true);
        }
        poggers = new Sprite2D(poggersImage, false);

        Thread t = new Thread(this);
        t.start();

        while(true)
        {
            Thread.sleep(50);
            for(int i = 0; i < numberOfIlluminatis; i++)
            {
                illuminatiArray[i].moveEnemy();
            }
            this.repaint();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);

        poggers.paint(g,poggersImage,false);
        for (int i = 0; i < numberOfIlluminatis; i++) 
        {
            illuminatiArray[i].paint(g, illuminatiImage, true);
        }

    }

    public void run() {
    }

    public void keyPressed(KeyEvent e)
    {
        poggers.movePlayer(e.getKeyCode());
        poggers.incrementSpeed();
    }

    public void keyReleased(KeyEvent e)
    {
        poggers.resetSpeed();
    }
    
    public void keyTyped(KeyEvent e) 
    {
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        InvadersApplication window = new InvadersApplication();
    }
}