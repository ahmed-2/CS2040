/*
 * Name       : Muhammad AHmed bin Anwar Bahajjaj
 * Matric No. : A0140051A
 * Plab Acct. : Nil
 */
import java.util.*;

public class Height {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int vCount = sc.nextInt();
        ArrayList<ArrayList<IntegerPair>> adjList = new ArrayList<ArrayList<IntegerPair>>(vCount);
        for (int i = 0; i < vCount; i++) {
            adjList.add(new ArrayList<IntegerPair>());
        }
        for (int i = 0; i < vCount-1; i++) {
            int v1 = sc.nextInt();
            if (v1 > 0) {
                int v2 = sc.nextInt(), w = sc.nextInt();
                adjList.get(v1-1).add(new IntegerPair(v2-1, w));
                adjList.get(v2-1).add(new IntegerPair(v1-1, -1 * w));
            }
        }
        int qCount = sc.nextInt();
        //path contains all distance weights relative to vertex 1
        long[] path = searchAll(0, vCount, adjList);
        for (int i = 0; i < qCount; i++) {
            int src = sc.nextInt(), dest = sc.nextInt();
            if (src == 1) {
                System.out.println(path[dest-1]);
            } else {
                System.out.println(path[dest-1] - path[src-1]);
            }
        }
    }

    private long[] searchAll(int src, int dest, ArrayList<ArrayList<IntegerPair>> adjList) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[adjList.size()];
        long[] path = new long[adjList.size()];
        q.add(src);
        while (!q.isEmpty()) {
            //u = current vertex being searched (BFS)
            int u = q.poll();
            //n = neighbour vertex of u
            for (IntegerPair n : adjList.get(u)) {
                if (!visit[n.v]) {
                    visit[n.v] = true;
                    q.add(n.v);
                    path[n.v] += n.w + path[u];
                }
            }
        }
        return path;
    }

    public static void main(String[] args) {
        Height newHeight = new Height();
        newHeight.run();
    }
}

class IntegerPair implements Comparable<IntegerPair> {
    public Integer v, w;
    public IntegerPair(Integer v, Integer w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(IntegerPair other) {
        return Integer.compare(this.w, other.w);
    }
}
