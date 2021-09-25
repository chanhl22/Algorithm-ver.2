import java.util.Scanner;

public class B5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int remainder = 1000 - n;
        int cnt = 0;
        while (remainder > 0) {
            if (remainder >= 500) {
                remainder -= 500;
                cnt++;
            } else if (remainder >= 100) {
                remainder -= 100;
                cnt++;
            } else if (remainder >= 50) {
                remainder -= 50;
                cnt++;
            } else if (remainder >= 10) {
                remainder -= 10;
                cnt++;
            } else if (remainder >= 5) {
                remainder -= 5;
                cnt++;
            } else if (remainder >= 1) {
                remainder -= 1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

//Best Solution
//package javaProfessioner;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main5585 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		int n = Integer.parseInt(str);
//		int [] enhwa = {500,100,50,10,5,1};		// 엔화 동전의 종류를 배열로 넣어두었음.
//		int money = 1000-n;		// 1000엔 지폐를 내고 나머지 받을 돈을 변수에 저장
//		int coin=0;		// 동전의 개수를 셀 변수
//		int i = 0;		// 동전 종류에 접근하기 위한 변수
//		while(money != 0)	// 나머지 받을 돈이 0이 될 때까지 반복
//		{
//			coin += money / enhwa[i];	// 동전의 종류 (배열)에 접근하면서 나누어 몫을 저장
//			money = money % enhwa[i];	// 500엔부터 나누고 남은 나머지를 money변수에 저장 하여 0이 될 때까지 반복함
//			i++;
//		}
//		System.out.println(coin);		// 동전의 최소 개수 출력
//	}
//}