package Q02_EllipseBean;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Ellipse extends JPanel
{
    public Ellipse() { }
    
    private int majorAxis = 0;
    private int minorAxis = 0;

    public int getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(int minorAxis) {
        this.minorAxis = minorAxis;
        repaint();
    }

    public int getMajorAxis()
    {
        return majorAxis;
    }

    public void setMajorAxis(int majorAxis)
    {
        this.majorAxis = majorAxis;
        repaint();
    }
   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (minorAxis <= 0 || majorAxis<=0) return;

        int cx = getWidth() / 2, cy = getHeight() / 2;
        int x = cx - majorAxis, y = cy - minorAxis;
        int w = 2 * majorAxis, h = 2*minorAxis;
        g.drawOval(x, y, w, h);
    }
}