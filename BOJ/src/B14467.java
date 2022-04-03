//playtime = 14467

import java.util.Arrays;
import java.util.Scanner;

public class B14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);
        int answer = 0;
        int index = 0; //입력받은 배열의 값
        for (int cow = 1; cow <= n; cow++) {
            if (index >= n) break;
            if (input[index][0] > cow) {
                continue;
            }
            if (input[index][0] == cow) {
                int temp = input[index][1];
                index++;
                while (index < n && input[index][0] == cow) {
                    if (input[index][1] != temp) {
                        temp = input[index][1];
                        answer++;
                    }
                    index++;
                }
            }
        }
        System.out.println(answer);
    }
}

//Best Solution
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class B14467 {
//	static int n;
//	static int[] cow;
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int answer=0;
//		n=sc.nextInt();
//		cow=new int[11];
//		Arrays.fill(cow, -1);
//		for (int i = 0; i < n; i++) {
//			int num=sc.nextInt();
//			int pos=sc.nextInt();
//			if(cow[num]==-1) {
//				cow[num]=pos;
//			}else if(cow[num]!=pos) {
//				cow[num]=pos;
//				answer+=1;
//			}
//		}
//		System.out.println(answer);
//	}
//}