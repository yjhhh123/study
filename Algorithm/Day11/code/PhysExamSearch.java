package Day11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhyscData{
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhyscData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }
        
        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        
        private static class HeightOrderComparator implements Comparator<PhyscData>{
            public int compare(PhyscData d1, PhyscData d2){
                return (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("박준서", 175, 2.0),
        };

        System.out.print("키가 몇 cm 인 사람을 찾고 있나요? : ");
        int height = scanner.nextInt();
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("",height,0.0),
                PhyscData.HEIGHT_ORDER
        );

        if(idx < 0){
            System.out.println("없다");
        }
        else{
            System.out.println("그 값은 x[" + idx + "]에 있다.");
            System.out.println("찾은 값 : " + x[idx]);
        }

        
    }
    
}
