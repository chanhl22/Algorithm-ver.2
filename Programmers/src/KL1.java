//재귀 선택
//재학생을 기준으로

class Solution19 {
    static int n;
    static boolean[] check;
    static int[] dx = {-1, 1};
    static int[] arr;
    static int kk;
    static int ans = 0;

    static void dfs(int index, int f) {
        if (index == f) {
            return;
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (check[i] == true) {
                if (arr[i] == 1) {
                    c++;
                }
            }
        }
        if (c >= kk) {
            ans++;
        }
        check[index] = true;
        dfs(index + 1,f);
    }

    public int solution(int[] student, int k) {
        int answer = -1;
        n = student.length;
        arr = student;
        kk = k;
        check = new boolean[n];
        int finish = n;
        for (int i = 0; i < n; i++) {
            dfs(0,finish);
            finish--;
        }
        answer = ans;
        return answer;
    }
}


public class KL1 {
    public static void main(String[] args) {
        Solution19 sol = new Solution19();
        int ans = 0;
        ans = sol.solution(new int[]{0, 1, 0, 0}, 1);
        System.out.println(ans);
    }
}