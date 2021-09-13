import java.util.Arrays;

class Solution26 {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[10];
        int[] no = {-1};
        int ans = 0;
        int[] fin = new int[11];
        int fin_num = 0;
        for (int i = 0; i < 10; i++) { //10부터 시작
            int[] temp = new int[10];
            int m = n;
            for (int j = i; j < 10; j++) { //하나씩 채움
                if (m == 0) break;
                if (m < info[j]) continue;
                if (m - (info[j] + 1) >= 0) {
                    temp[j] = info[j] + 1;
                    m -= info[j] + 1;
                }
            }
            for (int j = 9; j >= 0; j--) {
                if (temp[j] != 0) {
                    fin[i + 1] = j;
                    break;
                }
            }
            int peach = 0;
            int lion = 0;
            int v = 10;
            for (int j = 0; j < 10; j++) {
                if (info[j] < temp[j]) {
                    lion += v;
                } else {
                    if (info[j] == 0) continue;
                    peach += v;
                }
                v--;
            }
            int temp_cal = lion - peach;
            if (ans <= temp_cal) {
                if (fin[i + 1] > fin[fin_num]) {
                    ans = temp_cal;
                    for (int j = 0; j < 10; j++) {
                        answer[j] = temp[j];
                    }
                }
                fin_num = i + 1;
            }
        }
        if (ans == 0) {
            return no;
        } else {
            return answer;
        }
    }
}


public class KK4 {
    public static void main(String[] args) {
        Solution26 sol = new Solution26();
        //int[] ans = sol.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        //int[] ans = sol.solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0});
        //int[] ans = sol.solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1});
        int[] ans = sol.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
        System.out.println(Arrays.toString(ans));
    }
}
