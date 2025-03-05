package Day8;

import java.util.Scanner;

public class SeqSearch {
    //요솟수가 n인 배열에서 key와 값이 같은 요소를 선형 검색
    static int seqSearch(int[] a, int n, int key){
        int i = 0;

//        while(true){
//            if(i == n){
//                return -1;
//            }
//            if(a[i] == key){
//                return i;
//            }
//            i++;
//        }
        for(i = 0; i < n; i++){
            if(a[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < x.length; i++){
            System.out.print("x [" + i +"] : ");
            x[i] = scanner.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = scanner.nextInt();

        int idx = seqSearch(x,num,ky);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }
        else{
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
