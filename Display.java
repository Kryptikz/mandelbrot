import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Display extends JComponent {
    ArrayList<double[]> points;
    int maxit;
    public Display(int max) {
        points = new ArrayList<double[]>();
        maxit=max;
    }
    public Display(ArrayList<double[]> d, int max) {
        points=d;
        maxit=max;
    }
    public void draw() {
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(double[] d : points) {
            double x = d[0];
            double y = d[1];
            int i = (int)d[2];
            //i=i%18;
            while(i>16&&i!=maxit) {
                i-=16;
            }
            if (i==1)
                g.setColor(new Color(66,30,15));
            if (i==2)
                g.setColor(new Color(25,7,26));
            if (i==3)
                g.setColor(new Color(9,1,47));
            if (i==4)
                g.setColor(new Color(4,4,73));
            if (i==5)
                g.setColor(new Color(0,7,100));
            if (i==6)
                g.setColor(new Color(12,44,138));
            if (i==7)
                g.setColor(new Color(24,82,177));
            if (i==8)
                g.setColor(new Color(57,125,209));
            if (i==9)
                g.setColor(new Color(134,181,229));
            if (i==10)
                g.setColor(new Color(211,236,248));
            if (i==11)
                g.setColor(new Color(241,233,191));
            if (i==12)
                g.setColor(new Color(248,201,95));
            if (i==13)
                g.setColor(new Color(255,170,0));
            if (i==14)
                g.setColor(new Color(204,128,0));
            if (i==15)
                g.setColor(new Color(153,87,0));
            if (i==16)
                g.setColor(new Color(106,52,3));
            if (i==maxit)
                g.setColor(new Color(0,0,0));
            //g.setColor(new Color((int)i,0,0));
            g.fillRect((int)x, (int)y, 1, 1);
        }
    }
    public void addPoint(double[] d) { 
        points.add(d);
    }
    public void setPoints(ArrayList<double[]> d) {
        points=d;
    }
}