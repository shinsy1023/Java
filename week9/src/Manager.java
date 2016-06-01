/**
 * Created by shinsy1023 on 2016. 5. 25..
 */
import java.io.*;
import java.util.*;

class Manager {
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private int i;
    private String fileName, line;
    Scanner s = new Scanner(System.in);
    private ArrayList<String> content = new ArrayList<String>();

    Manager(String fileName) {
        try {
            this.fileName = fileName;
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            System.out.println("파일이 존재하지 않습니다 새로운 파일을 생성합니다.");
        } finally {
            if (bw != null) try {
                bw.close();
            } catch (IOException e) {
            }
            if (fw != null) try {
                fw.close();
            } catch (IOException e) {
            }
        }
        System.out.println("프로그램을 시작합니다");
    }

    protected void saveFile() {
        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            for (i = 0; i < content.size(); i++) {
                bw.write(content.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) try {
                bw.close();
            } catch (IOException e) {
            }
            if (fw != null) try {
                fw.close();
            } catch (IOException e) {
            }
        }
    }

    public boolean insert(String id, String pw, String comment) {
        if (id.equals("") && pw.equals("") && comment.equals("")) {
            return true;
        }
        line = id + "   " + pw + "   " + comment;
        content.add(line);
        return false;
    }

    public String print() {
        line = "ID         PW           COMMENT\n";
        for (i = 0; i < content.size(); i++) {
            line += content.get(i) + "\n";
        }
        return line;
    }

    public boolean delete(String comment) {
        if (comment.equals("")) {
            return true;
        }
        for (i = 0; i < content.size(); i++) {
            line = content.get(i);
            if (line.contains(comment)) {
                content.remove(i);
                return false;
            }
        }
        return true;
    }
}