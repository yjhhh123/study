package Day2;

import java.util.Scanner;

public class study12 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1부터 n 까지의 합을 구합니다.");

        int num;

        do{
            System.out.print("n값 : ");
            num = scanner.nextInt();
        }while(num <= 0);

        int sum = 0;
//        for(int i = 1; i <= num; i++){
//            sum += i;
//            if(i == num){
//                System.out.print(i + " = " + sum);
//            }
//            else {
//                System.out.print(i + " + ");
//            }
//        }

        for(int i = 1; i < num; i++){
            sum += i;
            System.out.print(i + " + ");
        }

        System.out.print(num + " = " + (sum + num));


    }
}
