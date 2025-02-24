package Day2;

import java.util.Scanner;

public class study13 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("+-번갈아 n개 출력");
        int num;

        do{
            System.out.print("n 값 : ");
            num = scanner.nextInt();
        }while(num <= 0);

//        for(int i = 0; i < num; i++){
//            if(i % 2 != 0){
//                System.out.print("-");
//            }
//            else{
//                System.out.print("+");
//            }
//        }
//if문 n번, for문 n번, 나눗셈 n번 실행

        for(int i = 0; i < num/2; i++){
            System.out.print("+-");
        }

        if(num % 2 != 0){
            System.out.print("+");
        }
//for문 n/2, 나눗셈 2번, if문 1번 수행
    }
}
