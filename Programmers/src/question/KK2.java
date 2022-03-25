package question;

class Solution23 {
    public int solution(int n, int k) {
        boolean[] prime = new boolean[50000001];
        for (int i = 2; i < 50000001; i++) {
            if (prime[i] == false) {
                for (int j = i + i; j < 50000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        prime[0] = true;
        prime[1] = true;
        int answer = -1;
        int number = n;
        String num = "";
        while (number > 0) {
            num = (number % k) + num;
            number = number / k;
        }
        int cnt = 0;
        String[] numbers = num.split("0");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("")) continue;
            if (prime[Integer.parseInt(numbers[i])] == false) {
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
}


public class KK2 {
    public static void main(String[] args) {
        Solution23 sol = new Solution23();
        int ans = 0;
        ans = sol.solution(437674, 3);
        //ans = sol.solution(110011, 10);
        //ans = sol.solution(10, 6);
        //ans = sol.solution(1000000, 3);
        System.out.println(ans);
    }
}