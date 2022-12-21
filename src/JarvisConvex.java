import java.util.ArrayList;
import java.util.Arrays;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class JarvisConvex {
    ArrayList<Point> hullPoints = new ArrayList<>();
    int lm;

    public int orientation(Point p, Point q, Point r) {
        int v = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (v == 0) return 0;

        return (v > 0) ? 2 : 1;
    }

    public void convexHull(Point[] points, int length) {
        if (length < 3) return;
        lm = 0;

        for (int i = 0; i < length; i++) {
            if (points[i].x < points[lm].x)
                lm = i;
        }

        int p = lm;
        convexHullRec(points, length, p);

        for (Point point : hullPoints)
            System.out.println("P" + (Arrays.asList(points).indexOf(point)+1) +"(" + point.x + ", " + point.y + ")");
    }

    public void convexHullRec(Point[] points, int length, int p) {

        hullPoints.add(points[p]);

        int q = (p + 1) % length;

        for (int i = 0; i < length; i++) {
            if (orientation(points[p], points[i], points[q]) == 1)
                q = i;
        }

        p = q;

        if(p == lm) return;

        convexHullRec(points, length, p);
    }

    public static void main(String[] args) {
        Point[] points = new Point[9];
        points[0]=new Point(1, 5);
        points[1]=new Point(2, 8);
        points[2]=new Point(2, 9);
        points[3]=new Point(3, 10);
        points[4]=new Point(3, 1);
        points[5]=new Point(4, 6);
        points[6]=new Point(4, 8);
        points[7]=new Point(9, 5);
        points[8]=new Point(10, 4);

        int n = points.length;
        JarvisConvex convex = new JarvisConvex();
        convex.convexHull(points, n);
    }
}
