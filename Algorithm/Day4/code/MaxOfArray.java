package Day4;

import java.util.Scanner;

public class MaxOfArray {
    static int maxOf(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] human = new int[size];

        for(int i = 0; i < size; i++){
            System.out.print("키 : ");
            human[i] = scanner.nextInt();
        }

        System.out.print("최대 키 : " + maxOf(human));


    }
}
