/**
 * 수평선 위에 배열로 된 점과 배열로 된 선을 입력받음. 그리고 수평선 위에 점이 있는데 최소의 선만 사용해서 덮을 수 있게 하는 최소 선의 개수를 구하는 문제
 * (맞는 풀이인지 모르겠음.. 예시 케이스가 너무 부족함)
 */

package question.trenbe;

import java.util.Arrays;

public class Trend3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.solution(new int[]{1, 5, 8}, new int[]{1, 3, 4, 6})
        );
    }

    static class Solution {
        public int solution(int[] dots, int[] lines) {
            // 점들을 오름차순 정렬
            Arrays.sort(dots);

            int count = 0; // 필요한 선분의 최소 개수
            int coveredTill = -1; // 현재까지 덮은 가장 먼 점

            for (int dot : dots) {
                // 현재 점이 이미 덮인 범위 내에 없는 경우
                if (dot > coveredTill) {
                    count++; // 새로운 선분 추가
                    // 이 점을 덮을 수 있는 가장 긴 선분을 찾아 coveredTill 갱신
                    int maxCover = -1;
                    for (int length : lines) {
                        int end = dot + length - 1; // 선분 길이를 고려한 끝점
                        maxCover = Math.max(maxCover, end);
                    }
                    coveredTill = maxCover;
                }
            }

            return count;
        }
    }
}
