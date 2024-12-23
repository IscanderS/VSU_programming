
public class Programm {

    public static final Line L1 = new Line(0, 1, -1);
    public static final Line L2 = new Line(0, 4, -1);

    public static final Horizontal_parabola H1 = new Horizontal_parabola(-1, 6, 1);

    public static final Vertical_parabola V1 = new Vertical_parabola(-4, 0, -0.5);

    public static final Quadrant Q1 = new Quadrant(1, 3, 0, 9);

    public static Colors getColor(double x, double y) {

        if ((V1.IsPointUnderParabola(x, y)) || (L2.IsPointAboveLine(x, y) && x < 1 && (H1.IsPointRightOfParabola(x, y) == false)) || (H1.IsPointRightOfParabola(x, y) && x > 3) || (x > 1 && x < 3 && y > 9) || (x > 3 && y > 8)) {
            return Colors.BLUE;
        }

        if ((L1.IsPointAboveLine(x, y) == true && L2.IsPointAboveLine(x, y) == false) || (H1.IsPointRightOfParabola(x, y) == true && x > 1 && x < 3)) {
            return Colors.ORANGE;
        }

        if (Q1.IsPointInsideQuadrant(x, y) && y > 7 && H1.IsPointRightOfParabola(x, y) == false) {
            return Colors.GREEN;
        }

        if (H1.IsPointRightOfParabola(x, y) && x < 1) {
            return Colors.YELLOW;
        }

        if (Q1.IsPointInsideQuadrant(x, y) && L2.IsPointAboveLine(x, y) == true && H1.IsPointRightOfParabola(x, y) == false && y < 5) {
            return Colors.WHITE;
        }

        else {
            return Colors.GRAY;
        }
    }
}
