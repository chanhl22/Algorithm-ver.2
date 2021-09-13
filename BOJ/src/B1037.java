import java.util.Arrays;
import java.util.Scanner;

public class B1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] arr = new int[count];
		int temp = 0;
		for (int i = 0; i < count ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int max = arr[count-1];
		int min = arr[0];
		
//		for (int i = 0; i < count; i++) {
//			for (int j = 0; j < count-1; j++) {
//				if(arr[j] > arr[j+1]) {
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}
//		int max = arr[count-1];
//		int min = arr[0];
		
		System.out.println(max * min);
	}
}