import java.util.Scanner;

public class study4 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if(n > 0) System.out.println("양수");
        else if(n < 0) System.out.println("음수");
        else System.out.println("0");
    }
}
