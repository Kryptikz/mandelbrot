public class Calculate {
    public static int iterations(double[] c) {
        double[] z = new double[]{0,0};
        int iterations = 1;
        while(iterations<3) {
            z = new double[]{(z[0]*z[0])+c[0],(z[1]*z[1])+c[1]};
            if (absoluteValue(z)>2) {
                break;
            }
            iterations++;
        }
        return iterations;
    }
    public static double absoluteValue(double[] z) {        
        return Math.sqrt((z[0]*z[0])+(z[1]*z[1]));
    }
}