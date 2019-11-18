import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class Data {

    public static <T> T max(T a, T b, Comparator<T> c) {
        return c.compare(a, b) > 0 ? a : b;
    }

    public static <T> T max(Collection<T> collection, Comparator<T> c) {
        if (collection.isEmpty()) return null;
        Iterator<T> iterator = collection.iterator();
        T m = iterator.next();
        while (iterator.hasNext()) {
            m = max(m, iterator.next(), c);
        } return m;
    }

}
