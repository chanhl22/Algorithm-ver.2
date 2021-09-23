class Solution17 {
    static boolean[] check;
    static String temp;
    static boolean[] prime;
    static boolean[] comb = new boolean[10000000];

    static void go(String num, int index) {
        int n = temp.length();
        if (index == n + 1) {
            return;
        }
        if (num != "") {
            int numb = Integer.parseInt(num);
            comb[numb] = true;
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                go(num + temp.charAt(i), index + 1);
                check[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        temp = numbers;
        prime = new boolean[10000001];
        for (int i = 2; i < 10000001; i++) {
            if (prime[i] == false) {
                for (int j = i + i; j < 10000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        check = new boolean[numbers.length()];
        go("", 0);
        for (int i = 2; i < 10000000; i++){
            if (comb[i] && !prime[i]){
                answer++;
            }
        }
        return answer;
    }
}


public class K42839 {
    public static void main(String[] args) {
        Solution17 sol = new Solution17();
        int ans = 0;
        ans = sol.solution("17");
        System.out.println(ans);
    }
}
