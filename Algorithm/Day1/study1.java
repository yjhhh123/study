import java.util.Scanner;

public class study1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.print("A의 값 : ");
        int a = scanner.nextInt();

        System.out.print("B의 값 : ");
        int b = scanner.nextInt();

        System.out.print("C의 값 : ");
        int c = scanner.nextInt();

        int max = a;
        //max 에 A 값을 넣는다.

        if(b > max) max = b;
        //B값이 max보다 크면 max에 B값 넣는다
        if(c > max) max = c;
        //C값이 max보다 크면 max에 C값 넣는다

        System.out.println("max = " + max);
    }
}