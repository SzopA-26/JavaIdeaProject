import java.util.Comparator;

public class SortPlayerPoint implements Comparator<Athlete> {
    private Point point;

    public SortPlayerPoint(Point point) {
        this.point = point;
    }

    @Override
    public int compare(Athlete o1, Athlete o2) {
        return Double.compare(point.getPoint(o2), point.getPoint(o1));
    }
}
