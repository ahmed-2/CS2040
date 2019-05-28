/*
 * Name       : Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. : A0140051A
 */
import java.time.Duration;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PandaIslands {
    private void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] tokens = reader.readLine().split(" ");  
            int N = Integer.parseInt(tokens[0]);
            int E = Integer.parseInt(tokens[1]);
            int[] areas = new int[N + 1];
            areas[0] = 0;
            for (int i = 1; i <= N; i++) {
                int area = Integer.parseInt(reader.readLine());
                areas[i] = area;
            }
            Map<Integer, List<Integer>> bridgesFrom = new HashMap<Integer, List<Integer>>();
            for (int i = 1; i <= N; i++) {
                bridgesFrom.put(i, new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                tokens = reader.readLine().split(" ");
                int u = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                bridgesFrom.get(u).add(v);
                bridgesFrom.get(v).add(u);
            }
            int paint = 0;
            boolean[] visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                visited[i] = false;
            }
            Queue<Integer> queue = new LinkedList<Integer>();
            int numVisited = 0;
            boolean[] one = new boolean[N + 1];
            while (numVisited != N) {
                boolean finished = true;
                for (int j = 1; j <= N; j++) {
                    if (!visited[j]) {
                        visited[j] = true;
                        numVisited++;
                        queue.offer(j);
                        finished = false;
                        break;
                    }
                }
                if (finished) {
                    break;
                }
                int areaOne = 0;
                int areaTwo = 0;
                int start = queue.peek();
                one[start] = true;
                areaOne += areas[start];
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : bridgesFrom.get(u)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            numVisited++;

                            if (one[u]) {
                                one[v] = false;
                                areaTwo += areas[v];
                            } else {
                                one[v] = true;
                                areaOne += areas[v];
                            }
                            queue.offer(v);
                        }
                    }
                }
                if (areaOne < areaTwo) {
                    paint += areaOne;
                } else {
                    paint += areaTwo;
                }
            }
            System.out.println(paint);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        PandaIslands newPandaIslands = new PandaIslands();
        newPandaIslands.run();
    }
}
