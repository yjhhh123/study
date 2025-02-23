package Day2;

import java.util.Scanner;

public class study7 {
    public static void main(String[]args){
        //가우스의 덧셈으로 1부터 n까지 합
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int result = n * (n + 1) / 2;

        System.out.println("총합 :  " + result);


    }
}
