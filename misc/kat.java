public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] game = new int[4];
        String result = "";
        while (sc.hasNext()) {
            for (int i = 0; i < 4; i++) {
                game[i] = sc.nextInt();
            }
            result = play(game);
            if (result.equals("End")) {
                break;
            } else {
                System.out.println(result);
            }
        }
        
        public static String play (int[] dice) {
            if 
        }
    }
}
