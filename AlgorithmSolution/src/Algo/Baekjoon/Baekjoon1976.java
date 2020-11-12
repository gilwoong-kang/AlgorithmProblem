package Algo.Baekjoon;

import java.util.Scanner;

public class Baekjoon1976 {
    static int[] parent;

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
            parent[x]  = p;
            return p;
        }
    }
    public static void merge(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y) parent[y] = x;
    }
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        init(n);
        int m = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i<n;i++){
            String[] num = scanner.nextLine().split(" ");
            for(int j = 0; j<n;j++){
                if(num[j].equals("1")){
                    if(i>j){
                        merge(j+1,i+1);
                    }
                    else{merge(i+1,j+1);}
                }
            }
        }
        String[] num = scanner.nextLine().split(" ");
        int r = 0;
        for(String s : num){
            if(r == 0){
                r = find(Integer.valueOf(s));
                continue;
            }else{
                if(r == find(Integer.valueOf(s))){
                    continue;
                }else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
