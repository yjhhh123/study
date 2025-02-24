package Day3;

public class study16 {
    public static void main(String[]args){
        System.out.println("---------- 구구단 곱셈표 ----------");

        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                System.out.printf("%3d", i* j);
            }
            System.out.println();
        }
    }
}
