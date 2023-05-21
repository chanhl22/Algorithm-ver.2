import java.util.Scanner;

class Node1991 {
    int left;
    int right;

    public Node1991(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class B1991 {
    static void preorder(Node1991[] node, int x) {
        if (x == -1) {
            return;
        }
        System.out.print((char)(x + 'A'));
        preorder(node, node[x].left);
        preorder(node, node[x].right);
    }

    static void inorder(Node1991[] node, int x) {
        if (x == -1) {
            return;
        }
        inorder(node, node[x].left);
        System.out.print((char)(x + 'A'));
        inorder(node, node[x].right);
    }

    static void postorder(Node1991[] node, int x) {
        if (x == -1) {
            return;
        }
        postorder(node, node[x].left);
        postorder(node, node[x].right);
        System.out.print((char)(x + 'A'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node1991[] node = new Node1991[n];
        for (int i = 0; i < n; i++) {
            int x = sc.next().charAt(0) - 'A';
            char y = sc.next().charAt(0);
            char z = sc.next().charAt(0);
            int left = -1;
            int right = -1;
            if (y != '.') {
                left = y - 'A';
            }
            if (z != '.') {
                right = z - 'A';
            }
            node[x] = new Node1991(left, right);
        }
        preorder(node, 0);
        System.out.println();
        inorder(node, 0);
        System.out.println();
        postorder(node, 0);
        System.out.println();
    }
}
