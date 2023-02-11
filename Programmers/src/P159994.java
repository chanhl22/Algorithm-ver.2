/**
 * playtime = 10:13
 */

class Solution159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Index = 0;
        int cards2Index = 0;
        for (String findWord : goal) {
            if (findInCards1(cards1Index, cards1, findWord)) {
                cards1Index++;
            } else if (findInCards2(cards2Index, cards2, findWord)) {
                cards2Index++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    private boolean findInCards1(int cards1Index, String[] cards1, String findWord) {
        if (cards1Index >= cards1.length) {
            return false;
        }
        return findWord.equals(cards1[cards1Index]);
    }

    private boolean findInCards2(int cards2Index, String[] cards2, String findWord) {
        if (cards2Index >= cards2.length) {
            return false;
        }
        return findWord.equals(cards2[cards2Index]);
    }
}

public class P159994 {
    public static void main(String[] args) {
        Solution159994 sol = new Solution159994();
//        String ans = sol.solution(
//                new String[]{"i", "drink", "water"},
//                new String[]{"want", "to",},
//                new String[]{"i", "want", "to", "drink", "water"});
        String ans = sol.solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to",},
                new String[]{"i", "want", "to", "drink", "water"});
        System.out.println(ans);
    }
}