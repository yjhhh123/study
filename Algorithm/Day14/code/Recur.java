package Day14;

import java.util.Scanner;

public class Recur {
    static void recur(int n){
        if(n > 0){
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        recur(x);
    }
}
