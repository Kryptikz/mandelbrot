import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Display extends JComponent {
    ArrayList<double[]> points;
    public Display() {
        points = new ArrayList<double[]>();
    }
    public Display(ArrayList<double[]> d) {
        points=d;
    }
    public void draw() {
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(double[] d : points) {
            double x = d[0];
            double y = d[1];
            double i = d[2];
            if (i==1) {
                g.setColor(Color.RED);
            } 
            if (i==2) {
                g.setColor(Color.GREEN);
            }
            if (i==3) {
                g.setColor(Color.BLUE);
            }
            g.fillRect((int)x, (int)y, 1, 1);
        }
    }
    public void addPoint(double[] d) { 
        points.add(d);
    }
}