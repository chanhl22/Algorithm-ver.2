import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//요청 시각(초), 걸리는 시간(초), 분류 번호, 중요도
class Solution21 {
    public int[] solution(int[][] jobs) {
        int n = jobs.length;
        int time = 1; //걸린 시간
//        int search = 0; //분류 번호
        for (int i = 0; i < jobs.length; i++) {
            time += jobs[i][1];
//            if (search < jobs[i][2]) {
//                search = jobs[i][2];
//            }
        }
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0); //1번 작업 들어옴
        arr.add(jobs[0][2]);
        int cur = jobs[0][2]; //현재 분류 번호
        int cur_time = jobs[0][1]; //걸리는 시간
        for (int i = jobs[0][0] + 1, number = 1; i < time; i++) { //number : 들어온 요청, (0번= 1번)
            //요청이 들어옴
            if (i == jobs[number][0]) {
                dq.add(number);
                number++;
            }
            if (i > cur_time) {
                dq.pollFirst();
                for (int j = 0; j < number; j++) {

                }
                //cur = ;

            }
            //요청이 끝남
            if (i == jobs[i][1]) {
                dq.pollFirst();
            }

            //if ()
        }

        return answer;
    }
}


public class KL3 {
    public static void main(String[] args) {
        Solution21 sol = new Solution21();
        int[] ans = sol.solution(new int[][]{{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}});
        System.out.println(ans);
    }
}