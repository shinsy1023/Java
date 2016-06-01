import java.util.Scanner;

/**
 * Created by shinsy1023 on 2016. 5. 3..
 */
public class Run {
    public static void main(String args[]){
        boolean pass=true;
        int choice;
        Scanner s=new Scanner(System.in);
        S_manager manager=new S_manager();
        while(pass){
            System.out.printf("1)친구등록 2)전체보기 3)데이터 저장 4)종료 =>  ");
            choice=s.nextInt();
            switch (choice){
                case 1:
                    manager.insert();
                    break;
                case 2:
                    manager.print();
                    break;
                case 3:
                    manager.saveFile();
                    break;
                case 4:
                    pass=false;
                    break;
            }
        }
        System.out.printf("종료되었습니다");
        s.close();
    }
}
