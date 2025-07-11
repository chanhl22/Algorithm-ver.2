/**
 * [PCCE 기출문제] 10번 / 데이터 분석
 * playtime = 33m 33s
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P250121 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] data = {
                {1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}
        };
        int[][] ans = sol.solution(data, "date", 20300501, "remain");
        System.out.println(Arrays.deepToString(ans));
    }

    static class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            //ext = 기준
            //val_ext = 기준 값
            //sort_by = 정렬 기준 문자열
            ArrayList<ArrayList<Integer>> extractData = extractByExt(data, ext, val_ext);

            List<ArrayList<Integer>> sortedData = sortBy(sort_by, extractData);

            return convertToArray(sortedData);
        }

        private ArrayList<ArrayList<Integer>> extractByExt(int[][] data, String ext, int valExt) {
            int n = data.length;
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

            if (ext.equals("code")) {
                return filterData(data, valExt, n, lists, 0);
            } else if (ext.equals("date")) {
                return filterData(data, valExt, n, lists, 1);
            } else if (ext.equals("maximum")) {
                return filterData(data, valExt, n, lists, 2);
            } else if (ext.equals("remain")) {
                return filterData(data, valExt, n, lists, 3);
            }

            return lists;
        }

        private ArrayList<ArrayList<Integer>> filterData(int[][] data, int valExt, int n, ArrayList<ArrayList<Integer>> lists, int delimiter) {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                if (data[i][delimiter] < valExt) {
                    list.add(data[i][0]);
                    list.add(data[i][1]);
                    list.add(data[i][2]);
                    list.add(data[i][3]);
                    lists.add(list);
                }
            }
            return lists;
        }

        private List<ArrayList<Integer>> sortBy(String sort_by, ArrayList<ArrayList<Integer>> extractData) {
            return extractData.stream()
                    .sorted((o1, o2) -> {
                        if (sort_by.equals("code")) {
                            return o1.get(0) - o2.get(0);
                        } else if (sort_by.equals("date")) {
                            return o1.get(1) - o2.get(1);
                        } else if (sort_by.equals("maximum")) {
                            return o1.get(2) - o2.get(2);
                        } else if (sort_by.equals("remain")) {
                            return o1.get(3) - o2.get(3);
                        }
                        return 0;
                    }).collect(Collectors.toList());
        }

        private int[][] convertToArray(List<ArrayList<Integer>> sortedData) {
            int[][] array = new int[sortedData.size()][];
            for (int i = 0; i < sortedData.size(); i++) {
                ArrayList<Integer> row = sortedData.get(i);
                array[i] = new int[4];
                for (int j = 0; j < 4; j++) {
                    array[i][j] = row.get(j);
                }
            }
            return array;
        }
    }
}