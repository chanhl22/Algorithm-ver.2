import java.util.Arrays;
import java.util.Scanner;

public class B2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[9];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		
		for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input.length; j++) {
				if((sum - input[i] - input[j]) == 100) {
					for (int k = 0; k < input.length; k++) {
						if (i == k || j == k)
							continue;
						System.out.println(input[k]);
					}
					System.exit(0);
				}
			}
		}
	}
}

/*import java.util.*;

public class B2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[9];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input.length; j++) {
				int sum = 0;
				for (int k = 0; k < input.length; k++) {
					if (i == k || j == k)
						continue;
					sum += input[k];
				}
				if(sum == 100) {
					for (int k = 0; k < input.length; k++) {
						if (i == k || j == k)
							continue;
						System.out.println(input[k]);
					}
					System.exit(0);
				}
			}
		}
	}
}*/