/**
 * playtime = 43m 51s
 */

import java.util.Arrays;

class Solution155651 {
    public int solution(String[][] book_time) {
        int totalLength = book_time.length;
        int[][] bookTime = convertMin(book_time);
        return findTotalCount(totalLength, bookTime);
    }

    private int findTotalCount(int totalLength, int[][] bookTime) {
        boolean[] check = new boolean[totalLength];
        int answer = 0;

        while (true) {
            int standard = findStandard(check);
            if (standard == -1) {
                break;
            }
            answer++;
            check[standard] = true;
            for (int j = 0; j < totalLength; j++) {
                if (bookTime[standard][1] + 10 <= bookTime[j][0] && !check[j]) {
                    check[j] = true;
                    standard = j;
                }
            }
        }

        return answer;
    }

    private int findStandard(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                return i;
            }
        }
        return -1;
    }

    private int[][] convertMin(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i][0] = covertStringToInt(book_time[i][0]);
            bookTime[i][1] = covertStringToInt(book_time[i][1]);
        }
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0]);
        return bookTime;
    }

    private int covertStringToInt(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}

public class P155651 {
    public static void main(String[] args) {
        Solution155651 sol = new Solution155651();
//        int ans = sol.solution(new String[][]{
//                {"15:00", "17:00"},
//                {"16:40", "18:20"},
//                {"14:20", "15:20"},
//                {"14:10", "19:20"},
//                {"18:20", "21:20"}});
        int ans = sol.solution(new String[][]{
                {"09:10", "10:10"},
                {"10:20", "12:20"}});
        System.out.println(ans);
    }
}