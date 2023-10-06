package StacksAndQueues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Flights {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("StacksAndQueues/data.txt"));
        ArrayList<String> map = new ArrayList<>();
        
        while (sc.hasNextLine()) {
            // Y -> R
            // Y -> Z
            // R -> X
            map.add(sc.nextLine());
        }

        sc.close();
        sc = new Scanner(System.in);

        System.out.print("Enter the source: ");
        String src = sc.nextLine();

        System.out.println();

        System.out.print("Enter the destination: ");
        String dst = sc.nextLine();

        sc.close();

        boolean hasSrc = false, hasDst = false;
        for (String edge : map) {
            String[] splitted = edge.split(" -> ");
            if (src.equals(splitted[0])) {
                hasSrc = true;
            }
            if (dst.equals(splitted[1])) {
                hasDst = true;
            }
            if (hasSrc && hasDst) {
                break;
            }
        }

        if (!(hasSrc && hasDst)) {
            System.out.println("Not possible.");
            return;
        }

        // TODO: Set the size to the number of nodes/verticies
        ArrayList<String> visited = new ArrayList<>();

        // LIFO = last in, first out
        Stack<String> cities = new Stack<>();
        String curr = src;
        cities.push(curr);
        while (!curr.equals(dst) || cities.isEmpty()) {
            // Go to the city from where you are
            // nextHop will be null if there is not city to go to
            String nextHop = findNextCityToHopTo(map, curr, visited);
            if (nextHop == null) {
                if (!cities.isEmpty()) {
                    cities.pop();
                    curr = cities.peek();
                    continue;
                }
                else {
                    System.out.println("Not possible.");
                    return;
                }
            }
            else if (nextHop.equals(dst)) {
                System.out.println("Found it!");
                printPath(cities);
                return;
            }
            // Move to the next city
            curr = nextHop;
            cities.push(curr);
        }
    }

    public static void printPath(Stack<String> cities) {
        String out = "end";
        while (!cities.isEmpty()) {
            out = cities.pop() + " -> " + out;
        }
        System.out.println(out);
    }

    public static String findNextCityToHopTo(ArrayList<String> map, String curr, ArrayList<String> visited) {
        // curr is A
        for (String edge : map) {
            // edge is A -> B
            String[] splitted = edge.split(" -> ");
            String src = splitted[0]; // A
            String dst = splitted[1]; // B

            // If curr == A
            if (src.equals(curr)) {
                // If B has not been visited before
                if (!visited.contains(dst)) {
                    visited.add(dst);
                    return dst;
                }
            }
        }
        return null;
    }
}
