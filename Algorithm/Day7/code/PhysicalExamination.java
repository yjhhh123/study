package Day7;

import java.util.Scanner;

public class PhysicalExamination {

    static final int VMAX = 21;

    static class PhyscData{
        String name;
        int height;
        double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    //키의 평균
    static double aveHeight(PhyscData[] dat){
        double sum = 0.0;

        for (PhyscData physcData : dat) {
            sum += physcData.height;
        }

        return sum / dat.length;
    }

    //시력 분포
    static void distVision(PhyscData[] dat, int[] dist){
        dist[0] = 0;
        for (PhyscData physcData : dat) {
            if (physcData.vision >= 0.0 && physcData.vision <= VMAX * 10.0) {
                dist[(int) (physcData.vision * 10)]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };
        int[] vdist = new int[VMAX];

        System.out.println(" < 신체검사 리스트 > " );
        System.out.println("이름     키     시력");
        System.out.println("------------------");
        for (PhyscData physcData : x) {
            System.out.printf("%-8s%3d%5.1f\n", physcData.name, physcData.height, physcData.vision);
        }

        System.out.printf("\n 평균 키 : %5.1fcm\n", aveHeight(x));

        distVision(x,vdist);

        System.out.println("\n 시력 분포");
        for(int i = 0; i < VMAX; i++){
            System.out.printf("%3.1f~:%s\n", i / 10.0, "*".repeat(vdist[i]));
        }


    }
}
