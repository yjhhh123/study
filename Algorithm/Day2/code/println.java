package Day2;

import java.util.Scanner;

public class study14 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n;
        int w;

        do{
            System.out.print("n값 : ");
            n = scanner.nextInt();
        }while(n <= 0);

        do{
            System.out.print("w값 : ");
            w = scanner.nextInt();
        }while(w <= 0 || w > n);

//        for(int i = 0; i < n; i++){
//            System.out.print("*");
//            if(i % w == w - 1){
//                System.out.println();
//            }
//        }
//
//        if(n % w != 0){
//            System.out.println();
//        }

        for(int i = 0; i < n / w; i++){
            System.out.println("*".repeat(w));
        }

        int rest = n % w;
        if(rest != 0){
            System.out.println("*".repeat(rest));
        }
    }
}
