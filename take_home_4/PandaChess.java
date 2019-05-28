/*
 * Name       : Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. : A0140051A
 */
import java.util.*;

public class PandaChess {
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int M = sc.nextInt();   
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= N; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        int[] indeg = new int[N + 1];
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            indeg[i] = 0;
            parent[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            indeg[v]++;
            adjList.get(u).add(v);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        boolean possible = true;
        boolean unique = true;
        Queue<Integer> toposort = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                unique = false;
            }
            int u = queue.poll();
            toposort.add(u);

            for (int v : adjList.get(u)) {
                if (indeg[v] > 0) {
                    indeg[v]--;
                }
                if (indeg[v] == 0) {
                    parent[v] = u;
                    queue.offer(v);
                }
            }
        }
        if (toposort.size() == N) {
            if (unique) {
                for (int i = 0; i < N; i++) {
                    System.out.println(toposort.poll());
                }
            } else {
                System.out.println("Ranking is not unique.");
            }
        } else {
            System.out.println("No possible ranking.");
        }
	}
	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}