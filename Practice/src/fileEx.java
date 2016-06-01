import java.io.*;

/**
 * Created by shinsy1023 on 2016. 5. 3..
 */
public class fileEx {
    public static void main(String[] args){
        InputStreamReader in = new InputStreamReader(System.in);
        FileWriter fout = null;
        int c;
        try{
            fout=new FileWriter("/Users/shinsy1023/Desktop/소상2.txt");
            fout.write("Hello, world!");
            in.close();
            fout.close();
        }
        catch (IOException e){
            System.out.printf("입출력 오류");
        }
    }
}
