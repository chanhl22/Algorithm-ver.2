import java.io.*;
import java.util.Scanner;

public class B17425 {
	static final int test = 1000000; 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[test + 1];
		long[] add = new long[test + 1];
		for (int i = 1; i <= test; i++) {
			arr[i] = 1;
		}
		for (int i = 2; i <= test; i++) {
			for (int j = 1; i*j <= test; j++) {
				arr[i*j] += i;
			}
		}
		for (int i = 1; i <= test; i++) {
			add[i] = add[i-1] + arr[i];
		}
		int input = Integer.parseInt(bf.readLine());
		while(input > 0) {
			int n = Integer.parseInt(bf.readLine());
			bw.write(add[n]+"\n");
			input--;
		}
		bw.close();
	}
}