import java.util.*;
import java.io.*;

public class CustomHMpractice {
    public static void main(String[] args) throws FileNotFoundException {
        // HashSet instead of ArrayList
        Map<String, ArrayList<String>> hm = new HashMap<>();

        // Q -> X
        // R -> X

        Scanner sc = new Scanner(new File("StacksAndQueues/data.txt"));

        ArrayList<String> data = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            data.add(line);
        }

        sc.close();

        long start = System.currentTimeMillis();
            
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            
            for (String s : data) {
                // Split line by the ->
                // to obtain src and dst
                String[] line = s.split(" -> ");
                if (!hm.containsKey(line[0])) {
                    hm.put(line[0], new ArrayList<>());
                }
                hm.get(line[0]).add(line[1]);
                hm.get(line[0]).contains(line[1]);
            }
        }
        long finish = System.currentTimeMillis();

        long timeElapsed = (finish - start);

        System.out.println("Time: " + timeElapsed); // in ms

        // System.out.println(hm.keySet());
        // System.out.println(hm.values());

    }
}
