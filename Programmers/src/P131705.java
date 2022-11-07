// playtime = 40:51

class Solution131705 {

    static int ans = 0;

    public int solution(int[] number) {
        go(0, 0, 0, number.length, number);
        return ans;
    }

    private void go(int index, int sum, int selected, int n, int[] number) {
        if (selected == 3 && sum == 0) {
            ans++;
            return;
        }
        if (index >= n || selected >= 3) {
            return;
        }
        go (index + 1, sum + number[index], selected + 1, n, number);
        go (index + 1, sum, selected, n, number);
    }
}

public class P131705 {
    public static void main(String[] args) {
        Solution131705 sol = new Solution131705();
//        int ans = sol.solution(new int[]{-2, 3, 0, 2, -5});
//        int ans = sol.solution(new int[]{-3, -2, -1, 0, 1, 2, 3});
        int ans = sol.solution(new int[]{-1, 1, -1, 1});
        System.out.println(ans);
    }
}