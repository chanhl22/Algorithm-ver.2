/**
 * 수평선 위에 배열로 된 점과 배열로 된 선을 입력받음. 그리고 수평선 위에 점이 있는데 최소의 선만 사용해서 덮을 수 있게 하는 최소 선의 개수를 구하는 문제
 */

package question;

public class Trend3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.solution(new int[]{1, 5, 8}, new int[]{1, 3, 4, 6})
        );
    }

    static class Solution {
        public int solution(int[] dots, int[] lines) {
            int answer = 0;
            return answer;
        }
    }
}
