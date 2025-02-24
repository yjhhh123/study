package Day3;

import java.util.Scanner;

public class study15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("2자리의 양수를 입력하세요.");

        int num;

        do{
            System.out.print("num : ");
            num = scanner.nextInt();
        }while(num < 10 || num > 99);
//        while(!(num >= 10 && num <=99));

        System.out.println(num);



    }
}
