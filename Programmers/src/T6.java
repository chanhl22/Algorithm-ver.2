class Solution16 {
    public long solution(int numOfStairs) {
        long answer = 0;
        long[] d = new long[71];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for (int j = 3; j <= numOfStairs; j++) {
            d[j] = d[j - 1] + d[j - 2] + d[j - 3];
        }
        answer = d[numOfStairs];
        return answer;
    }
}


public class T6 {
    public static void main(String[] args) {
        Solution16 sol = new Solution16();
        long ans = 0;
        ans = sol.solution(4);
        System.out.println(ans);
    }
}