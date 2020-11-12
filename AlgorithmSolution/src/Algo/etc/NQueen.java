package Algo.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueen {
    static int n;
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        // int[row][column]
        for (int i = 0; i < n; i++) {
            calc(i,0,new int[n][n]);
        }
        System.out.println(result);
    }
    static int calc(int x,int y,int[][] table){
        column(y,table);
        row(x,table);
        cross(y,x,table);
        if(x==n-1){
            result++;
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if(table[i][y+1] == 0){
                calc(i,y+1,table);
            }
        }
        return result;
    }
    static boolean check(int x,int y,int[][] table){
        if(columnCheck(y,table) && rowCheck(x,table) && crossCheck(y,x,table))return true;
        return false;
    }
    static void column(int y,int[][] table){
        for (int j = 0; j < n; j++) { table[j][y] = 1; }
    }
    static boolean columnCheck(int y,int[][] table){
        for (int i = 0; i < n; i++) {
            if(table[i][y] == 1) return false;
        }
        return true;
    }
    static  void row(int x,int[][] table){
        for (int j = 0; j < n; j++) { table[x][j] = 1; }
    }
    static boolean rowCheck(int x,int[][] table){
        for (int i = 0; i < n; i++) {
            if(table[x][i] == 1)return false;
        }
        return true;
    }
    static void cross(int y,int x,int[][] table){
        northeast(x,y,table);
        northwest(x,y,table);
        southeast(x,y,table);
        southwest(x,y,table);
    }
    static boolean crossCheck(int y,int x,int[][] table){
        if(northwestCheck(x,y,table) && northeastCheck(x,y,table) && southeastCheck(x,y,table) && southwestCheck(x,y,table)) return true;
        return false;
    }
    static void northwest(int x,int y,int[][] table){ while(x>0 && y>0){ table[x--][y--] = 1; } }
    static boolean northwestCheck(int x,int y,int[][] table){ while(x>0 && y>0){ if(table[x--][y--] == 1) return false; } return true; }
    static void northeast(int x,int y,int[][] table){ while (x<n && y>0){ table[x++][y--] = 1; } }
    static boolean northeastCheck(int x,int y,int[][] table){ while(x<n && y>0){ if(table[x++][y--] == 1) return false; } return true; }
    static void southwest(int x,int y, int[][] table){while (x>0 && y<n){ table [x--][y++] = 1;} }
    static boolean southwestCheck(int x,int y,int[][] table){ while(x>0 && y<n){ if(table[x--][y++] == 1) return false; } return true; }
    static  void southeast(int x,int y,int[][] table){while (x<n && y<n){ table[x++][y++] = 1;} }
    static boolean southeastCheck(int x,int y,int[][] table){ while(x<n && y<n){ if(table[x++][y++] == 1) return false; } return true; }
}
