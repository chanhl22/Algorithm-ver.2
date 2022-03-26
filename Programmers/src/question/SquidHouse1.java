package question;

class Solution112 {
    static int n;
    static int[][] roundsInt;
    static boolean[] isCouple;

    public int solution(String[][] rounds) {
        int answer = 0;
        n = rounds.length;
        roundsInt = transform(rounds);
        isCouple = new boolean[4];
        answer += countSelectMyself(0);
        checkCouple(0);
        for (int i = 1; i < n; i++) {
            answer += countSelectImpossible(i);
        }
        return answer;
    }

    private void checkCouple(int currentIndex) {
        int[] round = new int[4];
        for (int i = 0; i < 4; i++) {
            round[i] = roundsInt[currentIndex][i];
        }

        for (int i = 0; i < 4; i++) {
            if (round[i] == i) continue;
            if (round[round[i]] == i) {
                isCouple[i] = true;
            }
        }
    }

    private int countSelectImpossible(int currentRound) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (roundsInt[currentRound][i] == i) {
                count++;
                isCouple[i] = false;
                continue;
            }
            if (isCouple[i] == true) {
                if (roundsInt[currentRound][i] == roundsInt[currentRound - 1][i]) {
                    count++;
                    isCouple[i] = false;
                } else {
                    if (roundsInt[currentRound][roundsInt[currentRound][i]] == i) {
                        isCouple[i] = true;
                    } else {
                        isCouple[i] = false;
                    }
                }
            } else {
                if (roundsInt[currentRound][roundsInt[currentRound][i]] == i) {
                    isCouple[i] = true;
                } else {
                    isCouple[i] = false;
                }
            }
        }
        return count;
    }

    private int countSelectMyself(int currentRound) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (roundsInt[currentRound][i] == i) {
                count++;
            }
        }
        return count;
    }

    private int[][] transform(String[][] rounds) {
        int[][] convert = new int[n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                convert[i][j] = rounds[i][j].charAt(0) - 'a';
            }
        }
        return convert;
    }
}


public class SquidHouse1 {
    public static void main(String[] args) {
        Solution112 sol = new Solution112();
        int ans = 0;
//        ans = sol.solution(new String[][]{{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}});
//        ans = sol.solution(new String[][]{{"b", "a", "d", "c"}, {"b", "a", "c", "d"}});
        ans = sol.solution(new String[][]{{"b", "a", "d", "c"}, {"d", "c", "b", "a"}, {"b", "a", "d", "c"}});
//        ans = sol.solution(new String[][]{{"d", "a", "a", "a"}, {"c", "a", "a", "a"}, {"b", "a", "a", "a"}});
//        ans = sol.solution(new String[][]{{"b", "a", "d", "c"}, {"b", "a", "d", "c"}, {"b", "a", "d", "c"}}); //4
//        ans = sol.solution(new String[][]{{"b", "a", "d", "c"}, {"b", "a", "d", "c"}, {"b", "a", "d", "c"}, {"b", "c", "d", "c"}, {"b", "c", "d", "c"}}); // 7
        System.out.println(ans);
    }
}