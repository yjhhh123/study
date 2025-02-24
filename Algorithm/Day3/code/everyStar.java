package Day3;

import java.util.Scanner;

public class study21 {
    static void triangleLB(int n){
        System.out.println("왼쪽 아래가 직각인 이등변 삼각형");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n){
        System.out.println("왼쪽 위가 직각인 이등변 삼각형");
        for(int i = 0; i < n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n){
        System.out.println("오른쪽 위가 직각인 이등변 삼각형");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int j = n - i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n){
        System.out.println("오른쪽 아래가 직각인 이등변 삼각형");
        for(int i = 1; i <= n; i++){
            for(int j = n - 1; j >= i; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
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

        triangleLB(n);
        System.out.println();

        triangleLU(n);
        System.out.println();

        triangleRU(n);
        System.out.println();

        triangleRB(n);
        System.out.println();
    }
}
