package question;

class Solution123 {
    public int solution(int b) {
        int answer = -1;
        long[] arr = new long[500001];
        for (int i = 0; i < 500001; i++) {
            arr[i] = (long) i * i - (long) b * b;
        }

        int index = b;
        for (int a = 1; a <= b; a++) {
            for (int i = index; i < 500001; i++) {
                if ((long) a * a == arr[i]) {
                    answer = i;
                    return answer;
                }
                if ((long) a * a < arr[i]) {
                    index = i;
                    break;
                }
            }
        }
        return answer;
    }
}


public class OpenServey_22_1 {
    public static void main(String[] args) {
        Solution123 sol = new Solution123();
        int ans = 0;
//        ans = sol.solution(4);
//        ans = sol.solution(12);
//        ans = sol.solution(5);
        ans = sol.solution(200000);
        System.out.println(ans);
    }
}