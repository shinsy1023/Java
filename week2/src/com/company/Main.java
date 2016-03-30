package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        num1 first=new num1();
        num2 second=new num2();
        num3 third=new num3();
        //first.num1();
        second.num2();
        //third.num3();
    }
}

class num1{
    public static void num1(){
        Scanner s=new Scanner(System.in);
        int number;
        int max_num=0, min_num=100;
        while(true) {
            System.out.println("0부터 100사이의 숫자를 입력하세요.");
            number = s.nextInt();
            if (number < 0 || number > 100) {
                System.out.println("입력된 숫자들 중 가장 큰 수는 " + max_num + "이고, 가장 작은 수는 " + min_num + " 입니다.");
                break;
            }
            min_num=Math.min(number, min_num);
            max_num=Math.max(number, max_num);
        }
    }
}

class num2 {
    public static void num2(){
        int h;
        Scanner s=new Scanner(System.in);
        System.out.printf("이등변 삼각형의 높이를 입력하시오.");
        h=s.nextInt();
        for (int i=0; i<h; i++){
            for (int j=0; j<h-i-1; j++){
                System.out.printf(" ");
            }
            for (int j=h; j>h-i-1; j--){
                System.out.printf("*");
            }
            for (int j=h; j>h-i; j--){
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }
}

class num3 {
    public static void num3() {
        Scanner s = new Scanner(System.in);
        double height[] = new double[10];
        double weight[] = new double[10];
        int bmi[] = new int[10];
        int count = 0;
        int i;
        for (i = 0; i < 10; i++) {
            System.out.printf("%d번째 사람의 신장(cm) 체중(kg)을 입력하시오. ", (i + 1));
            height[i] = (s.nextDouble() / 100);
            weight[i] = s.nextDouble();
            bmi[i] = (int) (weight[i] / (height[i] * height[i]));
        }
        for (i = 0; i < 10; i++) {
            if (bmi[i] >= 25) {
                count++;
                System.out.printf("%d번째 사람은 비만입니다.\n", (i + 1));
            }
        }
        System.out.printf("총 %d명의 사람 비만입니다.", count);
    }
}
//166 56 176 90 187 60 155 47 170 75 173 80 165 50 182 73 158 48 170 66