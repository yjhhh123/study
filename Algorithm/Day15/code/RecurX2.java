package Day15;

import Day12.IntStack;

import java.util.Scanner;

public class RecurX2 {
    static void recur(int n){
        IntStack s = new IntStack(n);

        while(true){
            if(n > 0){
                s.push(n);
                n = n - 1;
                continue;
            }
            if(!s.isEmpty()){
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("---------------");
        recur(x);
        System.out.println("---------------");


    }
}

