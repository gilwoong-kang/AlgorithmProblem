package Algo.etc;

public class UnionFind {
    int[] parent;

    public void init(int n){
        for(int i = 1;i<=n;i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(x == parent[x]) return x;
        else{
            int p = find(parent[x]);
            parent[x]  = p;
            return p;
        }
    }
    public void merge(int x,int y){
        x = find(x);
        y = find(y);

        if(x!=y) parent[y] = x;
    }
}
