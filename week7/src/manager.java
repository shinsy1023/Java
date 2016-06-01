import java.io.*;
import java.util.*;

class manager {
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private File manager = null;
    private int i;
    private String direct, fileName, line;
    Scanner s = new Scanner(System.in);
    private ArrayList<String> file = new ArrayList<String>();
    private ArrayList<String> content = new ArrayList<String>();

    manager() {
        System.out.printf("출력할 폴더의 경로를 입력하세요");
        direct = s.next()+"/";
        manager = new File(direct);
        for (i = 0; i < manager.list().length; i++) {
            file.add(manager.list()[i]);
            System.out.printf("%s  ",manager.list()[i]);
        }
        System.out.println("");
    }

    public void readFile(){
        System.out.printf("읽어들일 파일명을 입력하세요 ");
        fileName=s.next();
        try{
            fr=new FileReader(direct+fileName);
            br=new BufferedReader(fr);
            while((line=br.readLine())!=null){
                content.add(line);
            }
        }
        catch (IOException e){
            System.out.println("파일이 존재하지 않습니다 새로운 파일을 생성합니다.");
        }
        finally {
            if(bw!=null) try{bw.close();}catch (IOException e){}
            if(fw!=null) try{fw.close();}catch (IOException e){}
        }
        System.out.println("프로그램을 시작합니다");
    }

    private void saveFile(){
        try{
            fw=new FileWriter(direct+fileName);
            bw=new BufferedWriter(fw);
            for (i=0; i<content.size(); i++){
                bw.write(content.get(i));
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
        System.out.printf("ID 입력 >>  ");
        line=s.next();
        System.out.printf("Password 입력 >>  ");
        line+="   "+s.next();
        System.out.printf("Comment 입력 >>  ");
        line+="   "+s.nextLine();
        content.add(line);
        saveFile();
    }

    public void print(){
        for (i=0; i<content.size(); i++) {
            System.out.println((i+1)+"번  "+content.get(i));
        }
    }

    public void delete(){
        System.out.printf("삭제할 항목의 번호를 입력하세요. >>  ");
        content.remove(s.nextInt()-1);
        saveFile();
    }
}
