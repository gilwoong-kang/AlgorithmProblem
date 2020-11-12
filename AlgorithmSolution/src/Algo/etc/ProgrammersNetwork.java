package Algo.etc;

import java.util.ArrayList;
import java.util.List;

public class ProgrammersNetwork {
    boolean[] visit;
    List<Node> nodes;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        nodes = new ArrayList<>();
        for(int i = 0;i<computers.length;i++){
            nodes.add(new Node(i));
            for(int j = 0;j<computers[i].length;j++){
                if(computers[i][j] == 1) nodes.get(i).connections.add(j);
            }
        }

        List<Node> list = new ArrayList<>();
        list.add(nodes.get(0));
        int count = 1;

        // bfs
        while(!list.isEmpty()){
            Node node = list.remove(0);
            visit[node.nodeIndex] = true;
            for(int i : node.connections){
                if(!visit[i]){
                    list.add(nodes.get(i));
                }
            }
            if(list.isEmpty()){
                int a = isAllVisit();
                if(a!=-1){
                    count++;
                    list.add(nodes.get(a));
                }
            }
        }
        answer = count;
        return answer;
    }

    private int isAllVisit(){
        for(int i=0;i<visit.length;i++){
            if(!visit[i]) return i;
        }
        return -1;
    }

    private class Node{
        List<Integer> connections;
        int nodeIndex;

        public Node(int index) {
            connections = new ArrayList<>();
            nodeIndex = index;
        }
    }
}
