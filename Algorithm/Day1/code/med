import java.util.Scanner;

public class study3 {
    static int med3(int a, int b, int c){
        if (a >= b){
            if(b >= c){
                return b;
            }
            else if(a <= c){
                return a;
            }
            else
                return c;
        }
        else if(c < a){
            return a;
        }
        else if(c > b){
            return b;
        }
        else
            return c;
    }

    static int med3_2(int a, int b, int c){
        if((b >= a && c <= a) || (b <= a && c >= a)){
            return a;
        }
        else if((a > b && c < b) || (a < b && c > b)){
            return b;
        }
        return c;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("a : ");
        int a = scanner.nextInt();
        System.out.print("b : ");
        int b = scanner.nextInt();
        System.out.print("c : ");
        int c = scanner.nextInt();

        System.out.println("med3 = " + med3(a,b,c));
        System.out.println("med3_2 = " + med3_2(a,b,c));
    }
}
