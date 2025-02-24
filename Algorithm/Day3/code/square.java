package Day3;

import java.util.Scanner;

public class study19 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("정사각형을 출력합니다.");
        int num;
        do{
            System.out.print("변의 길이 :");
            num = scanner.nextInt();
        }while(num <= 0);

        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
