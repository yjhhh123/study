package Day16;

import java.util.Scanner;

public class Hanoi {
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y){
        if(no > 1){
            move(no - 1, x , 6 - x - y);
        }
        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);

        if(no > 1){
            move(no - 1, 6 - x - y , y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int no = scanner.nextInt();

        move(no, 1, 3);
    }
}
