/**
 * Created by shinsy1023 on 2016. 5. 10..
 */
public class Run {
    public static void main(String[] args){
        boolean pass=true;
        manager mag=new manager();
        mag.readFile();
        int i;
        while (pass){
            System.out.println("1. 등록 2. 삭제 3. 목록보기 4. 종료 >>  ");
            i=mag.s.nextInt();
            switch (i){
                case 1:
                    mag.insert();
                    break;
                case 2:
                    mag.delete();
                    break;
                case 3:
                    mag.print();
                    break;
                case 4:
                    pass=false;
                    break;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
