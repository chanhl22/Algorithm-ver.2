import java.util.*;

class Solution37 {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                answer = n - i;
                break;
            }
        }
        return answer;
    }
}

public class P42747 {
    public static void main(String[] args) {
        Solution37 sol = new Solution37();
        int ans = 0;
        //ans = sol.solution(new int[]{3, 0, 6, 1, 5});
        ans = sol.solution(new int[]{0, 3, 10, 11, 12, 13});
        System.out.println(ans);
    }
}
