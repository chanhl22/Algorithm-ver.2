import java.util.LinkedList;
import java.util.Queue;

class Solution30 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 2;
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
        //ans = sol.solution(100, 100, new int[]{10});
        //ans = sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        System.out.println(ans);
    }
}

//Best Solution1
//class Solution {
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        Queue<Integer> bridge = new LinkedList<>();
//
//        int answer = 0;
//        for(int i=0; i<bridge_length; i++){
//            bridge.add(0);
//        }
//        int truckIdx = 0;
//        int trucksWeight = 0;
//        while(truckIdx < truck_weights.length){
//            answer++;
//            trucksWeight -= bridge.poll();
//            if(trucksWeight + truck_weights[truckIdx] <= weight){
//                bridge.add(truck_weights[truckIdx]);
//                trucksWeight += truck_weights[truckIdx];
//                truckIdx++;
//            }
//            else {
//                bridge.add(0);
//            }
//        }
//
//        return bridge_length + answer;
//    }
//}

//Best Solution2
//import java.util.*;
//
//class Solution {
//    class Truck {
//        int weight;
//        int move;
//
//        public Truck(int weight) {
//            this.weight = weight;
//            this.move = 1;
//        }
//
//        public void moving() {
//            move++;
//        }
//    }
//
//    public int solution(int bridgeLength, int weight, int[] truckWeights) {
//        Queue<Truck> waitQ = new LinkedList<>();
//        Queue<Truck> moveQ = new LinkedList<>();
//
//        for (int t : truckWeights) {
//            waitQ.offer(new Truck(t));
//        }
//
//        int answer = 0;
//        int curWeight = 0;
//
//        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
//            answer++;
//
//            if (moveQ.isEmpty()) {
//                Truck t = waitQ.poll();
//                curWeight += t.weight;
//                moveQ.offer(t);
//                continue;
//            }
//
//            for (Truck t : moveQ) {
//                t.moving();
//            }
//
//            if (moveQ.peek().move > bridgeLength) {
//                Truck t = moveQ.poll();
//                curWeight -= t.weight;
//            }
//
//            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
//                Truck t = waitQ.poll();
//                curWeight += t.weight;
//                moveQ.offer(t);
//            }
//        }
//
//        return answer;
//    }
//}
