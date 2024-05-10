import java.util.Arrays;
import java.util.HashMap;

/**
 * playtime = 21:45
 * 풀이횟수 = 2
 */

public class P178871 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ans = sol.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] result = new String[players.length];

            HashMap<String, Integer> nameMap = new HashMap<>();
            for (int rank = 0; rank < players.length; rank++) {
                nameMap.put(players[rank], rank);
            }

            HashMap<Integer, String> rankMap = new HashMap<>();
            for (int rank = 0; rank < players.length; rank++) {
                rankMap.put(rank, players[rank]);
            }

            swap(callings, nameMap, rankMap);

            for (int i = 0; i < result.length; i++) {
                result[i] = rankMap.get(i);
            }

            return result;
        }

        private void swap(String[] callings, HashMap<String, Integer> nameMap, HashMap<Integer, String> rankMap) {
            for (String calling : callings) {
                Integer curRank = nameMap.get(calling);
                String curName = rankMap.get(curRank);
                String beforeName = rankMap.get(curRank - 1);
                Integer beforeRank = nameMap.get(beforeName);

                nameMap.put(beforeName, curRank);
                nameMap.put(curName, beforeRank);
                rankMap.put(beforeRank, curName);
                rankMap.put(curRank, beforeName);
            }
        }
    }
}