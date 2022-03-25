//playtime = 02:22:13

import java.util.*;

class Solution110 {
    static final int MAX = 8;

    public int solution(int N, int number) {
        HashSet<Integer>[] list = new HashSet[MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            list[i] = new HashSet<>();
        }
        list[1].add(N);
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; j < i; j++) {
                for (int pre : list[j]) {
                    for (int post : list[i - j]) {
                        list[i].add(pre + post);
                        list[i].add(pre - post);
                        list[i].add(pre * post);
                        if (post != 0) {
                            list[i].add(pre / post);
                        }
                    }
                }
            }
            String str = "";
            for (int j = 0; j < i; j++) {
                str += String.valueOf(N);
            }
            list[i].add(Integer.parseInt(str));
        }
        int index = 0;
        for (HashSet<Integer> check : list) {
            if (check.contains(number)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}


public class P42895 {
    public static void main(String[] args) {
        Solution110 sol = new Solution110();
        int ans = 0;
//        ans = sol.solution(5, 12);
//        ans = sol.solution(2, 11);
//        ans = sol.solution(6, 6);
//        ans = sol.solution(5, 26);
//        ans = sol.solution(8, 5800); //8
//        ans = sol.solution(5, 510);
//        ans = sol.solution(5, 55);
        ans = sol.solution(5, 555);
        System.out.println(ans);
    }
}