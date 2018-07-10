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
            g.setColor(getIterationColor(i));
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
    public Color getIterationColor(int i) {
        while(i>16&&i!=maxit) {
            i-=16;
        }
        if (i==1)
            return (new Color(66,30,15));
        if (i==2)
            return (new Color(25,7,26));
        if (i==3)
            return (new Color(9,1,47));
        if (i==4)
            return (new Color(4,4,73));
        if (i==5)
            return (new Color(0,7,100));
        if (i==6)
            return (new Color(12,44,138));
        if (i==7)
            return (new Color(24,82,177));
        if (i==8)
            return (new Color(57,125,209));
        if (i==9)
            return (new Color(134,181,229));
        if (i==10)
            return (new Color(211,236,248));
        if (i==11)
            return (new Color(241,233,191));
        if (i==12)
            return (new Color(248,201,95));
        if (i==13)
            return (new Color(255,170,0));
        if (i==14)
            return (new Color(204,128,0));
        if (i==15)
            return (new Color(153,87,0));
        if (i==16)
            return (new Color(106,52,3));
        if (i==maxit)
            return (new Color(0,0,0));  
        return Color.BLACK;
    }
    public void setMaxIterations(int m) {
        maxit=m;
    }
}