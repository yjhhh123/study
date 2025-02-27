package Day5;

import java.util.Arrays;

public class ReverseArrayProcess {
    static void swap(int[] a, int indx1, int indx2){
        int t = a[indx1];
        a[indx1] = a[indx2];
        a[indx2] = t;

    }
    static void reverse(int[] a){
        for(int i = 0; i < a.length/2; i++){
            System.out.println(Arrays.toString(a));
            swap(a, i, a.length - 1 - i);
            System.out.println("a[" + i + "]과 a[" + (a.length - 1 - i) +"]를 교환합니다.");
        }
    }
    public static void main(String[]args){
        int[] array = new int[]{2, 5, 1, 3, 9, 6, 7};

        reverse(array);
        System.out.println(Arrays.toString(array));
        System.out.print("역순 정렬을 마쳤습니다.");
    }
}
