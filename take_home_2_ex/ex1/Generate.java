/**
 * Name         :	Muhammad Ahmed bin Anwar Bahajjaj
 * Matric. No   :	A0140051A
 * PLab Acct.   :	-
 */

import java.util.*;

public class Generate {
	private static ArrayList<String> output = new ArrayList<>();
	private static ArrayList<String> sequence = new ArrayList<>();
	private static String original;

	private void run() {
		Scanner sc = new Scanner(System.in);
		original = sc.next();
		boolean[] used = new boolean[original.length()];
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}
		for (int i = 0; i < original.length(); i ++) {
			used[i] = true;
			permute(original.substring(i, i+1), used);
			used[i] = false;
		}
		sequence  = subset(original);
		Collections.sort(sequence);
		Collections.sort(output);
		for (String out : output) {
			System.out.println(out);
		}
		for (String seq : sequence) {
			if (!seq.equals(""))
				System.out.println(seq);
		}
	}

	private ArrayList<String> subset(String s) {
		if (s.length() == 0) {
			ArrayList<String> answer = new ArrayList<>();
			answer.add(""); 
			return answer;
		}
		ArrayList<String> sub = subset(s.substring(1));
		ArrayList<String> answer = new ArrayList<>(sub);
		for (String x:sub) {
			answer.add(s.charAt(0) + x);
		}
		return answer;	
	}

	private void permute(String curr, boolean[] used){
		if (curr.length() == used.length){
			output.add(curr);
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if (!used[i]) {
				used[i] = true;
				permute(curr + original.charAt(i), used);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
