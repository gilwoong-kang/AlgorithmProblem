package Algo.Baekjoon;

import java.util.*;

public class Baekjoon4195 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> names;


        int m = scanner.nextInt();
        for(int i = 0;i<m;i++){
            int n = scanner.nextInt();
            scanner.nextLine();
            init(n*2);
            int count = 1;
            names = new HashMap<>();
            for(int j = 0;j<n;j++){
                String[] name = scanner.nextLine().split(" ");
                int a;
                int b;
                if(!names.containsKey(name[0])){
                    names.put(name[0],count++);
                }

                if(!names.containsKey(name[1])){
                    names.put(name[1],count++);
                }
                System.out.println(merge(names.get(name[0]),names.get(name[1])));
            }
        }
    }
    static int[] parent;
    static int[] number;

    public static void init(int n){
        parent = new int[n+1];
        number = new int[200000];

        for(int i = 1;i<=n;i++){
            parent[i] = i;
            number[i] = 1;
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
    public static int merge(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[y] = x;
            number[x] += number[y];
            number[y] = 1;
        }
        return number[x];
    }
}
