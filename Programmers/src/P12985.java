//playtime = 06:44

class Solution87 {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int[] match = new int[n];
        for (int i = 0; i < n; i++) {
            match[i] = i;
        }
        while (true) {
            if (match[a - 1] == match[b - 1]) {
                break;
            }
            for (int i = 0; i < n; i++) {
                match[i] = match[i] / 2;
            }
            answer++;
        }
        return answer;
    }
}

//Add Another Solution
//class Solution
//{
//    public int solution(int n, int a, int b)
//    {
//        int round = 0;
//        while(a != b)
//        {
//            a = a/2 + a%2;
//            b = b/2 + b%2;
//            round++;
//        }
//        return round;
//    }
//}

public class P12985 {
    public static void main(String[] args) {
        Solution87 sol = new Solution87();
        int ans = 0;
        ans = sol.solution(8, 4, 7);
        System.out.println(ans);
    }
}