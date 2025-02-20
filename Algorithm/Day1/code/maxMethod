import java.util.Scanner;

public class study2 {
    static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    static int max4(int a, int b, int c, int d){
        int max = max3(a, b, c);
        if(d > max) max = d;

        return max;
    }

    static int min3(int a, int b, int c){
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d){
        int min = min3(a, b, c);
        if(d < min) min = d;

        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a : ");
        int a = scanner.nextInt();
        System.out.print("b : ");
        int b = scanner.nextInt();
        System.out.print("c : ");
        int c = scanner.nextInt();
        System.out.print("d : ");
        int d = scanner.nextInt();

        System.out.println("max3 = " + max3(a,b,c));
        System.out.println("max4 = " + max4(a,b,c,d));
        System.out.println("min3 = " + min3(a,b,c));
        System.out.println("min4 = " + min4(a,b,c,d));

    }
}
