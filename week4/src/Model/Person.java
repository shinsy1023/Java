package Model;

import java.util.*;

/**
 * Created by shinsy1023 on 2016. 4. 5..
 */
public class Person {
    protected String name;
    protected String sex;
    protected String address;
    protected String P_number;

    Person(String n, String s, String a, String num){
        this.name=n;
        this.sex=s;
        this.address=a;
        this.P_number=num;
    }
}

class Student extends Person{
    protected long S_number;
    protected String bokhak;

    Student(String n, String s, String a, String Pnum, long Snum, String b){
        super(n, s, a, Pnum);
        this.S_number=Snum;
        this.bokhak=b;
    }

    void list(int i) {
        System.out.printf("%3d%8s%12ld%3s%20s%15s%s\n", i, this.name, this.S_number, this.sex, this.address, this.P_number, this.bokhak);
    }
}

class StudentManager{
    Scanner s=new Scanner(System.in);
    String name;
    String sex;
    String address;
    String P_number;
    long S_number;
    String bokhak;
    int where;
    ArrayList<Student> S_man=new ArrayList<Student>();
    int count=0;
    int i;
    Student a;

    void print(){
        System.out.printf("1)학생등록 2)정보수정 3)삭제 4)리스트 5)이름검색 6)복학생리스트 7)주소검색 8)종료\n=========================================================");
    }

    Student regist(Student a) {
        System.out.printf("학생이름, 학번, 성별을 입력하세요.");
        this.name = s.next();
        this.S_number = s.nextLong();
        this.sex = s.next();
        System.out.printf("주소를 입력하세요.");
        this.address = s.nextLine();
        System.out.printf("전화번호를 입력하세요.");
        this.P_number = s.next();
        System.out.printf("복학생입니까?");
        this.bokhak = s.next();
        a = new Student(this.name, this.sex, this.address, this.P_number, this.S_number, this.bokhak);
        return a;
    }

    void print_all() {
        System.out.printf("번호 이름    학번        성별 주소           전화번호           복학생\n");
        for (i = 0; i < count; i++) {
            a = S_man.get(i);
            a.list(i);
        }
    }
}