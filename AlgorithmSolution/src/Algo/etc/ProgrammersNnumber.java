package Algo.etc;

import java.util.ArrayList;
import java.util.List;

public class ProgrammersNnumber {
    static int result;
    public int solution(int N, int number) {
        solve(N,0,0,number);

        return this.result;
    }

    public void solve(int N,int count, int result, int number){
        int temp = N;
        if(count > 8)
            return;
        if(result == number){
            this.result = Math.min(result,this.result);
            return;
        }
        for(int i =0;i<8;i++){
            solve(N,count + 1 + i,result + temp,number);
            solve(N,count + 1 + i,result - temp,number);
            solve(N,count + 1 + i,result / temp,number);
            solve(N,count + 1 + i,result * temp,number);

            temp = temp*10 + N;
        }
    }
}
