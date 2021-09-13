import java.util.Scanner;

public class B14890 {

	static boolean go(int[] d, int l) {
		boolean[] c = new boolean[d.length];
		for (int i = 1; i < d.length; i++) {
			if (d[i] != d[i-1]) { // ������ ĭ�� ���� �ʴٸ� �ϳ��� üũ, ���ٸ� �ٷ� true;
				if (d[i] < d[i-1]) { // ������ ĭ �� ���� Ŭ��
					if (d[i-1] - d[i] != 1) { //���̰� 1�� �ƴ� ��
						return false;
					}
					for (int j = 1; j <= l; j++) { //���θ� �δ� ��� üũ
						if (i + j - 1 >= d.length) { // ���� üũ
							return false;
						}
						if (d[i] != d[i+j-1]) { // ���� lĭ üũ
							return false;
						}
						if (c[i+j-1]) { // ���ΰ� ��ĥ ��
							return false;
						}
						c[i+j-1] = true;
					}
				} else { // ������ ĭ �� �ڰ� Ŭ��
					if (d[i] - d[i-1] != 1) { //���̰� 1�� �ƴ� ��
						return false;
					}
					for (int j = 1; j <= l; j++) { //���θ� �δ� ��� üũ
						if (i - j < 0) { // ���� üũ
							return false;
						}
						if (d[i-1] != d[i-j]) { // ���� lĭ üũ
							return false;
						}
						if (c[i-j]) { // ���ΰ� ��ĥ ��
							return false;
						}
						c[i-j] = true;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		// row
		for (int i = 0; i < n; i++) {
			int[] d = new int[n];
			for (int j = 0; j < n; j++) {
				d[j] = a[i][j];				
			}
			if (go(d, l)) {
				ans += 1;
			}
		}

		// column
		for (int j = 0; j < n; j++) {
			int[] d = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = a[i][j];				
			}
			if (go(d, l)) {
				ans += 1;
			}
		}
		System.out.println(ans);

	}

}
