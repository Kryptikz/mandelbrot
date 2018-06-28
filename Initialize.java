import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Initialize {
    public static void main(String[] args) {
        JFrame frame = new JFrame("window");
        int HEIGHT = 1080;
        int WIDTH = 1920    ;
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display d = new Display();
        //frame.add(d);
        //d.setVisible(true);
        int ITERATIONS = 100; 
        Display d = new Display(ITERATIONS);
        frame.add(d);
        d.setVisible(true);
        frame.repaint();
        frame.revalidate();
        double left=-2;
        double right=2;
        double top=1;
        double bottom=-1;        
        for(int i=0;i<100;i++) {
            double vertInc = (top-bottom)/HEIGHT;
            double horzInc = (right-left)/WIDTH;
            double a = top;
            double b = left;
            ArrayList<double[]> points = new ArrayList<double[]>();
            //System.out.println("vertInc: " + vertInc);
            //System.out.println("horzInc: " + horzInc);
            for(int r=0;r<HEIGHT;r++) {
                for(int c=0;c<WIDTH;c++) {
                    int calc = Calculate.iterations(new double[]{b,a}, ITERATIONS);
                    //System.out.println(a + " " + b);
                    points.add(new double[]{c,r,calc});
                    //d.draw();
                    b+=horzInc;
                }
                b=left;
                a-=vertInc;
                //System.out.println((double)r/(double)HEIGHT*100);
            }
            d.setPoints(points);
            d.setVisible(true);
            d.draw();
            left+=.02;
            right-=.02;
            bottom+=.01;
            top-=.01;
        }
    }
}