package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
        
public class JavaGame extends JFrame implements Runnable
{
    
    int x, y, xDirection, yDirection;
    private Image dbImage;
    private Graphics dbg;                                        // Double buffer graphics
    
    public void run()
    {
        try
        {
           while(true)
           {
               
               move();
               Thread.sleep(6);
           } 
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    public void move()
    {
        x += xDirection;
        y += yDirection;
        if(x <= 0)
            x = 0;
        if(x >= 875)
            x = 875;
        if(y <= 50)
            y = 50;
        if(y >= 725)
            y = 725;
    }
    public void setXDirection(int xdir)
    {
        xDirection = xdir;
    }
    
    public void setYDirection(int ydir)
    {
        yDirection = ydir;
    }
    
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
    
    public class AL extends KeyAdapter                           //AL for action listener
    {
        public void keyPressed(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT)
            {
              setXDirection(-1);
            }
            
            if(keyCode == e.VK_RIGHT)
            {
             setXDirection(+1);
            }
            
            if(keyCode == e.VK_UP)
            {
             setYDirection(-1);
            }
            
            if(keyCode == e.VK_DOWN)
            {
            setYDirection(+1);
            }
        }
        public void keyReleased(KeyEvent e)
        {
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT)
            {
              setXDirection(0);
            }
            
            if(keyCode == e.VK_RIGHT)
            {
             setXDirection(0);
            }
            
            if(keyCode == e.VK_UP)
            {
             setYDirection(0);
            }
            
            if(keyCode == e.VK_DOWN)
            {
            setYDirection(0);
            }
        }
    }
    public JavaGame()                           //Constructor
    {
        addKeyListener(new AL());
        setTitle("Java Game");                  //Sets title
        setSize(900, 750);                      //Width & height
        setResizable(false);                    //Whether the user can resize the game window
        setVisible(true);                       //Whether the window displays or not
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        x = 150;
        y = 150;
    }
    public void paint(Graphics g)
    {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public void paintComponent(Graphics g)
    {
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Welcome to Fruit Frenzy!", 250, 150);
        g.setColor(Color.RED);
        g.fillOval(x, y, 15, 15);
        
        repaint();
    }
    public static void main(String[] args)
    {
        JavaGame JG =new JavaGame();
        //Threads
        Thread t1 = new Thread(JG);
        t1.start();
    }
}
