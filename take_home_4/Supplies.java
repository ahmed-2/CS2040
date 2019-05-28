/*
 * Name       : Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. : A0140051A
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Supplies {
    private void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] tokens;
            String line;
            tokens = reader.readLine().split(" ");
            int N = Integer.parseInt(tokens[0]);
            int E = Integer.parseInt(tokens[1]);
            int H = Integer.parseInt(tokens[2]);
            int T = Integer.parseInt(tokens[3]);
            Map<Integer, List<Edge>> adjList = new HashMap<Integer, List<Edge>>();
            for (int i = 0; i < N; i++) {
                adjList.put(i, new ArrayList<Edge>());
            }
            for (int i = 0; i < E; i++) {
                if ((line = reader.readLine()) != null) {
                    tokens = line.split(" ");
                }
                int A = Integer.parseInt(tokens[0]);
                int B = Integer.parseInt(tokens[1]);
                int C = Integer.parseInt(tokens[2]);
                adjList.get(A).add(new Edge(A, B, C));
            }
            final int INF = 1000000000;
            int[] distance = new int[N];
            for (int i = 0; i < N; i++) {
                distance[i] = INF;
            }
            PriorityQueue<DijkNode> dijkNodePQ = new PriorityQueue<DijkNode>();
            distance[H] = 0;
            dijkNodePQ.add(new DijkNode(H, 0));
            while (!dijkNodePQ.isEmpty()) {
                DijkNode node = dijkNodePQ.poll();
                if (distance[node.vertex] != node.distEstimate) {
                    continue;
                }
                for (Edge edge : adjList.get(node.vertex)) {
                    int nextVertex = edge.to;
                    int nextDistEst = node.distEstimate + edge.weight;
                    if (nextDistEst < distance[nextVertex]) {
                        distance[nextVertex] = nextDistEst;
                        dijkNodePQ.add(new DijkNode(nextVertex, nextDistEst));
                    }
                }
            }
            int goingDistance = distance[T];
            for (int i = 0; i < N; i++) {
                distance[i] = INF;
            }
            distance[T] = 0;
            dijkNodePQ.add(new DijkNode(T, 0));
            while (!dijkNodePQ.isEmpty()) {
                DijkNode node = dijkNodePQ.poll();
                if (distance[node.vertex] != node.distEstimate) {
                    continue;
                }
                for (Edge edge : adjList.get(node.vertex)) {
                    int nextVertex = edge.to;
                    int nextDistEst = node.distEstimate + edge.weight;

                    if (nextDistEst < distance[nextVertex]) {
                        distance[nextVertex] = nextDistEst;
                        dijkNodePQ.add(new DijkNode(nextVertex, nextDistEst));
                    }
                }
            }
            int comingDistance = distance[H];
            int totalDistance = goingDistance + comingDistance;
            if (totalDistance >= INF) {
                System.out.println(-1);
            } else {
                System.out.println(goingDistance + comingDistance);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class DijkNode implements Comparable<DijkNode> {
        int vertex;
        int distEstimate;

        DijkNode(int vertex, int distEstimate) {
            this.vertex = vertex;
            this.distEstimate = distEstimate;
        }

        public int compareTo(DijkNode other) {
            return this.distEstimate - other.distEstimate;
        }
    }

    class Edge {
        int from;
        int to;
        int weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Supplies newSupplies = new Supplies();
        newSupplies.run();
    }
}
