import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
public class Initialize {
    public static void main(String[] args) {
        JFrame frame = new JFrame("window");
        int HEIGHT = 1080;
        int WIDTH = 1920;
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display d = new Display();
        //frame.add(d);
        //d.setVisible(true);
        int ITERATIONS = 1000; 
        Display d = new Display(ITERATIONS);
        frame.add(d);
        d.setVisible(true);
        frame.repaint();
        frame.revalidate();
        double[] center = new double[]{0,0};
        double zoom = 2;
        double left = -4+center[0];
        double right = 4+center[0];
        double top = 2+center[1];
        double bottom = -2+center[1];
        /*for(int i=1;i<zoom;i++) {
            double horzDist = right-left;
            double vertDist = top-bottom;
            left+=horzDist/2;
            right-=horzDist/2;
            top-=vertDist/2;
            bottom+=vertDist/2;
        }*/
        //double left=-1;
        //double right=0;
        //double top=1.25;
        //double bottom=-.25;        
        //for(int i=0;i<100;i++) {
        double vertInc = (top-bottom)/HEIGHT;
        double horzInc = (right-left)/WIDTH;
        double a = top;
        double b = left;
        for(int i=1;i<=1000;i++) {
            d.setMaxIterations(i);
            ArrayList<double[]> points = new ArrayList<double[]>();
            //System.out.println("vertInc: " + vertInc);
            //System.out.println("horzInc: " + horzInc);
            for(int r=0;r<HEIGHT;r++) {
                for(int c=0;c<WIDTH;c++) {
                    int calc = Calculate.iterations(new double[]{b,a}, i);
                    //System.out.println(a + " " + b);
                    points.add(new double[]{c,r,calc});
                    //d.draw();
                    b+=horzInc;
                }
                b=left;
                a-=vertInc;
                //System.out.println((((double)((int)(((double)r/(double)HEIGHT*100)*100)))/100) + "% complete with frame generation");
            }
            d.setPoints(points);
            //d.setVisible(true);
            d.draw();
            a = top;
            b = left;
            //System.out.println("array size: " + points.size()); 
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*
        //left+=.02;
        //right-=.02;
        //bottom+=.01;
        //top-=.01;
        BufferedImage out = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File("mandlebrot_render_raw.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean s = true;
        for(double[] du : points) {
            try {
                out.setRGB((int)du[0], (int)du[1], (d.getIterationColor((int)du[2])).getRGB());
            } catch (Exception e) {
            }
            try {
                bw.write("loc:[" + du[0] + "," + du[1] + "] - value[" + du[2] + "]");
                bw.newLine();
                bw.flush();
            } catch (Exception e) {
                s=false;
                System.out.println("recoverable instance of raw data write failed with error:");
                e.printStackTrace();
            }
        }
        if (s) {
            System.out.println("raw data write completed successfully");
        }
        File output = new File("mandlebrot_render.png");
        try {
            ImageIO.write(out,"png",output);
            System.out.println("image write completed successfully");
        } catch (Exception e) {
            System.out.println("image write failed with error:");
            e.printStackTrace();
        }
        //}*/
    }
}