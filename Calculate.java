public class Calculate {
    public static int iterations(double[] c, int max) {
        double[] z = new double[]{0,0};
        int iterations = 1;
        while(iterations<max) {
            //z = new double[]{(z[0]*z[0])+c[0],(z[1]*z[1])+c[1]};
            z = new double[]{((z[0]*z[0])-(z[1]*z[1]))+c[0],(2*z[0]*z[1])+c[1]};
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