package Algo.NHN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NHN2 {
    static int count = 0;
    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        boolean[][] build = new boolean[width][10000];
        for(int i = 0;i<day;i++){
            // 벽돌 쌓기
            for (int j = 0; j < width; j++) {
                int currentPoint = 0;
                for(int x = 0;x<10000;x++){
                    if(!build[j][x]){
                        currentPoint = x;
                        break;
                    }
                }
                for(int x = 0;x<blocks[i][j];x++){ build[j][currentPoint++] = (true); }
            }
            int x = 0;
            int y = 0;
            while(!isEnd(y,build)){
                if(isAround(x,y,build)){
                    count++;
                    build[x++][y] = true;
                }
                else x++;
                if(x>width-1){
                    x = 0;
                    y++;
                }
            }
        }
        System.out.println(count);
    }
    static private boolean isEnd(int y,boolean[][] build){
        for(int i = 0;i<build.length;i++){
            if(build[i][y]) return false;
        }
        return true;
    }
    static private boolean isAround(int x,int y,boolean[][] build){
        if(build[x][y]) return false;
        boolean plus = false;
        boolean minus = false;
        for(int i = x;i<build.length;i++){
            if(build[i][y]){
                plus = true;
                break;
            }
        }
        for(int i = x ;i>=0;i--){
            if(build[i][y]){
                minus = true;
                break;
            }
        }
        return plus && minus;
    }
    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}
