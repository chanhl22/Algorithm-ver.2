package question.ajnetwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 정렬시키는 문제
 * 스코어 a,b 총 2개 받음.
 * 총 합이 큰거 앞 순위
 * a의 총 합이 작으면 a가 더 어려운 문제며 a의 점수가 더 높은 사람이 앞 순위
 * b의 총 합이 작으면 b가 더 어려운 문제며 b의 점수가 더 높은 사람이 앞 순위
 * 총 합도 같고, 어려운 문제도 없으면 scores의 입력 순서에 맞춰서 앞 순위
 */

public class Ajnetwork2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int []ans = sol.solution(new int[][]{{85, 90}, {91, 87}, {88, 87}}); //[2,1,3]
        System.out.println(ans);
    }

    static class Solution {
        public int[] solution(int[][] scores) {
            int totalA = 0;
            for (int i = 0; i < scores.length; i++) {
                totalA += scores[i][0];
            }

            int totalB = 0;
            for (int i = 0; i < scores.length; i++) {
                totalB += scores[i][1];
            }

            List<Student> students = new ArrayList<>();
            for (int i = 0; i < scores.length; i++) {
                students.add(new Student(i, scores[i][0], scores[i][1], totalA, totalB));
            }

            List<Student> collect = students.stream()
                    .sorted((o1, o2) -> {
                        if (o2.total == o1.total) {
                            if (o1.totalA < o1.totalB) {
                                return o2.scoreA - o1.scoreA;
                            } else if (o1.totalA > o1.totalB){
                                return o2.scoreB - o1.scoreB;
                            } else {
                                return o1.index - o2.index;
                            }
                        }
                        return o2.total - o1.total;
                    })
                    .collect(Collectors.toList());

            for (int i = 0; i < collect.size(); i++) {
                collect.get(i).order = i + 1;
            }

            List<Integer> result = collect.stream()
                    .sorted(Comparator.comparingInt(o -> o.index))
                    .map(r -> r.order)
                    .collect(Collectors.toList());

            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }

        static class Student {
            int index;
            int order;
            int scoreA;
            int scoreB;
            int total;
            int totalA;
            int totalB;

            public Student(int index, int scoreA, int scoreB, int totalA, int totalB) {
                this.index = index;
                this.scoreA = scoreA;
                this.scoreB = scoreB;
                this.total = scoreA + scoreB;
                this.totalA = totalA;
                this.totalB = totalB;
            }
        }
    }
}
