package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1753 {
    static final int i_MAX = 1000000000;
    static class Edge implements Comparable<Edge> {
        int v, weight;
        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return weight + "";
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int startV = sc.nextInt();
        List<Edge>[] adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            // 첫번째가 출발지, 두번째가 도착지, 세번째가 가중치
            adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        }
        //
        // dijkstra
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        Edge[] D = new Edge[V+1];
        for (int i = 1; i <= V; i++) {
            // 원하는 출발지
            if (i == startV) {
                D[i] = new Edge(i, 0);
            } else {
                D[i] = new Edge(i, i_MAX);
            }
            pq.offer(D[i]);
        }
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            for (Edge next : adj[edge.v]) {
                // check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
                if(check[next.v]) continue;
                if (D[next.v].weight > D[edge.v].weight + next.weight)
                {
                    D[next.v].weight = D[edge.v].weight + next.weight;
                    // decrease key
                    pq.remove(D[next.v]);
                    pq.offer(D[next.v]);
                }
            }
            check[edge.v] = true;
//            if(check[edge.v]) continue;
//            check[edge.v] = true;
//
//            for(Edge e : adj[edge.v]){
//                if(D[e.v].weight > D[edge.v].weight + e.weight){
//                    D[e.v].weight = D[edge.v].weight + e.weight;
//                    pq.add(new Edge(e.v,D[e.v].weight));
//                }
//            }
        }
        for(int i =1;i<D.length;i++){
            if(D[i].weight == i_MAX) System.out.println("INF");
            else System.out.println(D[i]);
        }
    }
}
