/**
 * playtime = 40m 58s
 * 풀이횟수2
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P172927 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
//        ans = sol.solution(
//                new int[]{1, 3, 2},
//                new String[]{"diamond", "diamond"}
//        );//2
        ans = sol.solution(
                new int[]{1, 0, 0},
                new String[]{"iron", "iron", "iron", "iron", "iron", "diamond", "diamond"}
        );//5
//        ans = sol.solution(
//                new int[]{0, 0, 1},
//                new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
//        ); //125
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] picks, String[] minerals) {
            //미네랄을 5개씩 있는 리스트로 변경
            List<List<String>> mineralList = new ArrayList<>();

            // 5개씩 나누기
            int totalPick = picks[0] + picks[1] + picks[2];
            for (int i = 0; i < minerals.length; i += 5) {
                List<String> subList = new ArrayList<>();
                for (int j = i; j < i + 5 && j < minerals.length; j++) {
                    subList.add(minerals[j]);
                }
                totalPick -= 1;
                if (totalPick >= 0) {
                    mineralList.add(subList);
                }
            }

            mineralList.sort(new Comparator<>() {
                @Override
                public int compare(List<String> list1, List<String> list2) {
                    int count1 = countMinerals(list1);
                    int count2 = countMinerals(list2);
                    return Integer.compare(count2, count1); // 내림차순 정렬
                }

                private int countMinerals(List<String> list) {
                    int diamondCount = 0;
                    int ironCount = 0;
                    int stoneCount = 0;

                    for (String mineral : list) {
                        switch (mineral) {
                            case "diamond":
                                diamondCount++;
                                break;
                            case "iron":
                                ironCount++;
                                break;
                            case "stone":
                                stoneCount++;
                                break;
                        }
                    }

                    // 총 개수로 정렬 기준을 설정 (diamond > iron > stone)
                    return diamondCount * 100 + ironCount * 10 + stoneCount; // 가중치를 두어 정렬
                }
            });

            return mineralList.stream()
                    .map(mineral -> {
                        if (picks[0] > 0) {
                            picks[0]--;
                            int result = 0;
                            for (String m : mineral) {
                                if ("diamond".equals(m)) {
                                    result++;
                                }
                                if ("iron".equals(m)) {
                                    result++;
                                }
                                if ("stone".equals(m)) {
                                    result++;
                                }
                            }
                            return result;
                        }

                        if (picks[1] > 0) {
                            picks[1]--;
                            int result = 0;
                            for (String m : mineral) {
                                if ("diamond".equals(m)) {
                                    result += 5;
                                }
                                if ("iron".equals(m)) {
                                    result++;
                                }
                                if ("stone".equals(m)) {
                                    result++;
                                }
                            }
                            return result;
                        }

                        if (picks[2] > 0) {
                            picks[2]--;
                            int result = 0;
                            for (String m : mineral) {
                                if ("diamond".equals(m)) {
                                    result += 25;
                                }
                                if ("iron".equals(m)) {
                                    result += 5;
                                }
                                if ("stone".equals(m)) {
                                    result++;
                                }
                            }
                            return result;
                        }

                        return 0;
                    })
                    .mapToInt(i -> i)
                    .sum();
        }
    }
}

/**
 * playtime = 39:53
 */
//class Solution172927 {
//    public int solution(int[] picks, String[] minerals) {
//        return go(picks, minerals, 0, 0);
//    }
//
//    private int go(int[] picks, String[] minerals, int index, int sum) {
//        if (index >= minerals.length || noPicks(picks)) {
//            return sum;
//        }
//
//        int ans = -1;
//        for (int i = 0; i < 3; i++) {
//            if (picks[i] > 0) {
//                int ret = findFatigue(minerals, index, i);
//
//                picks[i] -= 1;
//                int temp = go(picks, minerals, index + 5, sum + ret);
//                if (ans == -1 || ans > temp) {
//                    ans = temp;
//                }
//                picks[i] += 1;
//            }
//        }
//        return ans;
//    }
//
//    private boolean noPicks(int[] picks) {
//        for (int pick : picks) {
//            if (pick != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private int findFatigue(String[] minerals, int index, int i) {
//        int ret = 0;
//        for (int j = index; j < index + 5; j++) {
//            if (j >= minerals.length) {
//                continue;
//            }
//
//            if (i == 0) {
//                ret += 1;
//            } else if (i == 1) {
//                if (minerals[j].equals("diamond")) {
//                    ret += 5;
//                } else {
//                    ret += 1;
//                }
//            } else {
//                if (minerals[j].equals("diamond")) {
//                    ret += 25;
//                } else if(minerals[j].equals("iron")) {
//                    ret += 5;
//                } else {
//                    ret += 1;
//                }
//            }
//        }
//        return ret;
//    }
//}
//
//public class P172927 {
//    public static void main(String[] args) {
//        Solution172927 sol = new Solution172927();
//        int ans = 0;
////        ans = sol.solution(
////                new int[]{1, 3, 2},
////                new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}
////        );
//
////        ans = sol.solution(
////                new int[]{1, 3, 2},
////                new String[]{"diamond", "diamond"}
////        );
//
//        ans = sol.solution(
//                new int[]{0, 1, 1},
//                new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
//        );
//        System.out.println(ans);
//    }
//}