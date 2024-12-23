
public class Quadrant {
    double x0, x1, y0, y1;

    public Quadrant(double x0, double x1, double y0, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public boolean IsPointInsideQuadrant(double x, double y) {
        return (x0 <= x && x <= x1) && (y0 <= y && y <= y1);
    }
}
