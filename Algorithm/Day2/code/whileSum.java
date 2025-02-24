package Day2;

import java.util.Scanner;

public class study5 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int sum = 0;
        while(num > 0){
            sum += num;
            num--;
        }

        System.out.println("합 : " + sum);
    }
}
