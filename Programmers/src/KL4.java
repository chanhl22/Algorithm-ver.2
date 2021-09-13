class Solution22 {
    public int[] solution(int n) {
        int[] answer = {};
        boolean[] prime = new boolean[1000001];
        for (int i = 2; i < 1000001; i++) {
            if (prime[i] == false) {
                for (int j = i + i; j < 1000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        int p = 0;
        for (int i = 2; i < 1000001; i++) {
            if (prime[i] == false) {
                if (n % i == 0) {
                    p = i;
                    break;
                }
            }
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }
        int[] new_array = new int[n];
        int cnt = n / p;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= p; j++) {
                new_array[i%(cnt*j)] = array[i];
            }
        }


        return answer;
    }
}


public class KL4 {
    public static void main(String[] args) {
        Solution22 sol = new Solution22();
        int[] ans = sol.solution(12);
        System.out.println(ans);
    }
}