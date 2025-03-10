package Day10;

public class BinSearchFirstFind {
    static int binSearch(int[] a, int key){
        int pl = 0;
        int pr = a.length - 1;
        int result = -1;

        while(pl <= pr) {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                result = pc;
                pr = pc - 1;

            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {1,3,5,7,7,7,7,8,8,9,9};
        int key = 7;

        int result = binSearch(array, key);
        System.out.println(result);
    }
}
