//playtime = 20:42

import java.util.Scanner;

public class B13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] distance = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = sc.nextInt();
        }
        long[] city = new long[n];
        long check = 0;
        for (int i = 0; i < n; i++) {
            city[i] = sc.nextInt();
            if (check != 0 && city[i] > check) {
                city[i] = check;
            } else {
                check = city[i];
            }
        }
        long ans = 0;
        for (int i = 0; i < n-1; i++) {
            ans += (city[i] * distance[i]);
        }
        System.out.println(ans);
    }
}

//Add Solution
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int N = in.nextInt();
//		long[] dist = new long[N - 1];	// 거리
//		long[] cost = new long[N];	// 비용
//		for(int i = 0; i < N - 1; i++) {
//			dist[i] = in.nextLong();
//		}
//		for(int i = 0; i < N; i++) {
//			cost[i] = in.nextLong();
//		}
//		long sum = 0;
//		long minCost = cost[0];
//		for(int i = 0; i < N - 1; i++) {
//			if(cost[i] < minCost) {
//				minCost = cost[i];
//			}
//			sum += (minCost * dist[i]);
//		}
//		System.out.println(sum);
//	}
//}