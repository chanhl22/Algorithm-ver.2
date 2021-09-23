import java.util.LinkedList;
import java.util.Queue;

class Solution30 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        q.add(truck_weights[0]);
        bridge.add(bridge_length + 1);
        int sum = truck_weights[0];
        int cnt = 1; // 현재 트럭
        while (!q.isEmpty()) {
            if (cnt == truck_weights.length) {
                if (bridge.peek() == answer) {
                    sum -= q.remove();
                    bridge.remove();
                    continue;
                }
                answer += 1;
                continue;
            }
            //트럭이 나갔을 때
            if (bridge.peek() == answer) {
                sum -= q.remove();
                bridge.remove();
            }
            //트럭이 들어왔을 때
            sum += truck_weights[cnt];
            if (sum <= weight) {
                q.add(truck_weights[cnt]);
                bridge.add(answer + bridge_length);
                cnt++;
            } else {
                sum -= truck_weights[cnt];
            }
            answer += 1; //걸린 시간
        }
        return answer;
    }
}


public class P42583 {
    public static void main(String[] args) {
        Solution30 sol = new Solution30();
        int ans = 0;
        ans = sol.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(ans);
    }
}