package question;

/**
 * 랭킹을 구하는 문제
 * 예를 들어, 2 2 1 을 입력받으면
 * 인덱스에 맞춰서 1 1 3 을 출력하는 문제
 * 예를 들어, 3 1 2 4 을 입력받으면
 * 인덱스에 맞춰서 2 4 3 1 을 출력하는 문제
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Trend2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(sol.solution(new int[]{2, 2, 1}))
        );
    }

    static class Solution {
        public int[] solution(int[] grade) {
            int[] answer = new int[grade.length];

            PriorityQueue<Pair> pq = createPair(grade);

            int tempScore = 0;
            int rank = 1;
            int tempRank = 1;
            while(!pq.isEmpty()) {
                Pair pair = pq.remove();
                if (tempScore == pair.score) {
                    int pairIndex = pair.getIndex();
                    answer[pairIndex] = rank;
                } else {
                    int pairIndex = pair.getIndex();
                    answer[pairIndex] = tempRank;
                    rank = tempRank;
                    tempScore = pair.score;
                }
                tempRank++;
            }

            return answer;
        }

        private PriorityQueue<Pair> createPair(int[] grade) {
            PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.score - o1.score);
            for (int i = 0; i < grade.length; i++) {
                pq.add(new Pair(i, grade[i]));
            }
            return pq;
        }
    }

    static class Pair {
        int index;
        int score;

        public Pair(int index, int score) {
            this.index = index;
            this.score = score;
        }

        public int getIndex() {
            return index;
        }
    }
}
