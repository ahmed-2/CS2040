/*
 * Name       : Andy Lam Kwok Wee
 * Matric No. : A0183821E
 * Plab Acct. :
 */
import java.util.*;

public class Height {
    private ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();

    private void run() {
        Scanner reader = new Scanner(System.in);
        int numAreas = reader.nextInt();
        for (int i = 0; i < numAreas; i++) {
            list.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < numAreas - 1; i++) {
            int areaA = reader.nextInt();
            int areaB = reader.nextInt();
            long fromAtoB = reader.nextLong();
            Pair forA = new Pair(areaB, fromAtoB);
            Pair forB = new Pair(areaA, -fromAtoB);
            list.get(areaA - 1).add(forA);
            list.get(areaB - 1).add(forB);
        }
        int numQueries = reader.nextInt();
        long[] tracker = findRelativeHeight();
        for (int i = 0; i < numQueries; i++) {
            int start = reader.nextInt();
            int end = reader.nextInt();
            if (start == 1) {
                System.out.println(tracker[end - 1]);
            } else {
                System.out.println(tracker[end - 1]- tracker[start - 1]);
            }
        }
        reader.close();
    }

    private long[] findRelativeHeight() {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] visited = new int[list.size()];
        long[] tracker = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            visited[i] = 0;
            tracker[i] = 0;
        } 
        queue.add(1);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int i = 0; i < list.get(vertex - 1).size(); i++) {
                Pair neighbour = list.get(vertex - 1).get(i);
                if (visited[neighbour.getArea() - 1] == 0) {
                    visited[neighbour.getArea() - 1] = 1;
                    queue.offer(neighbour.getArea());
                    tracker[neighbour.getArea() - 1] += neighbour.getWeight()
                        + tracker[vertex - 1]; 
                }
            }
        }
        return tracker;
    }

    public static void main(String[] args) {
        Height newHeight = new Height();
        newHeight.run();
    }
}

class Pair {
    private int area;
    private long weight;

    public Pair(int area, long weight) {
        this.area = area;
        this.weight = weight;
    }

    public int getArea() {
        return area;
    }

    public long getWeight() {
        return weight;
    }
}
