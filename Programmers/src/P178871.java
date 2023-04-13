/**
 * playtime = 01:31:48
 */

import java.util.Arrays;
import java.util.HashMap;

class Solution178871 {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> name = new HashMap<>();
        initName(name, players);

        HashMap<Integer, String> rank = new HashMap<>();
        initRank(rank, players);

        for (String currentName : callings) {
            Integer currentIndex = name.get(currentName);
            String beforeName = rank.get(currentIndex - 1);
            Integer beforeIndex = name.get(beforeName);

            name.put(currentName, beforeIndex);
            name.put(beforeName, currentIndex);
            rank.put(currentIndex, beforeName);
            rank.put(beforeIndex, currentName);
        }

        String[] answer = new String[players.length];
        for (int i = 0; i < rank.size(); i++) {
            answer[i] = rank.get(i);
        }

        return answer;
    }

    private void initName(HashMap<String, Integer> map, String[] players) {
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
    }

    private void initRank(HashMap<Integer, String> map, String[] players) {
        for (int i = 0; i < players.length; i++) {
            map.put(i, players[i]);
        }
    }
}

public class P178871 {
    public static void main(String[] args) {
        Solution178871 sol = new Solution178871();
        String[] ans = sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(Arrays.toString(ans));
    }
}