package question;

class Solution113 {
    public long solution(int[][] beds, int[][] tables, int cost) {
        long answer = -1;
        int bedsLength = beds.length;
        int tablesLength = tables.length;
        for (int i = 0; i < bedsLength; i++) {
            for (int j = 0; j < tablesLength; j++) {
                int weightBed = beds[i][0];
                int heightBed = beds[i][1];
                int bedCost = beds[i][2];
                int weightTable = tables[j][0];
                int heightTable = tables[j][1];
                int tableCost = tables[j][2];
                int squareSize1 = (weightBed + weightTable) * Math.max(heightBed, heightTable);
                int squareSize2 = (weightBed + heightTable) * Math.max(heightBed, weightTable);
                int squareSize3 = (heightBed + weightTable) * Math.max(weightBed, heightTable);
                int squareSize4 = (heightBed + heightTable) * Math.max(weightBed, weightTable);
                long sum1 = (long) squareSize1 * cost + bedCost + tableCost;
                long sum2 = (long) squareSize2 * cost + bedCost + tableCost;
                long sum3 = (long) squareSize3 * cost + bedCost + tableCost;
                long sum4 = (long) squareSize4 * cost + bedCost + tableCost;
                long temp = Math.min(Math.min(Math.min(sum1, sum2), sum3), sum4);
                if (answer == -1 || answer > temp) {
                    answer = temp;
                }
            }
        }
        return answer;
    }
}


public class SquidHouse2 {
    public static void main(String[] args) {
        Solution113 sol = new Solution113();
        long ans = 0;
//        ans = sol.solution(new int[][]{{4, 1, 200000}}, new int[][]{{2, 3, 100000}}, 10000);
//        ans = sol.solution(new int[][]{{2, 3, 40}, {2, 5, 20}}, new int[][]{{1, 1, 30}}, 10000);
//        ans = sol.solution(new int[][]{{2, 3, 40000}, {2, 5, 20000}}, new int[][]{{1, 1, 30000}}, 10);
//        ans = sol.solution(new int[][]{{4, 1, 1000}}, new int[][]{{3, 2, 1000}, {5, 1, 1000}}, 10000);
        ans = sol.solution(new int[][]{{1000, 1000, 1000000}}, new int[][]{{1000, 1000, 1000000}}, 10000);
        System.out.println(ans);
    }
}