/**
 * playtime = 39:53
 */

class Solution172927 {
    public int solution(int[] picks, String[] minerals) {
        return go(picks, minerals, 0, 0);
    }

    private int go(int[] picks, String[] minerals, int index, int sum) {
        if (index >= minerals.length || noPicks(picks)) {
            return sum;
        }

        int ans = -1;
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int ret = findFatigue(minerals, index, i);

                picks[i] -= 1;
                int temp = go(picks, minerals, index + 5, sum + ret);
                if (ans == -1 || ans > temp) {
                    ans = temp;
                }
                picks[i] += 1;
            }
        }
        return ans;
    }

    private boolean noPicks(int[] picks) {
        for (int pick : picks) {
            if (pick != 0) {
                return false;
            }
        }
        return true;
    }

    private int findFatigue(String[] minerals, int index, int i) {
        int ret = 0;
        for (int j = index; j < index + 5; j++) {
            if (j >= minerals.length) {
                continue;
            }

            if (i == 0) {
                ret += 1;
            } else if (i == 1) {
                if (minerals[j].equals("diamond")) {
                    ret += 5;
                } else {
                    ret += 1;
                }
            } else {
                if (minerals[j].equals("diamond")) {
                    ret += 25;
                } else if(minerals[j].equals("iron")) {
                    ret += 5;
                } else {
                    ret += 1;
                }
            }
        }
        return ret;
    }
}

public class P172927 {
    public static void main(String[] args) {
        Solution172927 sol = new Solution172927();
        int ans = 0;
//        ans = sol.solution(
//                new int[]{1, 3, 2},
//                new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}
//        );

//        ans = sol.solution(
//                new int[]{1, 3, 2},
//                new String[]{"diamond", "diamond"}
//        );

        ans = sol.solution(
                new int[]{0, 1, 1},
                new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
        );
        System.out.println(ans);
    }
}