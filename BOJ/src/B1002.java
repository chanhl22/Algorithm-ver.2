//playtime = 39:22

import java.util.Scanner;

public class B1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	// 중점간 거리 distance의 제곱

            // case 1 : 중점이 같으면서 반지름도 같을 경우
            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            }

            // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
            else if(distance_pow > Math.pow(r1 + r2, 2)) {
                System.out.println(0);
            }

            // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
            else if(distance_pow < Math.pow(r2 - r1, 2)) {
                System.out.println(0);
            }

            // case 3-1 : 내접할 때
            else if(distance_pow == Math.pow(r2 - r1, 2)) {
                System.out.println(1);
            }

            // case 3-2 : 외접할 때
            else if(distance_pow == Math.pow(r1 + r2, 2)) {
                System.out.println(1);
            }

            else {
                System.out.println(2);
            }
        }
    }
}