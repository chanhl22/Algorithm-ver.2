import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution54 {
    public int[] solution(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] check = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (check[i] == true) {
                continue;
            }
            check[i] = true;
            int cnt = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    cnt++;
                    check[j] = true;
                } else {
                    break;
                }
            }
            if (cnt != 0) {
                arr.add(cnt);
            }
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            int sum = arr.get(0) + arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            arr.set(0, sum);
        }
        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}


public class WO4 {
    public static void main(String[] args) {
        Solution54 sol = new Solution54();
        int[] ans = sol.solution("aaabbaaa");
        //int[] ans = sol.solution("wowwow");
        System.out.println(Arrays.toString(ans));
    }
}