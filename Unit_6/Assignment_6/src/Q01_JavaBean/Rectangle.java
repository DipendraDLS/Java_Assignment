package Q01_JavaBean;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Rectangle extends JPanel
{
    public Rectangle() { }
    private int length = 0;
    private int breadth = 0;
    public int getLength() 
    {
        return length;
    }
    public void setLength(int length) 
    {
        this.length = length;  
        repaint();
        
    }
    public int getBreadth() 
    {
        return breadth;
    }
    public void setBreadth(int breadth) 
    {
        this.breadth = breadth;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (length <= 0 || breadth<=0) return;
        int x = 50, y = 50;
        int l = length, b = breadth;
        g.drawRect(x, y, l, y);
    }
}