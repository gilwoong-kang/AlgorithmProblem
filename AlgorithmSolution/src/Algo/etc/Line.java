package Algo.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] c1 = {12,7,11,6,2,12};
        int[] c2 = {1,4,10,6,9,1,8,13};
        int[] c3 = {10,13,10,1,2,3,4,5,6,2};
        int[] c4 = {3,3,3,3,3,3,3,3,3,3};

//        int r1 = solution.solution(c1);
        int r2 = solution.solution(c2);
        int r3 = solution.solution(c3);
        int r4 = solution.solution(c4);
    }


    public static class Solution{
        static int money = 0;
        public int solution(int[] cards){
            int[] player = new int[cards.length];
            int[] deal = new int[cards.length];
            int[] openD = new int[cards.length];

            player[0] = Math.min(cards[0],10);
            deal[0] = Math.min(cards[1],10);
            player[1] = Math.min(cards[2],10);
            deal[1] = Math.min(cards[3],10);
            openD[0] = deal[1];

            int firstSum = 0;

            if(player[0] == 1 && firstSum + 11 <= 21) firstSum += 11;
            else firstSum += player[0];

            if(player[1] == 1 && firstSum + 11 <= 21) firstSum += 11;
            else firstSum += player[1];

            if(firstSum == 21){
                if(dealOpen(deal,cards,4)!=21){
                    money += 3;
                    if(cards.length-4>4){
                        int[] card = new int[cards.length-4];
                        for(int i = 4;i<cards.length;i++){
                            card[i-4] = cards[i];
                        }
                        solution(card);
                    }
                    return money;
                }
            }
            int index = 4;
            int sum = 0;
            for(int i : player){
                if(i == 1 && sum + 11 >= 21){ sum += 11; }
                else sum += i;
            }
            if(openD[0] == 1 || openD[0] > 7){
                while(sum<17){
                    if(cards[index] == 1 && sum + 11 >= 21){ sum += 11; }
                    else sum += Math.min(10,cards[index++]);
                }
            }else if(openD[0] == 4 ||openD[0] == 5 ||openD[0] == 6){
            }else{
                while(sum<12){
                    if(cards[index] == 1 && sum + 11 >= 21){ sum += 11; }
                   else sum += Math.min(10,cards[index++]);
                }
            }
            if(sum>21){
                money -= 2;
                if(cards.length-index>4){
                    int[] card = new int[cards.length-4];
                    for(int i = index;i<cards.length;i++){
                        card[i-index] = cards[i];
                    }
                    solution(card);
                }
                return money;
            }
            int d = dealOpen(deal,cards,index);
            if(d>21){
                money += 2;
                if(cards.length-index>4){
                    int[] card = new int[cards.length-4];
                    for(int i = index;i<cards.length;i++){
                        card[i-index] = cards[i];
                    }
                    solution(card);
                }
                return money;
            }
            else if(d == sum) { }
            else if(d< sum){
                money += 2;
            }else money -= 2;
            if(cards.length-index>4){
                int[] card = new int[cards.length-4];
                for(int i = index;i<cards.length;i++){
                    card[i-index] = cards[i];
                }
                solution(card);
            }
            return money;
        }
        public int dealOpen(int[] deal,int[] cards,int index){
            int sum = 0;
            for(int i : deal){
                sum += i;
            }
            while(sum<17){
                sum += Math.min(10,cards[index++]);
            }
            return sum;
        }
    }
}
