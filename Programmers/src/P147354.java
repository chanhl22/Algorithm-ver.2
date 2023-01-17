//playtime = 30:03

import java.util.Arrays;

class Solution147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        dataSort(data, col - 1);
        int[] result = calMod(data);
        return bitwiseXOR(result, row_begin, row_end);
    }

    private int bitwiseXOR(int[] result, int row_begin, int row_end) {
        int[] filterArray = filter(result, row_begin, row_end);

        if (filterArray.length == 0) {
            return 0;
        }

        int res = filterArray[0];
        for (int i = 1; i < filterArray.length; i++) {
            res = (res ^ filterArray[i]);
        }
        return res;
    }

    private int[] filter(int[] result, int row_begin, int row_end) {
        int[] temp = new int[row_end - row_begin + 1];
        for (int i = row_begin - 1, j = 0; i <= row_end - 1; i++, j++) {
            temp[j] = result[i];
        }
        return temp;
    }

    private int[] calMod(int[][] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            result[i] = sum;
        }
        return result;
    }

    private void dataSort(int[][] data, int col) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col] == o2[col]) {
                return o2[0] - o1[0];
            } else {
                return o1[col] - o2[col];
            }
        });
    }
}

public class P147354 {
    public static void main(String[] args) {
        Solution147354 sol = new Solution147354();
        int ans = 0;
        ans = sol.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3);
        System.out.println(ans);
    }
}