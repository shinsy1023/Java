import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by shinsy1023 on 2016. 5. 25..
 */
class View extends JFrame {
    Manager manager = null;
    JTextField id, pw, comment;
    JTextArea area;
    JButton regist, delete, list, exit;
    JMenuItem open, save;

    View() {
        //기본 정보
        setTitle("ID/PW Manage Program");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //메뉴바 설정
        JMenuBar fileCategory = new JMenuBar();
        JMenu file = new JMenu("File");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        file.add(open);
        file.add(save);
        fileCategory.add(file);
        setJMenuBar(fileCategory);

        //메인 컨텐트 팬 설정
        Container main = getContentPane();
        main.setLayout(new BorderLayout());

        //하단 패널
        JPanel below = new JPanel(new FlowLayout());
        main.add(below, BorderLayout.SOUTH);

        //하단 버튼 작성
        regist = new JButton("Regist");
        delete = new JButton("Delete");
        list = new JButton("List");
        exit = new JButton("Exit");
        below.add(regist);
        below.add(delete);
        below.add(list);
        below.add(exit);

        //좌측 패널
        JPanel left = new JPanel(new FlowLayout());
        main.add(left);

        //타이틀 보더
        TitledBorder leftTitle = new TitledBorder(new LineBorder(Color.BLACK), "Statement");
        leftTitle.setTitlePosition(leftTitle.DEFAULT_POSITION);
        left.setBorder(leftTitle);

        //텍스트 에리어
        area = new JTextArea(14, 18);
        area.setEditable(false);
        area.setText("ID         PW           COMMENT");
        left.add(area);

        //우측 패널
        JPanel right = new JPanel(new BorderLayout());
        main.add(right, BorderLayout.EAST);

        //타이틀 보더
        TitledBorder rightTitle = new TitledBorder(new LineBorder(Color.BLACK), "Input");
        rightTitle.setTitlePosition(rightTitle.DEFAULT_POSITION);
        right.setBorder(rightTitle);

        //우측 구역 패널
        JPanel leftRight = new JPanel(new BorderLayout(0, 85));
        JPanel rightRight = new JPanel(new BorderLayout(0, 85));
        right.add(leftRight, BorderLayout.WEST);
        right.add(rightRight, BorderLayout.EAST);

        //라벨
        leftRight.add(new JLabel("ID : "), BorderLayout.NORTH);
        leftRight.add(new JLabel("PW : "), BorderLayout.CENTER);
        leftRight.add(new JLabel("COMMENT : "), BorderLayout.SOUTH);

        //텍스트 필드
        id = new JTextField(8);
        pw = new JTextField(8);
        comment = new JTextField(8);
        rightRight.add(id, BorderLayout.NORTH);
        rightRight.add(pw, BorderLayout.CENTER);
        rightRight.add(comment, BorderLayout.SOUTH);

        //액션 설정
        open.addActionListener(new AL());
        save.addActionListener(new AL());
        regist.addActionListener(new AL());
        delete.addActionListener(new AL());
        list.addActionListener(new AL());
        exit.addActionListener(new AL());

        //마지막
        setVisible(true);
    }

    private class AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == regist) {
                if (manager.insert(id.getText(), pw.getText(), comment.getText())) {
                    area.setText("Don't input blank");
                } else {
                    id.setText("");
                    pw.setText("");
                    comment.setText("");
                }
            } else if (e.getSource() == delete) {
                if (manager.delete(comment.getText())) {
                    area.setText("Don't input blank");
                }
                comment.setText("");
            } else if (e.getSource() == list) {
                area.setText(manager.print());
            } else if (e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == open) {
                JFileChooser chooser = new JFileChooser();
                FileFilter txtFilter=new FileNameExtensionFilter("TXT Files", "txt");
                chooser.setCurrentDirectory(new File("/Users/shinsy1023/Desktop"));
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.addChoosableFileFilter(txtFilter);
                int result = chooser.showOpenDialog(new JFrame());
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    manager = new Manager(selectedFile.getAbsolutePath());
                }
            } else if (e.getSource() == save) {
                manager.saveFile();
            }
        }
    }
}