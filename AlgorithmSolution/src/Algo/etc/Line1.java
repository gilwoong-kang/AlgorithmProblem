package Algo.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Line1 {
    public static void main(String[] args){
        int coni;
        int beforeConi;
        int brown;
        Scanner scanner = new Scanner(System.in);

        coni = scanner.nextInt();
        beforeConi = coni;
        brown = scanner.nextInt();
        boolean brownfirst = true;

        List<Integer> brownListA = new ArrayList();
        int count = 0;

        while(true){
            int conimove = coni - beforeConi + 1;
            beforeConi = coni;
            coni = coni + conimove;

            if(brownfirst){
                brownListA.add(brown-1);
                brownListA.add(brown+1);
                brownListA.add(brown*2);
                brownfirst = false;
            }else{
                List b = new ArrayList();
                for(int i : brownListA){
                    if(coni == i-1 || coni == i+1 ||coni == i*2){
                        System.out.println(count+1);
                        return;
                    }
                    b.add(i+1);
                    b.add(i-1);
                    b.add(i*2);
                }
                brownListA = b;
            }
            count++;
        }
    }
}
