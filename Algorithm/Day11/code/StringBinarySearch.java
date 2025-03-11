package Day11;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] x = {
                "abstract", "assert", "boolean", "break", "byte",
                "case", "catch", "char", "class","const",
                "continue","default","do","double","else"
        };

        System.out.print("원하는 키워드 입력 : ");
        String key = scanner.next();
        String realKey = key.toLowerCase();
        System.out.println(realKey);

        int idx = Arrays.binarySearch(x, realKey);

        if(idx < 0){
            System.out.println("찾으려는 값이 없다.");
        }
        else{
            System.out.println("찾으려는 값이 " + idx + "에 있다");
        }
    }
}
