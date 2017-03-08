/**
 * Created by shinsy1023 on 2017. 1. 4..
 */
import java.util.Scanner;

public class TotAvr {

    public static int tot(int x, int y, int z){
        return x+y+z;
    }

    public static double avr(int x, int y, int z){
        return (x+y+z)/3.0;
    }

    public static void main(String[] args) {

        int total;
        double average;

        System.out.println("국어 점수를 입력하세요. ");
        Scanner scanner = new Scanner(System.in);
        int kor = scanner.nextInt();
        System.out.println("영어 점수를 입력하세요. ");
        int eng = scanner.nextInt();
        System.out.println("수학 점수를 입력하세요. ");
        int math = scanner.nextInt();

        total=tot(kor, eng, math);
        average=avr(kor, eng, math);
        System.out.println("입력하신 점수의 총점은 "+total+" 이고,"+"\n"+"평균은 "+average+" 입니다.");

        scanner.close();
    }
}