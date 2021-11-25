//playtime = more than 2 hours

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        char[][] map = new char[r][c];
        boolean[][] check_water = new boolean[r][c];
        boolean[][] check_animal = new boolean[r][c];
        int[][] animal_d = new int[r][c];
        int ex = 0;
        int ey = 0;
        Queue<Integer> water_q = new LinkedList<>();
        Queue<Integer> animal_q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'D') {
                    ex = i;
                    ey = j;
                }
                if (map[i][j] == 'S') {
                    animal_q.add(i);
                    animal_q.add(j);
                    check_animal[i][j] = true;
                }
                if (map[i][j] == '*') {
                    water_q.add(i);
                    water_q.add(j);
                    check_water[i][j] = true;
                }
            }
        }
        while (true) {
            //물 이동 체크
            int size = water_q.size();
            for (int i = 0; i < size; i += 2) {
                int x = water_q.remove();
                int y = water_q.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (check_water[nx][ny] == false && map[nx][ny] != 'X'
                                && map[nx][ny] != 'D') {
                            check_water[nx][ny] = true;
                            water_q.add(nx);
                            water_q.add(ny);
                        }
                    }
                }
            }
            //고슴도치 이동 체크
            size = animal_q.size();
            //더이상 고슴도치가 이동하지 않으면 끝
            if (size == 0) {
                break;
            }
            for (int i = 0; i < size; i += 2) {
                int x = animal_q.remove();
                int y = animal_q.remove();
                if (x == ex && y == ey) {
                    System.out.println(animal_d[ex][ey]);
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if (check_animal[nx][ny] == false && check_water[nx][ny] == false
                                && map[nx][ny] != 'X') {
                            check_animal[nx][ny] = true;
                            animal_d[nx][ny] = animal_d[x][y] + 1;
                            animal_q.add(nx);
                            animal_q.add(ny);
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}