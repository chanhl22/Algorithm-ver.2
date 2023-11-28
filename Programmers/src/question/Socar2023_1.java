/**
 * 풀이방법 : 펜윅트리? 세그트리?
 */

package question;

import java.util.ArrayList;

class SolutionSocar2023_1 {

    private final static int MOD = 1000000000;

    public int solution(int n, int[] orders) {
        ArrayList<Integer> recordOrders = recordOrders(n, orders);
        return calculateAnswer(orders, recordOrders);
    }

    private ArrayList<Integer> recordOrders(int n, int[] orders) {
        boolean[] isChecked = new boolean[n + 1];
        ArrayList<Integer> stackedOrders = new ArrayList<>();
        for (int order : orders) {
            if (!isChecked[order]) {
                isChecked[order] = true;
                stackedOrders.add(order);
                stackedOrders.add(order);
            }
        }
        return stackedOrders;
    }

    private int calculateAnswer(int[] orders, ArrayList<Integer> recordOrders) {
        int answer = 0;
        for (int order : orders) {
            int index = recordOrders.indexOf(order);
            answer = (answer + index) % MOD;
            recordOrders.remove(index);
        }
        return answer % MOD;
    }
}

public class Socar2023_1 {
    public static void main(String[] args) {
        SolutionSocar2023_1 sol = new SolutionSocar2023_1();
//        int ans = sol.solution(3, new int[]{1, 2, 1, 3, 3, 2}); //3
//        int ans = sol.solution(4, new int[]{3, 3, 2, 2, 1, 1, 4, 4}); //0
//        int ans = sol.solution(3, new int[]{1, 3, 2, 3, 2, 1}); //5
        int ans = sol.solution(4, new int[]{3, 2, 1, 4, 1, 2, 3, 4}); //9
        System.out.println(ans);
    }
}