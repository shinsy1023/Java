/**
 * Created by shinsy1023 on 2016. 3. 29..
 */

public class test {
    public static void main(String [] args) {
        Point p = new Point(); // Point 객체 생성
        p.set(1, 2); // Point 클래스의 set() 호출
        p.showPoint();
        ColorPoint cp = new ColorPoint();
        cp.set(3, 4); // Point 클래스의 set() 호출
        cp.setColor("red"); // ColorPoint의 setColor() 호출
        cp.showColorPoint(); // 컬러와 좌표 출력
    }
}

class Point {
    private int x, y; // 한 점을 구성하는 x, y 좌표
    void set(int x, int y) {
        this.x = x; this.y = y;
    }
    void showPoint() { // 점의 좌표 출력
        System.out.println("(" + x + "," + y + ")");
    }
}
// Point를 상속받은 ColorPoint 선언
class ColorPoint extends Point {
    private String color; // 점의 색
    void setColor(String color) {
        this.color = color;
    }
    void showColorPoint() { // 컬러 점의 좌표 출력
        System.out.print(color);
        showPoint(); // Point의 showPoint() 호출
    }
}
