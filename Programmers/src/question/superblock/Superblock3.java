package question.superblock;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Superblock3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.solution(new int[][]{{3, 1}, {0, 1}, {5, 1}, {0, 4}, {4, 4}, {5, 3}},
                        new int[][]{{1, 1}, {2, 2}},
                        3)
        );
    }

    static class Bomb {
        int x, y, idx;
        boolean isBomb;

        public Bomb(int x, int y, int idx, boolean isBomb) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.isBomb = isBomb;
        }
    }

    static class Solution {

        //        private final static int LEN = 100001;
        private final static int LEN = 1001;
        private static final Bomb[] B = new Bomb[LEN];
        private static final int[][] MAP = new int[LEN][LEN];
        private static int N;

        public int solution(int[][] bomb, int[][] box, int k) {
            N = bomb.length;
            input(bomb);
            initMap(box);

            // 같은 x나 y축에 포함
            // 중간에 상자 x


            Arrays.sort(B, (o1, o2) -> {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            });


            int result = 0;
            for (int i = 0; i < N; i++) {
                Bomb findBomb = B[i];
                findBomb.isBomb = true;

                if (MAP[findBomb.x][findBomb.y] != 1) {
                    result++;
                }

                MAP[findBomb.x][findBomb.y] = 1; // 터짐

                for (int count = 1; count <= k; count++) {
                    //상
                    if (findBomb.y - count >= 0) {
                        if (MAP[findBomb.x][findBomb.y - count] == -1) {
                            break;
                        }
                        MAP[findBomb.x][findBomb.y - count] = 1;
                    }
                }

                for (int count = 1; count <= k; count++) {
                    //하
                    if (findBomb.y + count < LEN) {
                        if (MAP[findBomb.x][findBomb.y + count] == -1) {
                            break;
                        }
                        MAP[findBomb.x][findBomb.y + count] = 1;
                    }
                }

                for (int count = 1; count <= k; count++) {
                    //좌
                    if (findBomb.x - count >= 0) {
                        if (MAP[findBomb.x - count][findBomb.y] == -1) {
                            break;
                        }
                        MAP[findBomb.x - count][findBomb.y] = 1;
                    }
                }

                for (int count = 1; count <= k; count++) {
                    //우
                    if (findBomb.x + count < LEN) {
                        if (MAP[findBomb.x + count][findBomb.y] == -1) {
                            break;
                        }
                        MAP[findBomb.x + count][findBomb.y] = 1;
                    }
                }
            }

            return result;
        }

        private void input(int[][] bomb) {
            for (int i = 0; i < N; i++) {
                B[i] = new Bomb(bomb[i][0], bomb[i][1], i, false);
            }

        }

        private void initMap(int[][] box) {
            for (int i = 0; i < box.length; i++) {
                MAP[box[i][0]][box[i][1]] = -1;
            }
        }

    }
}