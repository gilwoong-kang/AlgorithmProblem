package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1717 {
    private static int[] parent;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        init(n);
        scanner.nextLine();
        for(int i = 0;i<m;i++){
            String[] num = scanner.nextLine().split(" ");
            if(num[0].equals("1")){
                if (find(Integer.valueOf(num[1])) == find(Integer.valueOf(num[2]))) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }else{
                merge(Integer.valueOf(num[1]),Integer.valueOf(num[2]));
            }
        }
    }

    public static void init(int n){
        parent = new int[n+1];
        for(int i = 1;i<=n;i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        else{
            int p = find(parent[x]);
            parent[x] = p;
            return p;
        }
    }
    public static void merge(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y) parent[y] = x;
    }
}
