package Day12;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStack s = new IntStack(64); //최대 64개 푸쉬 가능

        while(true){
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d", s.size(), s.getCapacity());
            System.out.print("(1) 푸쉬 (2) 팝 (3) 피크 (4) 덤프 (0) 종료 : ");

            System.out.print("메뉴 : ");
            int menu = scanner.nextInt();

            if(menu == 0){
                break;
            }

            switch(menu){
                case 1:
                    System.out.print("푸시 할 값 : ");
                    int x = scanner.nextInt();
                    try{
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 참");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("팝 값 : " + s.pop());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었음");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("peek 값 : " + s.peek());
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비었음");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
