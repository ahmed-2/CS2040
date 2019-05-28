public class Brackets {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), count;
        for (int i = 0; i < num; i++) {
            count = sc.nextInt();
            char[] line = sc.next().toCharArray();
            System.out.println(check(line) ? "Valid" : "Invalid");
        }
    }
    public boolean check(char[] line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length; i++) {
            char bracket = line[i];
            if (stack.isEmpty()) {
                stack.push(bracket);
            } else {
                if (shape(stack.peek()) == bracket) {
                    stack.pop();
                } else {
                    stack.push(bracket);
                }
            }
        }
        return stack.isEmpty();
    }
    public char shape(char bracket) {
        switch (bracket) {
            case ('('): return ')';
            case ('['): return ']';
            case ('{'): return '}';
            default: return '.';
        }
    }
}
public class Transmission {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), ops = sc.nextInt();
        TreeSet<Integer> cats = new TreeSet<>();
        for (int i = 0; i < ops; i++) {
            String ins = sc.next();
            switch (ins) {
                case "SLEEP":
                cats.add(sc.nextInt());
                break;
                case "WAKE":
                cats.remove(sc.nextInt());
                break;
                case "TRANSMIT":
                int x = sc.nextInt(), y = sc.nextInt();
                System.out.println(cats.lower(y+1) == null || x > cats.lower(y+1)
                ? "YES" : "NO");
                break;
            }
        }
    }
}
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
public class Classphoto {
	private void run() {
		Scanner sc = new Scanner(System.in);
		TreeSet<Student> students = new TreeSet<>();
		students.add(new Student("Rar", 0));
		int numStu = sc.nextInt();
		for (int i = 0; i < numStu; i++) {
			Student temp = new Student(sc.next(), sc.nextInt());
			students.add(temp);
			System.out.println(students.lower(temp));
		}
		//System.out.println("Size: "+students.size());
		while(!students.isEmpty()) {
			System.out.print(students.pollFirst());
			if (!students.isEmpty()) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}
class Student implements Comparable<Student> {
	protected String name;
	protected int order;
	protected int height;
	private static int id = 0;	
	public Student(String name, int height) {
		this.name = name;
		this.height = height;
		order = id;
		id++;
	}
	@Override
	public String toString() {
		return this.name;
	}
	@Override
	public int compareTo(Student other) {
		int temp = Integer.compare(this.height, other.height);
		if (temp == 0) {
			return Integer.compare(other.order, this.order);
		} else {
			return temp;
		}
	}
}