package Algo.Baekjoon;

import java.util.*;

public class Baekjoon1620 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<String> inputNumber = new ArrayList<>();
        Map<String,Integer> inputString = new HashMap<>();

        scanner.nextLine();
        for(int i = 0;i<n;i++){
            String input = scanner.nextLine();
            inputNumber.add(input);
            inputString.put(input,i+1);
        }
        for(int i =0;i<m;i++){
            String input = scanner.nextLine();
            if(Character.isDigit(input.charAt(0))){
                //숫자면
                System.out.println(inputNumber.get(Integer.valueOf(input)-1));
            }else{
                //아니면
                System.out.println(inputString.get(input));
            }
        }
    }

}
