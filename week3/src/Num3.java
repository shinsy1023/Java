import java.util.Scanner;

/**
 * Created by shinsy1023 on 2016. 3. 29..
 */
public class Num3 {
    public static void main(String[] args){
        int count;
        int i;
        Scanner s=new Scanner(System.in);
        System.out.printf("등록할 학생의 명 수는?");
        count=s.nextInt();
        UserInfo user[]=new UserInfo[count];
        for (i=0; i<count; i++){
            user[i]=new UserInfo();
            user[i].input(i);
        }
        System.out.printf("등록된 %d명의 학생 목록은 다음과 같습니다.\n번호 아이디        비밀번호\n", count);
        for(i=0;i<count; i++){
            user[i].print(i);
        }
    }
}

class UserInfo{
    int password;
    String ID;
    Scanner s=new Scanner(System.in);

    void input(int num){
        System.out.printf("%d번 학생의 아이디, 비밀번호를 입력하세요.", num+1);
        this.ID=s.nextLine();
        this.password=s.nextInt();
    }

    void print(int index){
        System.out.printf("%-4d%-12s%d\n", index+1, this.ID, this.password);
    }
}
