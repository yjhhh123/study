package Day9;

import java.util.Scanner;

public class searchIndex {
    static int searchIdx(int[] a, int n, int key, int[] idx){
        //int[] a = {1,9,2,9,4,6,7,9}; 요솟수 n, key9 라면 9의 ind값을 idx에 저장
        //a에서 key 값을 찾고 그때의 i 값을 idx에 저장
        int count = 0;
       for(int i = 0; i < n; i++){
           if(a[i] == key){
               idx[count++] = i;
           }
       }

        //idx 크기n을 반환
        return count;
    }

    public static void main(String[] args) {
        int[] a;
        int[] idx;
        int key;
        int size;

        Scanner scanner = new Scanner(System.in);
        int n;
        do{
            System.out.print("요솟수 : ");
            n = scanner.nextInt();
        }while (n <= 0);

        a = new int[n];


        for(int i = 0; i < n; i++){
            System.out.print("a [" + i + "] : ");
            a[i] = scanner.nextInt();
        }
        do{
            System.out.print("찾을 값 입력 : ");
            key = scanner.nextInt();
        }while(key <= 0);

        idx = new int[n];

        size = searchIdx(a, n, key, idx);

        for(int i = 0; i < size; i++){
            System.out.println("idx [" + i  + "] :" + idx[i]);
        }

    }
}
