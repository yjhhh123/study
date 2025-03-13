package Day13;

import java.util.Scanner;

public class InQueueTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntQueue s = new IntQueue(64);

        while(true){
            System.out.println();
            System.out.printf("현재 데이터 개수 : %d / %d", s.size(), s.getCapacity());
            System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (0) 종료 : ");

            int menu = scanner.nextInt();
            if(menu == 0){
                break;
            }

            int x;
            switch (menu){
                case 1:
                    System.out.print("데이터 : ");
                    x = scanner.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntQueseException e) {
                        System.out.println("큐가 곽참");
                    }
                    break;
                case 2:
                    try {
                        x = s.deque();
                        System.out.println("디큐 값 : " + x);
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비었음");
                    }
                    break;
                case 3:
                    try{
                        x = s.peek();
                        System.out.println("피크 값 : " + x);
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비었음");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
