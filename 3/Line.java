
public class Line {
    public double x0, y0, a;

    public Line(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean IsPointAboveLine(double x, double y) {
        return y > a * (x - x0) + y0;
    }
}
