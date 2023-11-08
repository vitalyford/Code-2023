import java.util.*;

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
        PriorityQueue<Point> pq = new PriorityQueue<>();

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
