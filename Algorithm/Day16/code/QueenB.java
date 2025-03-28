package Day16;

public class QueenB {
    //분기 조작 : 모든 경우의 수를 전부 나열
    static int[] pos = new int[8];

    static void print(){
        for(int i = 0; i < 8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for(int j = 0; j < 8; j ++){
            pos[i] = j;
            if(i == 7){
                print();
            }
            else{
                set(i + 1);
            }
        }

    }

    public static void main(String[] args) {
        set(0);
    }
}
