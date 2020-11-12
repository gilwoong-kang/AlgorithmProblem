package Algo.etc;

import java.util.*;
import java.math.*;

class Solution {
    static int n;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        this.n = n;
        int[][] pillar = new int[n+3][n+3];
        int[][] beam = new int[n+3][n+3];
        int count = 0;
        for(int[] i : build_frame){
            int x = i[0]+1;
            int y = i[1]+1;
            int a = i[2];
            int b = i[3];
            if(a == 0){
                if(b == 0){
                    if(pillarRemoveRule(pillar,beam,y,x)){
                        pillar[y][x] = 0;
                        count--;
                    }
                }else if(b==1){
                    if(pillarRule(pillar,beam,y,x)){
                        pillar[y][x] = 1;
                        count++;
                    }
                }
            }else{
                if(b==0){
                    if(beamRemoveRule(pillar,beam,y,x)){
                        beam[y][x] = 0;
                        count--;
                    }
                }else if(b==1){
                    if(beamRule(pillar,beam,y,x)){
                        beam[y][x] = 1;
                        count++;
                    }
                }
            }
        }

        answer = new int[count][3];
        int idx = 0;
        for (int i = 1; i <= n+1 ; i++) {
            for (int j = 1; j <= n+1; j++) {
                if(pillar[j][i] == 1){
                    answer[idx][0] = i-1;
                    answer[idx][1] = j-1;
                    answer[idx][2] = 0;
                    idx++;
                }
                if(beam[j][i] == 1){
                    answer[idx][0] = i-1;
                    answer[idx][1] = j-1;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }
        return answer;
    }

    public boolean pillarRemoveRule(int[][] pillar,int[][] beam,int y,int x){
        pillar[y][x] = 0;
        boolean result = true;
        loop:
        for (int i = 1; i <= n+1; i++) {
            for (int j = 1; j <= n+1; j++) {
                if( pillar[i][j] == 1){
                    if(!pillarRule(pillar, beam, i, j)){
                        result = false;
                        break loop;
                    }
                }
                if(beam[i][j] == 1){
                    if(!beamRule(pillar, beam, i, j)){
                        result = false;
                        break loop;
                    }
                }
            }
        }
        pillar[y][x] = 1;
        return result;
    }

    public boolean beamRemoveRule(int[][] pillar,int[][] beam,int y,int x){
        beam[y][x] = 0;
        boolean result = true;
        loop:
        for (int i = 1; i <= n+1; i++) {
            for (int j = 1; j <= n+1; j++) {
                if( pillar[i][j] == 1){
                    if(!pillarRule(pillar, beam, i, j)){
                        result = false;
                        break loop;
                    }
                }
                if(beam[i][j] == 1){
                    if(!beamRule(pillar, beam, i, j)){
                        result = false;
                        break loop;
                    }
                }
            }
        }
        beam[y][x] = 1;
        return result;
    }

    public boolean pillarRule(int[][] pillar,int[][] beam,int y,int x){
        if(y == 1) return true;
        if(pillar[y-1][x] == 1) return true;
        if(beam[y][x-1] == 1) return true;
        if(beam[y][x] == 1) return true;
        return false;
    }

    public boolean beamRule(int[][] pillar,int[][] beam,int y,int x){
        if(pillar[y-1][x] == 1) return true;
        if(pillar[y-1][x+1] == 1) return true;
        if(beam[y][x-1] == 1 && beam[y][x+1] ==1) return true;
        return false;
    }

}