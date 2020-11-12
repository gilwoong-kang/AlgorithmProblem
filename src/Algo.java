import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Algo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n  = scanner.nextInt();
        List list = new ArrayList();

        for(int i = 0; i < n ;i++){
            int x = scanner.nextInt();
            if(x == 0){
                if(list.isEmpty()) System.out.println(0);
                else{
                    Iterator<Integer> iterator = list.iterator();
                    int low = 100000;
                    while (iterator.hasNext()){
                        int next = iterator.next();
                        if(next < 0) next = next * -1;
                        if(next < low) low = next;
                    }
                    System.out.println(low);
                }
            }else{
                list.add(x);
            }
        }
    }
}
