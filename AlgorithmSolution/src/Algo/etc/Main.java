package Algo.etc;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args){
//        Solution s = new Solution();
//        int n,n1;
//        n=5;n1=5;
//        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1},{5,2,1,1},{5,2,1,0}};
//        int[][] build_frame2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
//        int[][] b = {{5,0,0,1},{5,1,0,1},{5,2,0,1},{5,3,0,1},{5,4,0 ,1}};
////        s.solution(n,b);
//        s.solution(n,build_frame);
//        s.solution(n1,build_frame2);

        ProgrammersNetwork pn = new ProgrammersNetwork();
        int[][] computer = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] computer2 = {{1,1,0},{1,1,1},{0,1,1}};
        pn.solution(3,computer);
        pn.solution(3,computer2);
    }
}