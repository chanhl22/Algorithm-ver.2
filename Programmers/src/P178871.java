//55:48

//import java.util.Arrays;
//import java.util.HashMap;
//
//class Solution178871 {
//    public String[] solution(String[] players, String[] callings) {
//        HashMap<String, Integer> map = new HashMap<>();
//        init(map, players);
//
//        for (String s : callings) {
//            Integer currentPlayerIndex = map.get(s);
//            String beforePlayerName = players[currentPlayerIndex - 1];
//            map.put(s, currentPlayerIndex - 1);
//            map.put(beforePlayerName, currentPlayerIndex + 1);
//        }
//
//        String[] answer = new String[players.length];
//        for (int i = 0; i < players.length; i++) {
//            answer[i] =
//        }
//    }
//
//    private void init(HashMap<String, Integer> map, String[] players) {
//        for (int i = 0; i < players.length; i++) {
//            map.put(players[i], i);
//        }
//    }
//
//    private void swap(String[] players, int j) {
//        String temp = players[j];
//        players[j] = players[j - 1];
//        players[j - 1] = temp;
//    }
//}
//
//public class P178871 {
//    public static void main(String[] args) {
//        Solution178871 sol = new Solution178871();
//        String[] ans = sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
//                new String[]{"kai", "kai", "mine", "mine"});
//        System.out.println(Arrays.toString(ans));
//    }
//}