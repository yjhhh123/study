package Day10;

public class BinSearchDetail {
    static void printArray(int[] a, int pc){
        System.out.printf("%2d |", pc);
        for(int i = 0; i < a.length; i++){
            System.out.printf("%3d", a[i]);
        }
        System.out.println();
    }

    static void printProcess(int[] a, int pl, int pc, int pr){
        System.out.print("   |");
        for(int i = 0; i < a.length; i++){
            if(pl == i){
                System.out.print("  < ");
            }
            else if(pc == i){
                System.out.print(" + ");
            }
            else if(pr == i){
                System.out.print(" > ");
            }
            else{
                System.out.print("   ");
            }
        }
        System.out.println();
    }
    static void binSearch(int[] a, int key){
        int pl = 0;
        int pr = a.length - 1;

        do{
            int pc = (pl + pr) / 2;

            printProcess(a, pl, pc, pr);
            printArray(a, pc);

            if(a[pc] == key){
                System.out.println("발견");
                return;
            }
            else if(a[pc] < key){
                pl = pc + 1;
            }
            else{
                pr = pc - 1;
            }
        }while(pl <= pr);
        System.out.println("없음");
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,5,6,8,9};
        int key = 2;

        System.out.print("   |");
        for(int i = 0; i < array.length; i++){
            System.out.printf("%3d", i);
        }

        System.out.println();
        System.out.println("---+----------------------");

        binSearch(array, key);

    }
}
