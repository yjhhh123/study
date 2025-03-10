package Day10;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int[] array;
        //요솟수
        do{
            System.out.print("요솟수(양수) : ");
            num = scanner.nextInt();
        }while(num <= 0);

        //배열 입력(오름차순)
        array = new int[num];
        System.out.print("a[0] : ");
        array[0] = scanner.nextInt();

        for(int i = 1; i < array.length; i++){
            do{
                System.out.print("a[" + i + "] : ");
                array[i] = scanner.nextInt();
            }while(array[i - 1] > array[i]);
        }

        //key 입력
        System.out.print("찾을 값 : ");
        int key = scanner.nextInt();

        int indx = Arrays.binarySearch(array, key);
        //결과
        System.out.println(key + "는 array[" + indx + "]에 있다");
    }
}
