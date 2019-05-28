/*
 * Name       :	Muhammad Ahmed bin Anwar Bahajjaj
 * Matric No. :	A0140051A
 * Plab Acct. :	-
 */
import java.util.*;

public class PandaChess {
	private ArrayList<LinkedList<Integer>> adjList = new ArrayList<>();
	private int[] inDeg;
	private LinkedList<Integer> order;
	boolean flag;
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int verts = sc.nextInt(), edges = sc.nextInt();
		inDeg = new int[verts];
		for (int i = 0; i < verts; i++) {
			adjList.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < edges; i++) {
			int src = sc.nextInt() - 1, dest = sc.nextInt() - 1;
			adjList.get(src).add(dest);
			inDeg[dest]++;
		}
		flag = true;
		int start = searchDeg();
		switch(start) {
			case -1:
				System.out.println("No possible ranking.");
				break;
			case -2:
				System.out.println("No possible ranking.");
				break;
			default:
				order = topoSort(start);
				if (flag) {
					while (!order.isEmpty()) {
						System.out.println(order.poll() + 1);
					}
				} else {
					System.out.println("Ranking is not unique");
				}
				break;
		}
	}
	public LinkedList<Integer> topoSort(int src) {
		LinkedList<Integer> ord = new LinkedList<>(), q = new LinkedList<>();
		boolean visit[] = new boolean[adjList.size()];
		ord.add(src);
		q.add(src);
		while(!q.isEmpty()) {
			int v = q.poll();
			if (!q.isEmpty()) {
				flag = false;
			}
			for (int n : adjList.get(v)) {
				if (!visit[n]) {
					visit[n] = true;
					q.add(n);
					ord.add(n);
				}
			}
		}
		return ord;
	}
	public int searchDeg(){
		int x = 0, y = 0;
		for (int z : inDeg) {
			if (z == 0) {
				x = z; y++;
			}
		}
		if (y == 1) {
			return x;
		} else if (y == 0) {
			return -1;
		} else {
			return -2;
		}
	}
	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}