//playtime = 01:47:57 (못풀었음..)

class Solution84 {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int[] alpha = new int[n];
        for (int i = 0; i < n; i++) {
            if (name.charAt(i) - 'A' <= 13) {
                alpha[i] = name.charAt(i) - 'A';
            } else {
                alpha[i] = 'Z' - name.charAt(i) + 1;
            }
        }

        boolean[] check = getBooleans(name, n);
        int cnt_right = getCntRight(n, check);
        check = getBooleans(name, n);
        int cnt_left = getCntLeft(n, check);
        for (int i = 0; i < n; i++) {
            answer += alpha[i];
        }
        answer += Math.min(cnt_right, cnt_left);
        return answer;
    }

    private boolean[] getBooleans(String name, int n) {
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (name.charAt(i) == 'A') {
                check[i] = true;
            }
        }
        return check;
    }

    private int getCntRight(int n, boolean[] check) {
        int cur = 0;
        int cnt = 0;
        while (true) {
            boolean ok = false;
            if (check[cur] == false) {
                check[cur] = true;
            }
            for (int i = 0; i < n; i++) {
                if (check[i] == false) {
                    ok = true;
                }
            }
            if (!ok) {
                break;
            }
            int p1 = cur;
            int right = 1;
            int left = 1;
            while (true) {
                if (check[++p1 % n] == true) {
                    right++;
                } else {
                    break;
                }
            }
            int p2 = cur;
            while (true) {
                if (check[(--p2 + n) % n] == true) {
                    left++;
                } else {
                    break;
                }
            }
            if (right <= left) {
                cur = p1 % n;
                cnt += right;
            } else {
                cur = (p2 + n) % n;
                cnt += left;
            }
        }
        return cnt;
    }

    private int getCntLeft(int n, boolean[] check) {
        int cur = 0;
        int cnt = 0;
        while (true) {
            boolean ok = false;
            if (check[cur] == false) {
                check[cur] = true;
            }
            for (int i = 0; i < n; i++) {
                if (check[i] == false) {
                    ok = true;
                }
            }
            if (!ok) {
                break;
            }
            int p1 = cur;
            int right = 1;
            int left = 1;
            while (true) {
                if (check[++p1 % n] == true) {
                    right++;
                } else {
                    break;
                }
            }
            int p2 = cur;
            while (true) {
                if (check[(--p2 + n) % n] == true) {
                    left++;
                } else {
                    break;
                }
            }
            if (right < left) {
                cur = p1 % n;
                cnt += right;
            } else {
                cur = (p2 + n) % n;
                cnt += left;
            }
        }
        return cnt;
    }
}


public class P42860 {
    public static void main(String[] args) {
        Solution84 sol = new Solution84();
        int ans = 0;
//        ans = sol.solution("JEROEN");
//        ans = sol.solution("JAZ");
//        ans = sol.solution("JAN");
//        ans = sol.solution("ABAAAAAAAAABB");
//        ans = sol.solution("BBBBAAAAAB"); //10
        ans = sol.solution("BBBBAAAABA"); //12
        System.out.println(ans);
    }
}
