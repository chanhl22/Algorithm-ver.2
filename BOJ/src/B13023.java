import java.util.ArrayList;
import java.util.Scanner;

class Edge13023 {
	int from, to;
	Edge13023(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

public class B13023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] a = new boolean[n][n];  //�������
		ArrayList<Integer>[] g = new ArrayList[n];  //��������Ʈ
		ArrayList<Edge13023> edges = new ArrayList<Edge13023>();  //��������Ʈ
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<Integer>();
		}
		//�ʱ�ȭ
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edges.add(new Edge13023(from, to));
			edges.add(new Edge13023(to, from));
			a[from][to] = true;
			a[to][from] = true;
			g[from].add(to);
			g[to].add(from);
		}
		m *= 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				int A = edges.get(i).from;
				int B = edges.get(i).to;
				int C = edges.get(j).from;
				int D = edges.get(j).to;
				if (A == B || A == C || A == D || B == C || B == D || C == D)
					continue;
				if (!a[B][C])
					continue;
				for (int E : g[D]) {
					if (A == E || B == E || C == E || D == E)
						continue;
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		System.out.println(0);
	}

}
