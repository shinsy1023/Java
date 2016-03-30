import java.util.Scanner;

/**
 * Created by shinsy1023 on 2016. 3. 29..
 */
public class Num1 {
    public static void main(String args[]) {
        int team_count;
        int i;
        Scanner s = new Scanner(System.in);
        System.out.printf("오늘 방문한 팀 수를 입력해주세요.");
        team_count=s.nextInt();
        Team team[]=new Team[team_count];
        for (i=0; i<team_count; i++){
            team[i]=new Team();
            team[i].input_num(i+1);
            team[i].input_mem(i+1);
            team[i].print_charge(i+1);
        }
        System.out.printf("오늘 총 방문자 수는 %d명입니다.\n", Team.total_count);
        System.out.printf("초등학생 수는 %d명입니다.\n", Team.v_count[0]);
        System.out.printf("청소년 수는 %d명입니다.\n", Team.v_count[1]);
        System.out.printf("일반인 수는 %d명입니다.\n", Team.v_count[2]);
        System.out.printf("경로대상 수는 %d명입니다.\n\n", Team.v_count[3]);
        System.out.printf("총 입장료는 %d원입니다.", Team.total_sum);
    }
}

class Team{
    Scanner s=new Scanner(System.in);
    int count[]=new int[4];
    double sum=0;
    int membership=0;
    int i, j;
    final static int charge[]={5000, 10000, 15000, 3000};
    static int v_count[] = {0, 0, 0, 0};
    static int total_count=0;
    static int total_sum=0;

    void input_num(int num){
        System.out.printf("%d번팀 인원수(초등학생, 청소년, 일반, 경로대상)를 입력하세요.", num);
        for (i=0; i<4; i++) {
            this.count[i] = s.nextInt();
            total_count+=this.count[i];
            v_count[i]+=this.count[i];
            this.sum+=this.count[i]*charge[i];
        }
    }

    void input_mem(int num){
        System.out.printf("%d번팀 할인카드 종류(카드없음:0, 일반등급:1, VIP 등급:2)를 입력하세요.", num);
        this.membership = s.nextInt();
        if (this.membership==1){
            this.sum=this.sum*(0.9);

        }else if(this.membership==2) {
            this.sum = this.sum * (0.8);
        }
        total_sum+=(int)sum;
    }

    void print_charge(int num){
        System.out.printf("%d번 입장료는 %d원입니다.\n",num, (int)this.sum);
    }
}