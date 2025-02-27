package Day5;

import java.util.Arrays;

public class ArrayPractice {
    static int sumOf(int[] a){
        //모든 요소의 합
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum;
    }
    static void copy(int[] a, int[] b){
        //배열 b의 모든 요소를 a로 복사
        for(int i = 0; i < a.length; i++){
            a[i] =  b[i];
        }
//        System.arraycopy(b, 0, a, 0, a.length);

    }
    static void rcopy(int[] a, int[] b){
        //배열 b의 모든 요소를 배열 a에 역순으로 복사
        for(int i = 0; i < a.length / 2; i++){
            a[i] =  b[a.length - 1 - i];
        }

        for(int i = a.length / 2; i < a.length; i++){
            a[i] = b[a.length - 1 - i];
        }
    }
    public static void main(String[]args){
        int[] b = new int[]{5,1,3,2,6};
        int[] a = new int[b.length];

        System.out.println("모든 요소의 합 : " + sumOf(b));
        copy(a, b);
        System.out.println("복사된 a의 값: " + Arrays.toString(a));
        rcopy(a,b);
        System.out.println("역순 복사 a : " + Arrays.toString(a));
    }
}
