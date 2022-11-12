// playtime = 04:12

class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            answer += check(i);
        }
        return answer;
    }

    private int check(int i) {
        int count = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                count++;
            }
        }
        return count % 2 == 0 ? i : i * -1;
    }
}

public class P77884 {
    public static void main(String[] args) {
        Solution77884 sol = new Solution77884();
        int ans = sol.solution(13, 17);
        System.out.println(ans);
    }
}