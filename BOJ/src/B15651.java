import java.io.*;

public class B15651 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] a = new int[9];
	
	static void go(int index, int n, int m) throws IOException {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				bw.write(a[i] + " ");
			}
			bw.write("\n");
			return ;
		}
		for (int i = 1; i <= n; i++) {
			a[index] = i;
			go(index + 1, n, m);
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] s = bf.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		go(0, n, m);
		bw.flush();
		bw.close();
	}

}
