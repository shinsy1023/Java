package Run;

import View.StudentManager;

import java.util.Scanner;

/**
 * Created by shinsy1023 on 2016. 4. 10..
 */
public class Run {
    public static void main(String[] args){
        int what=0;
        boolean moomin=true;
        String search;
        Scanner s=new Scanner(System.in);
        StudentManager RunApp=new StudentManager();
        while(moomin){
            RunApp.print();
            what=s.nextInt();
            switch (what) {
                case 1:
                    RunApp.regist(-1);
                    RunApp.count++;
                    break;
                case 2:
                    System.out.printf("수정할 번호를 입력해주세요");
                    what = s.nextInt();
                    RunApp.regist(what - 1);
                    break;
                case 3:
                    System.out.printf("삭제할 번호를 입력해주세요");
                    what = s.nextInt();
                    RunApp.remove(what - 1);
                    RunApp.count--;
                    break;
                case 4:
                    RunApp.print_all();
                    break;
                case 5:
                    System.out.printf("검색하실 이름을 입력하세요");
                    search = s.next();
                    RunApp.serch(search);
                    break;
                case 6:
                    RunApp.serch_bokhak();
                    break;
                case 7:
                    System.out.printf("검색하실 주소를 입력하세요");
                    search = s.next();
                    RunApp.serch_address(search);
                    break;
                case 8:
                    moomin=false;
                    break;
                case 9:
                    RunApp.testcase();
                    RunApp.count+=20;
                    break;
            }
        }
        System.out.printf("종료되었습니다.");
    }
}
