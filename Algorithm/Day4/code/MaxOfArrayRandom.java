package Day4;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRandom {
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
        Random random = new Random();

        int size = scanner.nextInt();
        int[] human = new int[size];

        for(int i = 0; i < size; i++){
            human[i] = random.nextInt();
            System.out.println("human[" + i + "] : " + human[i]);
        }

        System.out.print("최대 키 : " + maxOf(human));


    }
}
