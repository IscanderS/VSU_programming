
public class Vertical_parabola {
    public double x0, y0, a;

    public Vertical_parabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean IsPointUnderParabola(double x, double y) {
        return y < a * Math.pow(x - x0, 2) + y0;
    }
}
