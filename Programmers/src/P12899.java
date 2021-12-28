//playtime = 40:25

class Solution71 {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        while(n > 0) {
            int rest = n % 3;
            n /= 3;
            if (rest == 0) n--;
            answer = numbers[rest] + answer;
        }
        return answer;
    }
}


public class P12899 {
    public static void main(String[] args) {
        Solution71 sol = new Solution71();
//        String ans = sol.solution(1);
        String ans = sol.solution(10);
        System.out.println(ans);
    }
}