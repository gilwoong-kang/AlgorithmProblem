package Algo.NHN;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class Solution {
    static char[] quickPlayer;
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        char[] players = new char[numOfAllPlayers-1];
        quickPlayer = new char[numOfQuickPlayers];
        int qp = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : namesOfQuickPlayers){
            quickPlayer[qp++] = c;
        }
        char a = 66;
        char a1 = 65;
        map.put(String.valueOf(a1).charAt(0),1);
        for(int i = 0;i<numOfAllPlayers-1;i++){
            map.put(String.valueOf(a).charAt(0),0);
            players[i] = String.valueOf(a++).charAt(0);
        }
        // 0 = 12시
        char sulrae = 'A';
        int pointer = 0;
        for(int i = 0;i<numOfGames;i++){
            if(numOfMovesPerGame[i] > 0 ){
                pointer = (pointer + numOfMovesPerGame[i])%(numOfAllPlayers-1);
            }else{
                for(int j=0;j<Math.abs(numOfMovesPerGame[i]);j++){
                    pointer--;
                    if(pointer<0){
                        pointer = numOfAllPlayers-2;
                    }
                }
            }

            if(!isQuickPlayer(players[pointer])){
                char loose = players[pointer];
                players[pointer] = sulrae;
                sulrae = loose;
                map.replace(sulrae,map.get(sulrae)+1);
            }else{
                map.replace(sulrae,map.get(sulrae)+1);
            }
        }
        for(char c : players){
            System.out.println(c + " " +map.get(c));
        }
        System.out.println(sulrae + " " + map.get(sulrae));
    }

    private static boolean isQuickPlayer(char player){
        for(char c : quickPlayer){
            if(c == player)return true;
        }
        return false;
    }
    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for(int i = 0; i < inputData.numOfGames ; i++){
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}
