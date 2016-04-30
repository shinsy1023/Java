package Model;

import Module.Person;

/**
 * Created by shinsy1023 on 2016. 4. 10..
 */
public class Student extends Person {
    protected long S_number;
    protected String bokhak;

    public Student(String n, String s, String a, String Pnum, long Snum, String b){
        super(n, s, a, Pnum);
        this.S_number=Snum;
        this.bokhak=b;
    }

    public void list() {
        System.out.printf("%-10s%-16s%-8s%-30s%-16s%s\n", this.name, this.S_number, this.sex, this.address, this.P_number, this.bokhak);
    }

    public boolean search_name(String n){
        return this.name.contains(n);
    }

    public boolean search_address(String a){
        return this.address.contains(a);
    }

    public boolean search_bokhak(){
        return this.bokhak.contains("Y");
    }
}

