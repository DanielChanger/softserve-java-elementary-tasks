package triangles;

import java.util.Comparator;

public class TrianglesComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getArea() - o2.getArea());
    }
}
