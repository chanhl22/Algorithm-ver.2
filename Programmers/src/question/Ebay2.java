package question;

import java.util.ArrayList;
import java.util.Collections;

class Solution73 {
    static int n;

    public String solution(int[] stones, int k) {
        String answer = "";
        ArrayList<String> ret = new ArrayList<>();
        n = stones.length;
        go(ret, stones, k, "");
        if (ret.isEmpty()) {
            answer = "-1";
            return answer;
        }
        int min = -1;
        for (int i = 0; i < ret.size(); i++) {
            int temp = ret.get(i).length();
            if (min == -1 || min < temp) {
                min = temp;
            }
        }
        for (int i = 0; i < ret.size(); i++) {
            int temp = ret.get(i).length();
            if (temp != min) {
                ret.remove(i);
            }
        }
        Collections.sort(ret);
        answer = ret.get(ret.size() - 1);
        return answer;
    }

    private void go(ArrayList<String> ret, int[] stones, int k, String str) {
        boolean ok = check_next(stones);
        if (!ok) {
            return;
        }
        if (ok) {
            boolean fin = check_final(k, stones);
            if (fin == true) {
                ret.add(str);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            change_stone(i, stones);
            str += i;
            go(ret, stones, k, str);
            rollback_stone(i, stones);
            str = str.substring(0, str.length() - 1);
        }
    }

    private boolean check_final(int k, int[] stones) {
        int zero = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (stones[i] == 0) {
                zero++;
            } else if (stones[i] == k) {
                last++;
            }
        }
        if (last == 1 && zero == n - 1) {
            return true;
        }
        return false;
    }

    private boolean check_next(int[] stones) {
        for (int i = 0; i < n; i++) {
            if (stones[i] == -1) {
                return false;
            }
        }
        return true;
    }

    private void change_stone(int index, int[] stones) {
        for (int i = 0; i < n; i++) {
            if (i == index) {
                stones[i] += 1;
            } else {
                stones[i] -= 1;
            }
        }
    }

    private void rollback_stone(int index, int[] stones) {
        for (int i = 0; i < n; i++) {
            if (i == index) {
                stones[i] -= 1;
            } else {
                stones[i] += 1;
            }
        }
    }
}


public class Ebay2 {
    public static void main(String[] args) {
        Solution73 sol = new Solution73();
//        String ans = sol.solution(new int[]{1, 3, 2}, 3);
//        String ans = sol.solution(new int[]{4, 2, 2, 1, 4}, 1);
        String ans = sol.solution(new int[]{5, 7, 2, 4, 9}, 20);
        System.out.println(ans);
    }
}