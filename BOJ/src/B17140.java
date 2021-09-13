import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class Pair8 implements Comparable<Pair8>{
	int num, cnt;
    Pair8(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
    public int compareTo(Pair8 that) {
    	if (this.cnt < that.cnt) {
    		return -1;
    	}
    	else if(this.cnt == that.cnt){
    		if (this.num < that.num) {
    			return -1;
    		}
    		else if(this.num == that.num) {
    			return 0;
    		}
    		else {
    			return 1;
    		}
    	}
    	else {
    		return 1;
    	}
    }
}

public class B17140 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		int k = sc.nextInt();
		int[][] a = new int[100][100];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		if (a[r][c] == k) {
			System.out.println(ans);
			System.exit(0);
		}
		
		int m = 3; 
		int n = 3;
		for (int t = 1; t <= 100; t++) {
			if (n >= m) {
				int mm = m;
				for (int i = 0; i < n; i++) {
					//HashMap���� ������ ���� ������ ���� ���� Ƚ���� ���ؼ� ����ִ´�.
					HashMap<Integer, Integer> d = new HashMap<>();
					for (int j = 0; j < m; j++) {
						if (a[i][j] == 0) continue;
						int val = 0;
						//���� ������ ���� key(������ ��)�� �ִٸ� value(���� Ƚ��)�� val������ �ִ´�.
						if (d.containsKey(a[i][j])) {
							val = d.get(a[i][j]);
						}
						val += 1;
						d.put(a[i][j], val);
					}
					//������ �ϱ� ���� ArrayList�� ����� ArrayList�� �����Ѵ�. 
					ArrayList<Pair8> v = new ArrayList<>();
					for(Entry<Integer, Integer> entry : d.entrySet()) {
						v.add(new Pair8(entry.getKey(), entry.getValue()));
					}
					Collections.sort(v);
					// 100���� ũ�� �߷����ϴµ� HashMap�̹Ƿ� 2���� ���̴� 50���� ũ�� �ڸ���.
					int l = Math.min(v.size(), 50);
					// a�迭�� HashMap���� ���� key,value�� �ִ´�.
					for (int j = 0; j < l; j++) {
						a[i][j*2] = v.get(j).num;
						a[i][j*2+1] = v.get(j).cnt;
					}
					// ���� l�� 50���� ���� �� 0���� ä�����Ѵ�. 
					for (int j = l*2; j < 100; j++) {
						a[i][j] = 0;
					}
					// �ٲ� a�迭���� ���� ������ ���� ������ �ٽ� ���ؼ� ������ �ݺ��ؾ��ϴϱ� m���� ���Ѵ�.
					if (mm < v.size()*2) {
						mm = v.size()*2;
					}
				}
				m = mm;
			}
			else {
				int nn = n;
				for (int j = 0; j < m; j++) {
					//HashMap���� ������ ���� ������ ���� ���� Ƚ���� ���ؼ� ����ִ´�.
					HashMap<Integer, Integer> d = new HashMap<>();
					for (int i = 0; i < n; i++) {
						if (a[i][j] == 0) continue;
						int val = 0;
						//���� ������ ���� key(������ ��)�� �ִٸ� value(���� Ƚ��)�� val������ �ִ´�.
						if (d.containsKey(a[i][j])) {
							val = d.get(a[i][j]);
						}
						val += 1;
						d.put(a[i][j], val);
					}
					//������ �ϱ� ���� ArrayList�� ����� ArrayList�� �����Ѵ�. 
					ArrayList<Pair8> v = new ArrayList<>();
					for(Entry<Integer, Integer> entry : d.entrySet()) {
						v.add(new Pair8(entry.getKey(), entry.getValue()));
					}
					Collections.sort(v);
					// 100���� ũ�� �߷����ϴµ� HashMap�̹Ƿ� 2���� ���̴� 50���� ũ�� �ڸ���.
					int l = Math.min(v.size(), 50);
					// a�迭�� HashMap���� ���� key,value�� �ִ´�.
					for (int i = 0; i < l; i++) {
						a[i*2][j] = v.get(i).num;
						a[i*2+1][j] = v.get(i).cnt;
					}
					// ���� l�� 50���� ���� �� 0���� ä�����Ѵ�. 
					for (int i = l*2; i < 100; i++) {
						a[i][j] = 0;
					}
					// �ٲ� a�迭���� ���� ������ ���� ������ �ٽ� ���ؼ� ������ �ݺ��ؾ��ϴϱ� m���� ���Ѵ�.
					if (nn < v.size()*2) {
						nn = v.size()*2;
					}
				}
				n = nn;
			}
			if (a[r][c] == k) {
                System.out.println(t);
                System.exit(0);
            }
		}
		System.out.println(-1);
	}

}