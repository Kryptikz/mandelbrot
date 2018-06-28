import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Initialize {
    public static void main(String[] args) {
        JFrame frame = new JFrame("window");
        int HEIGHT = 1000;
        int WIDTH = 1000;
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        //Display d = new Display();
        //frame.add(d);
        //d.setVisible(true);
        double left=-2;
        double right=2;
        double top=2;
        double bottom=-2;
        double vertInc = (top-bottom)/HEIGHT;
        double horzInc = (right-left)/WIDTH;
        double a = top;
        double b = left;
        ArrayList<double[]> points = new ArrayList<double[]>();
        for(int r=0;r<HEIGHT;r++) {
            for(int c=0;c<WIDTH;c++) {
                int calc = Calculate.iterations(new double[]{b,a});
                points.add(new double[]{c,r,calc});
                //d.draw();
                b+=horzInc;
            }
            b=left;
            a+=vertInc;
        }
        Display d = new Display(points);
        frame.add(d);
        d.setVisible(true);
        d.draw();
    }
}