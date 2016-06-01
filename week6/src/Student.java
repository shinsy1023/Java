/**
 * Created by shinsy1023 on 2016. 5. 3..
 */
class Student {
    String name;
    String P_num;
    String address;

    Student(String n, String p, String a){
        this.name=n;
        this.P_num=p;
        this.address=a;
    }

    @Override
    public String toString() {
        return this.name+"  "+this.P_num+"  "+this.address;
    }
}
