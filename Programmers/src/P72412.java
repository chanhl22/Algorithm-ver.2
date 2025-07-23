/**
 * 순위 검색
 * playtime = 1s 20m 59s
 */

import java.util.*;

public class P72412 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = sol.solution(
                new String[]{
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"}
        );
        System.out.println(Arrays.toString(ans));  // 결과 출력
    }

    static class Solution {
        Map<String, List<Integer>> infoMap = new HashMap<>();

        public int[] solution(String[] info, String[] query) {
            // 1. info 조합으로 Map 채우기
            for (String i : info) {
                String[] tokens = i.split(" ");
                String[] conditions = Arrays.copyOf(tokens, 4);
                int score = Integer.parseInt(tokens[4]);
                makeAllCombinations(conditions, 0, "", score);
            }

            // 2. 각 리스트 정렬
            for (List<Integer> list : infoMap.values()) {
                Collections.sort(list);
            }

            // 3. query 처리
            int[] answer = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                String q = query[i].replaceAll(" and ", " ");
                String[] tokens = q.split(" ");
                String key = String.join(" ", Arrays.copyOf(tokens, 4));
                int targetScore = Integer.parseInt(tokens[4]);

                if (!infoMap.containsKey(key)) {
                    answer[i] = 0;
                } else {
                    List<Integer> scoreList = infoMap.get(key);
                    int idx = lowerBound(scoreList, targetScore);
                    answer[i] = scoreList.size() - idx;
                }
            }

            return answer;
        }

        // 가능한 모든 조합을 key로 만들고 점수 추가
        private void makeAllCombinations(String[] conditions, int depth, String current, int score) {
            if (depth == 4) {
                infoMap.computeIfAbsent(current.trim(), k -> new ArrayList<>()).add(score);
                return;
            }
            // 원래 값
            makeAllCombinations(conditions, depth + 1, current + conditions[depth] + " ", score);
            // 와일드카드 -
            makeAllCombinations(conditions, depth + 1, current + "- ", score);
        }

        // 이진 탐색: target 이상인 첫 번째 인덱스 반환
        private int lowerBound(List<Integer> list, int target) {
            int left = 0, right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < target) left = mid + 1;
                else right = mid;
            }
            return left;
        }
    }
}