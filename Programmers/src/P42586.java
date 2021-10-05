import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution33 {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int date = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                date++;
            }
            q.add(date);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()) {
            int x = q.remove();
            int cnt = 1;
            while (!q.isEmpty() && x >= q.peek()) {
                q.remove();
                cnt++;
            }
            arr.add(cnt);
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}


public class P42586 {
    public static void main(String[] args) {
        Solution33 sol = new Solution33();
        //int[] ans = sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        int[] ans = sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(ans));
    }
}