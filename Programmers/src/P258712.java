/**
 * 가장 많이 받은 선물
 * playtime = 1h 14m 09s
 */

import java.util.HashMap;

public class P258712 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(
//                new String[]{"muzi", "ryan", "frodo", "neo"},
//                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
//        );
        ans = sol.solution(
                new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
        );
        System.out.println(ans);
    }

    static class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;

            HashMap<String, Integer> friendMap = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                friendMap.put(friends[i], i);
            }

            int[] giftStatus = new int[friends.length];
            int[][] giftFromTo = new int[friends.length][friends.length];
            for (String gift : gifts) {
                String[] name = gift.split(" ");
                giftStatus[friendMap.get(name[0])]++;
                giftStatus[friendMap.get(name[1])]--;
                giftFromTo[friendMap.get(name[0])][friendMap.get(name[1])]++;
            }

            for (int i = 0; i < giftFromTo.length; i++) {
                int giftPoint = 0;
                for (int j = 0; j < giftFromTo[i].length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (giftFromTo[i][j] > giftFromTo[j][i]) {
                        giftPoint++;
                    }
                    if (giftFromTo[i][j] == giftFromTo[j][i]) {
                        if (giftStatus[i] > giftStatus[j]) {
                            giftPoint++;
                        }
                    }
                }
                answer = Math.max(answer, giftPoint);
            }

            return answer;
        }
    }

}
