import java.util.*;

/**
 * Created by shinsy1023 on 2016. 3. 29..
 */
public class Num2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;
        String findStr;
        String replaceStr;
        int i, j, count=0;
        int leng;
        while (true) {
            System.out.printf("문자열을 입력하세요.(x: 종료):");
            input = s.nextLine();
            if (input.equals("x")) {
                break;
            }
            leng = input.length();
            System.out.printf("찾을 문자열을 입력하세요 :");
            findStr = s.nextLine();
            System.out.printf("바꿀 문자열을 입력하세요. :");
            replaceStr = s.nextLine();
            for (i = 0; i < leng; i++) {
                j = i;
                i = input.indexOf(findStr, i + 2);
                if (i != j) {
                    count++;
                }
                if (i == (-1)) {
                    break;
                }
            }
            if (count != 0) {
                input=input.replaceAll(findStr, replaceStr);
            }
            System.out.printf("총 %d번 바뀌었습니다.\n%s\n", count, input);
        }
        System.out.printf("종료되었습니다.");
    }
}

