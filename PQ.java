import java.util.*;

import javax.print.attribute.HashAttributeSet;


class CompareByDavidsMethodZeroZero implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        return (p1.x*p1.x + p1.y*p1.y) - (p2.x*p2.x + p2.y*p2.y);
    }
}


class ComparePointsByXandY implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.x < p2.x) {
            return 1;
        }
        if (p1.x == p2.x) {
            if (p1.y < p2.y) {
                return 1;
            }
        }
        if (p1.x == p2.x && p1.y == p2.y) {
            return 0;
        }
        return -1;
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (x < p.x) {
            return 1;
        }
        if (x == p.x) {
            if (y < p.y) {
                return 1;
            }
        }
        if (x == p.x && y == p.y) {
            return 0;
        }
        return -1;
    }

    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}

public class PQ {
    public static void main(String[] args) {

        HashMap<String, Comparator<Point>> comps = new HashMap<>();
        comps.put("raffi", new ComparePointsByXandY());
        comps.put("david", new CompareByDavidsMethodZeroZero());

        PriorityQueue<Point> pq = new PriorityQueue<>(comps.get("raffi"));

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            pq.add(
                new Point(
                    rand.nextInt(100),
                    rand.nextInt(100)
                )
            );
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + "  ");
        }
    }
}
