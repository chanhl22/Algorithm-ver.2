import java.util.ArrayList;
import java.util.Arrays;

class Solution77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            ArrayList<Integer> extractionList = extraction(arr, x1, y1, x2, y2);
            change(extractionList);
            answer[i] = insertionAndFindMin(arr, extractionList, x1, y1, x2, y2);
        }

        return answer;
    }

    private int insertionAndFindMin(int[][] arr, ArrayList<Integer> arrayList, int x1, int y1, int x2, int y2) {
        int min = Integer.MAX_VALUE;
        for (int i = y1; i < y2; i++) {
            arr[x1][i] = arrayList.remove(0);
            if (arr[x1][i] < min) {
                min = arr[x1][i];
            }
        }
        for (int i = x1; i < x2; i++) {
            arr[i][y2] = arrayList.remove(0);
            if (arr[i][y2] < min) {
                min = arr[i][y2];
            }
        }
        for (int i = y2; i > y1; i--) {
            arr[x2][i] = arrayList.remove(0);
            if (arr[x2][i] < min) {
                min = arr[x2][i];
            }
        }
        for (int i = x2; i > x1; i--) {
            arr[i][y1] = arrayList.remove(0);
            if (arr[i][y1] < min) {
                min = arr[i][y1];
            }
        }
        return min;
    }

    private ArrayList<Integer> extraction(int[][] arr, int x1, int y1, int x2, int y2) {
        ArrayList<Integer> extractionList = new ArrayList<>();
        for (int i = y1; i < y2; i++) {
            extractionList.add(arr[x1][i]);
        }
        for (int i = x1; i < x2; i++) {
            extractionList.add(arr[i][y2]);
        }
        for (int i = y2; i > y1; i--) {
            extractionList.add(arr[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            extractionList.add(arr[i][y1]);
        }
        return extractionList;
    }

    private void change(ArrayList<Integer> arrayList) {
        int last = arrayList.remove(arrayList.size() - 1);
        arrayList.add(0, last);
    }
}

public class P77485 {
    public static void main(String[] args) {
        Solution77485 sol = new Solution77485();
//        int[] ans = sol.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}); //[8, 10, 25]
//        int[] ans = sol.solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}); //[1, 1, 5, 3]
        int[] ans = sol.solution(6, 6, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {1, 3, 2, 4}, {1, 4, 2, 5}}); //[1, 1, 5, 3]
        System.out.println(Arrays.toString(ans));
    }
}