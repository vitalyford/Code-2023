package StacksAndQueues;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class WaterFill {
    private static void print(char[][] room) {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[0].length; col++) {
                System.out.print(room[row][col]);
            }
            System.out.println();
        }
    }

    public static int waterFill(char[][] room, int startX, int startY) {
        int height = room.length;
        int width = room[0].length;
        // height is y, width is x
        // height is rows, width is columns
        int[][] steps = new int[height][width];

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(startY, startX));
        steps[startY][startX] = 1;
        room[startY][startX] = 'W';

        // going north, east, south, and west
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            // visiting a point in the room
            Point p = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (room[newY][newX] == ' ') {
                    q.add(new Point(newY, newX));
                    steps[newY][newX] = steps[p.y][p.x] + 1;
                    room[newY][newX] = 'W';
                }
            }

            if (q.isEmpty()) {
                print(room);
                return steps[p.y][p.x];
            }
        }

        print(room);

        return 0;
    }

    public static void main(String[] args) {
        char[][] room = {
            { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
            { '1', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '1' },
            { '1', '1', '1', '1', '1', ' ', ' ', ' ', ' ', '1' },
            { '1', ' ', ' ', ' ', '1', ' ', ' ', ' ', ' ', '1' },
            { '1', ' ', ' ', ' ', '1', ' ', ' ', ' ', ' ', '1' },
            { '1', ' ', '1', '1', '1', ' ', ' ', ' ', ' ', '1' },
            { '1', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '1' },
            { '1', '1', '1', '1', ' ', '1', '1', '1', '1', '1' },
            { '1', ' ', ' ', '1', ' ', '1', ' ', ' ', ' ', '1' },
            { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' }
        };

        int startX = 1, startY = 1;

        System.out.println("Max steps: " + waterFill(room, startX, startY));
    }
}
// how do u follow differ
// click the thumbtack button in the upper right

// th//thank u :) oys

// _.-'''''-._
// .' _ _ '.
// / (_) (_) \
// | , , |
// | \`. .`/ |
// \ '.`'""'"`.' /
// '. `'---'` .'
// '-._____.-'rep tn
// }
// System.out.println("have a good da")
// System.out.println("Is that the real Dr, Ford")

// //is there a way to print different text colors rep tn
// }
// System.out.println("have a good da")
// System.out.println("Is that the real Dr, Ford")