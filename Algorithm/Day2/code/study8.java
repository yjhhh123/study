package Day2;

import java.util.Scanner;

public class study8 {
    //a,b사이의 모든 정수의 합
    static int sumof(int a, int b){
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        int sum = 0;

        for(int i = a; i <= b; i++){
            sum += i;
        }

        return sum;
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int result = sumof(num1, num2);
        System.out.println(result);
    }
}
