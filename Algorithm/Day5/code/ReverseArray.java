package Day5;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    static void swap(int[] a, int indx1, int indx2){
        int t = a[indx1];
        a[indx1] = a[indx2];
        a[indx2] = t;
    }

    static void reverse(int[] a){
        for(int i = 0; i < a.length/2; i++){
            swap(a,i  ,a.length - i - 1);
        }
    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int size;
        int[] array;
        do{
            System.out.print("배열 크기 : ");
            size = scanner.nextInt();
        }while(size <= 0);

        array = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("array[" + i + "] :");
            array[i] = scanner.nextInt();
        }

        reverse(array);

        System.out.print(Arrays.toString(array));
    }
}
