import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by shinsy1023 on 2016. 5. 17..
 */
class manageProgram extends JFrame {
    manageProgram() {
        //기본 정보
        setTitle("ID/PW Manage Program");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //메뉴바 설정
        JMenuBar fileCategory = new JMenuBar();
        JMenu file = new JMenu("File");
        file.add(new JMenuItem("New File"));
        file.add(new JMenuItem("Save"));
        file.add(new JMenuItem("Open"));
        fileCategory.add(file);
        setJMenuBar(fileCategory);

        //메인 컨텐트 팬 설정
        Container main = getContentPane();
        main.setLayout(new BorderLayout());

        //하단 패널
        JPanel below = new JPanel(new FlowLayout());
        main.add(below, BorderLayout.SOUTH);

        //하단 버튼 작성
        below.add(new JButton("Regist"));
        below.add(new JButton("Delete"));
        below.add(new JButton("List"));
        below.add(new JButton("Exit"));

        //좌측 패널
        JPanel left = new JPanel(new FlowLayout());
        main.add(left);

        //타이틀 보더
        TitledBorder leftTitle = new TitledBorder(new LineBorder(Color.BLACK), "Statement");
        leftTitle.setTitlePosition(leftTitle.DEFAULT_POSITION);
        left.setBorder(leftTitle);

        //텍스트 에리어
        JTextArea area = new JTextArea(14, 18);
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
        rightRight.add(new JTextField(8), BorderLayout.NORTH);
        rightRight.add(new JTextField(8), BorderLayout.CENTER);
        rightRight.add(new JTextField(8), BorderLayout.SOUTH);

        //마지막
        setVisible(true);
    }
}