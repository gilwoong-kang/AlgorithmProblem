package Algo.NHN;

import java.util.Scanner;

public class NHN3 {
    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        for(int i = 0;i<numOfOrder;i++){
            char[] order = orderArr[i].toCharArray();
            while (!isEnd(order)){
                String r =orderRule(order);
                if(r != null){
                    order = r.toCharArray();
                }
                else{
                    break;
                }
            }

            System.out.println(String.valueOf(order));
        }
    }
    private static boolean isEnd(char[] order){
        for(int i = 0;i<order.length;i++){
            if(order[i] == '(')return false;
        }
        return true;
    }
    private static String orderRule(char[] order){
        StringBuilder sb = new StringBuilder();
        int open = -1;
        int end = -1;
        for(int i = order.length-1;i>=0;i--){
            if(order[i] == '('){
                open = i;
                for(int j = open;j<order.length;j++){
                    if(order[j] == ')'){
                        end = j;
                        break;
                    }
                }
                break;
            }
        }

        String s = new String(order);
        if(open == -1) return null;
        else{
            sb.append(s.substring(0,open-1));
        }
        if(order[open-1] == 'R' || order[open-1] == 'G' ||order[open-1] == 'B'){
                for(int i = open+1;i<end;i++){
                    sb.append(order[open-1]).append(order[i]);
                }
            sb.append(s.substring(end+1));
        }else{
            for(int i = 0;i<Integer.valueOf(String.valueOf(order[open-1]));i++){
                sb.append(s.substring(open+1,end));
            }
            sb.append(s.substring(end+1));
        }

        return sb.toString();
    }
    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}
