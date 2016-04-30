package View;

import Model.Student;

import java.util.*;

/**
 * Created by shinsy1023 on 2016. 4. 10..
 */
public class StudentManager{
    Scanner s=new Scanner(System.in);
    String name;
    String sex;
    String address;
    String P_number;
    long S_number;
    String bokhak;
    ArrayList<Student> S_man=new ArrayList<Student>();
    public int count=0;
    int i;
    Student a;
    String test_address="경기도 안산시 상록구 사동 한양대학교";
    Random r=new Random();

    public void print(){
        System.out.printf("=================================================================\n");
        System.out.printf("1)학생등록 2)정보수정 3)삭제 4)리스트 5)이름검색 6)복학생리스트 7)주소검색 8)종료\n");
        System.out.printf("=================================================================\n");
    }

    void print_Category(){
        System.out.printf("%-10s%-16s%-8s%-30s%-16s%s\n", "이름", "학번", "성별", "주소", "전화번호", "복학생");
    }

    public void regist(int index) {
        System.out.printf("학생이름, 학번, 성별을 입력하세요.\n");
        this.name = s.next();
        this.S_number = s.nextLong();
        this.sex = s.next();
        System.out.printf("주소를 입력하세요.\n");
        s.nextLine();
        this.address = s.nextLine();
        System.out.printf("전화번호를 입력하세요.\n");
        this.P_number = s.next();
        System.out.printf("복학생입니까?\n");
        this.bokhak = s.next();
        if (index != (-1)) {
            a = S_man.get(index);
            a = new Student(this.name, this.sex, this.address, this.P_number, this.S_number, this.bokhak);
            S_man.remove(index);
            S_man.add(index, a);
        } else {
            a = new Student(this.name, this.sex, this.address, this.P_number, this.S_number, this.bokhak);
            S_man.add(a);
        }
    }

    public void print_all() {
        this.print_Category();
        for (i = 0; i < count; i++) {
            a = S_man.get(i);
            a.list();
        }
    }

    public void remove(int index){
        S_man.remove(index);
    }

    public void serch(String name){
        this.print_Category();
        for (i=0; i<count; i++){
            a=S_man.get(i);
            if (a.search_name(name)){
                a.list();
            }
        }
    }

    public void serch_address(String address){
        this.print_Category();
        for (i=0; i<count; i++){
            a=S_man.get(i);
            if (a.search_address(address)){
                a.list();
            }
        }
    }

     public void serch_bokhak(){
         this.print_Category();
        for (i=0; i<count; i++){
            a=S_man.get(i);
            if (a.search_bokhak()){
                a.list();
            }
        }
    }

    public void testcase(){
        int i;
        for (i=1; i<21; i++){
            S_man.add(test(i));
        }
    }

    Student test(int index){
        String test_bokhak;
        String test_sex;
        String test_name="student"+Integer.toString(index);
        long S_num=2015000000+r.nextInt(999999);
        if(r.nextInt(2)==1){
           test_sex="M";
        }else{
            test_sex="F";
        }
        String P_num="0"+Long.toString(1000000000+r.nextInt(99999999));
        if (r.nextInt(2)==1){
            test_bokhak="Y";
        }else{
            test_bokhak="N";
        }
        return new Student(test_name, test_sex, test_address, P_num, S_num, test_bokhak);
    }
}