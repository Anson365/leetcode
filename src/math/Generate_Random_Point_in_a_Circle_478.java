package math;

/**
 * @author luodaihua
 * Created on 2019-02-01
 */
public class Generate_Random_Point_in_a_Circle_478 {
    private double x_center;
    private double y_center;
    private double radius;

    public Generate_Random_Point_in_a_Circle_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double area = Math.PI * radius * radius;
        double randomArea = Math.random() * area;
        double randomRadius = Math.sqrt(randomArea / Math.PI);
        double rad = Math.random() * Math.PI * 2;
        double x = Math.cos(rad) * randomRadius + x_center;
        double y = Math.sin(rad) * randomRadius + y_center;
        return new double[]{x, y};
    }
}
