package test1;

import java.util.Scanner;

/**
 * Created by shinsy1023 on 2016. 5. 9..
 */
public class Run {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int choice;
        long startTime;
        long estimatedTime;
        boolean pass=true;
        DataStructure data=new DataStructure();
        while(true) {
            System.out.println("1)Linked list 2)Stack 3)Queue 4)Binary Tree");
            choice=s.nextInt();
            switch (choice) {
                case 1:
                    startTime = System.nanoTime();
                    if (data.link.search(data.rand.randList.get(75))) {
                        estimatedTime = System.nanoTime();
                        estimatedTime-=startTime;
                        System.out.println(estimatedTime + " ns");
                    }
                    break;
                case 2:
                    startTime = System.nanoTime();
                    if (data.s.search(data.rand.randList.get(75))) {
                        estimatedTime = System.nanoTime();
                        estimatedTime-=startTime;
                        System.out.println(estimatedTime + " ns");
                    }
                    break;
                case 3:
                    startTime = System.nanoTime();
                    if (data.q.search(data.rand.randList.get(75))) {
                        estimatedTime = System.nanoTime();
                        estimatedTime-=startTime;
                        System.out.println(estimatedTime + " ns");
                    }
                    break;
                case 4:
                    startTime = System.nanoTime();
                    if (data.b.search(data.rand.randList.get(75))) {
                        estimatedTime = System.nanoTime();
                        estimatedTime-=startTime;
                        System.out.println(estimatedTime + " ns");
                    }
                    break;
            }
        }
    }
}