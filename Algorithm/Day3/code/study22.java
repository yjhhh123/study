package Day3;

import java.util.Scanner;

public class study22 {
    static void spira(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= (i - 1) * 2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n;
        do{
            System.out.print("n : ");
            n = scanner.nextInt();
        }while(n <= 0);

        spira(n);
    }
}
