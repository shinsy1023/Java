import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by shinsy1023 on 2016. 5. 3..
 */
class S_manager {
    ArrayList<Student> list=new ArrayList<Student>();
    int i;
    String name;
    String P_num;
    String address;
    Scanner s = new Scanner(System.in);
    Student tmp=null;
    FileWriter fw=null;
    BufferedWriter bw=null;
    String words;

    public void saveFile(){
        try{
            fw=new FileWriter("/Users/shinsy1023/Desktop/소상2.txt");
            bw=new BufferedWriter(fw);
            for (i=0; i<list.size(); i++){
                tmp=list.get(i);
                words=tmp.toString();
                bw.write(words);
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(bw!=null) try{bw.close();}catch (IOException e){}
            if(fw!=null) try{fw.close();}catch (IOException e){}
        }
    }

    public void insert(){
        System.out.printf("이름 : ");
        name=s.next();
        System.out.printf("전화번호 : ");
        P_num=s.next();
        System.out.printf("주소 : ");
        s.nextLine();
        address=s.nextLine();
        tmp=new Student(name, P_num, address);
        list.add(tmp);
    }

    public void print(){
        for (i=0; i<list.size(); i++) {
            tmp = list.get(i);
            System.out.printf("%s\n", tmp);
        }
    }
}
